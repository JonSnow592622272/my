package com.shotgun.my.web.util.excel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * @author wulm
 * @version 1.0.0
 * @desc
 */
public class PoiExcelImport extends ExcelImport {

    private PoiExcelImport() {
    }

    public static void getImport(InputStream inputStream,
            Consumer<PoiExcelImport> consumer) throws IOException {
        PoiExcelImport poiImport = new PoiExcelImport();
        poiImport.inputStream = inputStream;
        consumer.accept(poiImport);
        poiImport.start();
    }

    @Override
    public void start() throws IOException {
        Workbook wb = newWorkbookTemplate(super.inputStream);

        super.importConfigs.forEach(config -> {

            Sheet sheet;
            if (config.getIsUseIndexGetSheet()) {
                sheet = wb.getSheetAt(config.getSheetIndex());
            } else {
                sheet = wb.getSheet(config.getSheetName());
            }

            // getLastRowNum 如果sheet中一行数据都没有则返回-1，只有第一行有数据则返回0，最后有数据的行是第n行则返回 n-1；
            int lastRowNum = sheet.getLastRowNum() + 1;
            Integer startRowIndex = config.getStartRowIndex();
            List parseList = new ArrayList(lastRowNum <= startRowIndex ? 0 : lastRowNum - startRowIndex);

            IntStream.range(startRowIndex, lastRowNum).forEach(i -> {

                Row row = sheet.getRow(i);
                Object o;
                try {
                    o = config.getClazz().newInstance();
                } catch (InstantiationException | IllegalAccessException e) {
                    throw new RuntimeException("实例化异常");
                }
                //解析行到对象.............


                parseList.add(o);
            });

            config.getConsumer().accept(parseList);
        });

        // 关闭流
        wb.close();
    }

    /**
     * @param inputStream 模板
     * @return
     * @desc 创建Workbook 使用模板 (也可以用于编辑excel)
     * @auth wulm
     */
    public static Workbook newWorkbookTemplate(InputStream inputStream) {
        try {
            return WorkbookFactory.create(inputStream);
        } catch (IOException | InvalidFormatException e) {
            throw new RuntimeException("读取模板失败!!!!!!!!!!!!!!!!!!!请检查!!!!", e);
        }
    }

}