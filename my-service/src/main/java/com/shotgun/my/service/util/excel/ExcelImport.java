package com.shotgun.my.service.util.excel;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author wulm
 * @version 1.0.0
 * @desc
 */
public abstract class ExcelImport implements MyExcel {

    protected InputStream inputStream;
    protected List<ExcelImportConfig> importConfigs = new ArrayList<>();

    public class ExcelImportConfig<T> extends MyExcel.ExcelBaseConfig {
        private Class<T> clazz;
        private Consumer<List<T>> consumer;

        public Class<T> getClazz() {
            return clazz;
        }

        public void setClazz(Class<T> clazz) {
            this.clazz = clazz;
        }

        public Consumer<List<T>> getConsumer() {
            return consumer;
        }

        public void setConsumer(Consumer<List<T>> consumer) {
            this.consumer = consumer;
        }
    }


    public <T> ExcelImport importSheet(Class<T> clazz, Consumer<List<T>> consumer) {
        return importSheet(FIST_SHEET_INDEX, IMPORT_DEFAULT_START_ROW_INDEX, clazz, consumer);
    }

    public <T> ExcelImport importSheet(Integer sheetIndex, Integer startRowIndex, Class<T> clazz,
            Consumer<List<T>> consumer) {
        return importSheet(true, sheetIndex, null, startRowIndex, clazz, consumer);
    }

    public <T> ExcelImport importSheet(String sheetName, Integer startRowIndex, Class<T> clazz,
            Consumer<List<T>> consumer) {
        return importSheet(false, null, sheetName, startRowIndex, clazz, consumer);
    }


    public <T> ExcelImport importSheet(Integer sheetIndex, Class<T> clazz, Consumer<List<T>> consumer) {
        return importSheet(true, sheetIndex, null, IMPORT_DEFAULT_START_ROW_INDEX, clazz, consumer);
    }

    public <T> ExcelImport importSheet(String sheetName, Class<T> clazz, Consumer<List<T>> consumer) {
        return importSheet(false, null, sheetName, IMPORT_DEFAULT_START_ROW_INDEX, clazz, consumer);
    }


    private <T> ExcelImport importSheet(Boolean isUseIndexGetSheet, Integer sheetIndex, String sheetName,
            Integer startRowIndex, Class<T> clazz, Consumer<List<T>> consumer) {
        ExcelImportConfig<T> ic = new ExcelImportConfig<>();
        ic.setIsUseIndexGetSheet(isUseIndexGetSheet);
        ic.setSheetIndex(sheetIndex);
        ic.setSheetName(sheetName);
        ic.setStartRowIndex(startRowIndex);
        ic.setClazz(clazz);
        ic.setConsumer(consumer);
        importConfigs.add(ic);
        return this;
    }

}