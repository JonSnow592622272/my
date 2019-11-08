package com.shotgun.my.web.util.excel;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wulm
 * @version 1.0.0
 * @desc
 */
public abstract class ExcelExport implements MyExcel {

    protected InputStream inputStream;
    protected OutputStream outputStream;
    protected List<ExcelExportConfig> exportConfigs = new ArrayList<>();


    public class ExcelExportConfig extends MyExcel.ExcelBaseConfig {
        List<String[]> headers;
        List exports;

        public List<String[]> getHeaders() {
            return headers;
        }

        public void setHeaders(List<String[]> headers) {
            this.headers = headers;
        }

        public List getExports() {
            return exports;
        }

        public void setExports(List exports) {
            this.exports = exports;
        }
    }


    public ExcelExport exportSheet(List<?> exports) {
        return superExportSheet(true, FIST_SHEET_INDEX, null, EXPORT_DEFAULT_START_ROW_INDEX, null, exports);
    }

    public ExcelExport exportSheet(List<String[]> headers, List<?> exports) {
        return superExportSheet(true, FIST_SHEET_INDEX, null, EXPORT_DEFAULT_START_ROW_INDEX, headers,
                exports);
    }

    public ExcelExport exportSheet(Integer sheetIndex, List<?> exports) {
        return superExportSheet(true, sheetIndex, null, EXPORT_DEFAULT_START_ROW_INDEX, null, exports);
    }

    public ExcelExport exportSheet(Integer sheetIndex, List<String[]> headers, List<?> exports) {
        return superExportSheet(true, sheetIndex, null, EXPORT_DEFAULT_START_ROW_INDEX, headers, exports);
    }

    public ExcelExport exportSheet(String sheetName, List<?> exports) {
        return superExportSheet(false, null, sheetName, EXPORT_DEFAULT_START_ROW_INDEX, null, exports);
    }

    public ExcelExport exportSheet(String sheetName, List<String[]> headers, List<?> exports) {
        return superExportSheet(false, null, sheetName, EXPORT_DEFAULT_START_ROW_INDEX, headers, exports);
    }


    public ExcelExport exportSheet(Integer sheetIndex, Integer startRowIndex, List<?> exports) {
        return superExportSheet(true, sheetIndex, null, startRowIndex, null, exports);
    }

    public ExcelExport exportSheet(Integer sheetIndex, Integer startRowIndex, List<String[]> headers,
            List<?> exports) {
        return superExportSheet(true, sheetIndex, null, startRowIndex, headers, exports);
    }

    public ExcelExport exportSheet(String sheetName, Integer startRowIndex, List<?> exports) {
        return superExportSheet(false, null, sheetName, startRowIndex, null, exports);
    }


    public ExcelExport exportSheet(String sheetName, Integer startRowIndex, List<String[]> headers,
            List<?> exports) {
        return superExportSheet(false, null, sheetName, startRowIndex, headers, exports);
    }


    /**
     * @param isUseIndexGetSheet 是否使用模板
     * @param sheetIndex         sheet下标记
     * @param sheetName          sheet表名
     * @param startRowIndex      开始行下标
     * @param headers            头部内容
     * @param exports            导出内容（支持类型：List<Vo>,List<String[]>,List<Map<String,Object>>,
     *                           List<List<Object>>,）
     * @return
     * @author wulm
     * @desc 导出
     * @date 2019/11/5 19:24
     **/
    private ExcelExport superExportSheet(Boolean isUseIndexGetSheet, Integer sheetIndex, String sheetName,
            Integer startRowIndex, List<String[]> headers, List<?> exports) {

        ExcelExportConfig ec = new ExcelExportConfig();
        ec.setIsUseIndexGetSheet(isUseIndexGetSheet);
        ec.setSheetIndex(sheetIndex);
        ec.setSheetName(sheetName);
        ec.setStartRowIndex(startRowIndex);
        ec.setExports(exports);
        ec.setHeaders(headers);
        exportConfigs.add(ec);
        return this;
    }


}