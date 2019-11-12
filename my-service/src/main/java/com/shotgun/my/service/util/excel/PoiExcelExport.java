package com.shotgun.my.service.util.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author wulm
 * @version 1.0.0
 * @desc
 */
public class PoiExcelExport extends ExcelExport {

    private PoiExcelExport() {
    }

    public static void getExport(OutputStream outputStream,
            Consumer<PoiExcelExport> consumer) throws IOException {
        PoiExcelExport poiExcelExport = new PoiExcelExport();
        poiExcelExport.outputStream = outputStream;
        consumer.accept(poiExcelExport);
        poiExcelExport.start();
    }

    public static void getExport(InputStream inputStream, OutputStream outputStream,
            Consumer<PoiExcelExport> consumer) throws IOException {
        PoiExcelExport poiExcelExport = new PoiExcelExport();
        poiExcelExport.inputStream = inputStream;
        poiExcelExport.outputStream = outputStream;
        consumer.accept(poiExcelExport);
        poiExcelExport.start();
    }

    @Override
    public void start() throws IOException {
        //适配无模板和有模板两种方式

        Integer count = super.exportConfigs.stream()
                .map(config -> config.getExports() == null ? 0 : config.getExports().size())
                .reduce((i, i2) -> i + i2).orElse(0);

        Workbook wb;
        if (super.inputStream != null) {
            wb = PoiExcelImport.newWorkbookTemplate(inputStream);
        } else {
            if (count > 10000) {
                wb = newWorkbook2007xlsxBigData();
            } else {
                wb = newWorkbook2007xlsx();
            }
        }


        exportConfigs.forEach(config -> {
            //存在则获取，不存在则创建sheet
            Sheet sheet;

            if (config.getIsUseIndexGetSheet()) {
                if (wb.getNumberOfSheets() > config.getSheetIndex()) {
                    sheet = wb.getSheetAt(config.getSheetIndex());
                } else {
                    sheet = wb.createSheet();
                }
            } else {
                sheet = wb.getSheet(config.getSheetName());
                if (sheet == null) {
                    sheet = wb.createSheet(config.getSheetName());
                }
            }

            // 设置表头
            setData(sheet, config.getStartRowIndex(), config.getHeaders());
            // 设置表数据
            setData(sheet,
                    config.getStartRowIndex() + Optional.ofNullable(config.getHeaders()).map(List::size)
                            .orElse(0), config.getExports());

        });

        // 写入文件并关闭流
        IOUtils.writeAndClose(wb, super.outputStream);
    }

    /**
     * @return
     * @desc 创建Workbook
     * @auth wulm
     * @date 2018年7月4日 下午5:03:09
     */
    public Workbook newWorkbook2007xlsx() {
        return new XSSFWorkbook();
    }

    /**
     * @return
     * @desc 创建Workbook，应对大数据导出
     * @auth wulm
     * @date 2018年7月4日 下午5:06:47
     */
    public Workbook newWorkbook2007xlsxBigData() {
        // 每1000条数据刷新到硬盘缓存
        return new SXSSFWorkbook(1000);
    }


    public static void setData(Sheet sheet, int startRowIndex, List<?> objectList) {
        Assert.notNull(sheet, "sheet表格不能为空");
        Assert.isTrue(startRowIndex >= 0, "startRowIndex必须大于等于0");
        if (objectList == null || objectList.isEmpty()) {
            return;
        }

        // 注意：这里不能提取到for循环里面
        int rowIndex = startRowIndex;
        for (int i = 0; i < objectList.size(); i++) {

            Row row = getRowOrCreateOnNull(sheet, rowIndex);
            Object obj = objectList.get(i);
            if (obj instanceof List) {
                List<Object> cellList = (List<Object>) obj;

                if (!cellList.isEmpty()) {
                    for (int j = 0; j < cellList.size(); j++) {
                        Cell cell = getCellOrCreateOnNull(row, j);
                        setCellValue(cell, cellList.get(j));
                        // cell.setCellStyle(row.getRowStyle());
                    }
                }
            } else if (obj instanceof Map) {
                Map<String, Object> cellMap = (Map<String, Object>) obj;

                if (!cellMap.isEmpty()) {
                    int j = 0;
                    for (Object value : cellMap.values()) {
                        Cell cell = getCellOrCreateOnNull(row, j);
                        setCellValue(cell, value);
                        // cell.setCellStyle(row.getRowStyle());
                        j++;
                    }
                }
            } else {
                throw new IllegalArgumentException("尚未开发！！！");
            }
            rowIndex++;
        }
    }

    private static Row getRowOrCreateOnNull(Sheet sheet, int rowIndex) {
        Row row = sheet.getRow(rowIndex);
        if (row == null) {
            // 如果行不存在，则创建行
            row = sheet.createRow(rowIndex);
        }
        return row;
    }

    private static Cell getCellOrCreateOnNull(Row row, int j) {
        Cell cell = row.getCell(j);
        if (cell == null) {
            // 如果列不存在，则创建列
            cell = row.createCell(j);
        }
        return cell;
    }

    private static void setCellValue(Cell cell, Object cellValue) {
        if (cellValue instanceof Date) {
            SimpleDateFormat.getDateTimeInstance();
            cell.setCellValue(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((Date) cellValue));
        } else {
            cell.setCellValue(cellValue.toString());
        }
    }
}