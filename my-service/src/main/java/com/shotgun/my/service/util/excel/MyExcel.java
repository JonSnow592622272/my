package com.shotgun.my.service.util.excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wulm
 * @date 2019/11/1 10:57
 **/
public interface MyExcel {

    public static final Integer FIST_SHEET_INDEX = 0;
    public static final Integer IMPORT_DEFAULT_START_ROW_INDEX = 1;
    public static final Integer EXPORT_DEFAULT_START_ROW_INDEX = 0;

    public class ExcelBaseConfig {
        /*是否使用索引获取sheet，true：使用sheetIndex获取；false：使用sheetName获取*/
        private Boolean isUseIndexGetSheet;
        private Integer sheetIndex;
        private String sheetName;
        private Integer startRowIndex;


        public Boolean getIsUseIndexGetSheet() {
            return isUseIndexGetSheet;
        }

        public void setIsUseIndexGetSheet(Boolean isUseIndexGetSheet) {
            this.isUseIndexGetSheet = isUseIndexGetSheet;
        }

        public Integer getSheetIndex() {
            return sheetIndex;
        }

        public void setSheetIndex(Integer sheetIndex) {
            this.sheetIndex = sheetIndex;
        }

        public String getSheetName() {
            return sheetName;
        }

        public void setSheetName(String sheetName) {
            this.sheetName = sheetName;
        }

        public Integer getStartRowIndex() {
            return startRowIndex;
        }

        public void setStartRowIndex(Integer startRowIndex) {
            this.startRowIndex = startRowIndex;
        }
    }

    /**
     * @author wulm
     * @desc 执行渲染
     * @date 2019/11/5 15:28
     **/
    public abstract void start() throws IOException;

    public static void main(String[] args) throws IOException {

//        final List<User>[] us = new List[]{new ArrayList<>()};
//
//
//        PoiExcelImport.getImport(null, poiExcelImport -> poiExcelImport.importSheet(User.class, users -> {
//
//            us[0] = users;
//
//        }).importSheet(UserServiceImpl.class, userServices -> {
//
//        }));

        List<Map<String, Object>> a = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("wocao1", 1);
            map.put("wocao2", 2);
            map.put("wocao3", 3);
            map.put("wocao4", 4);
            a.add(map);
        }


        PoiExcelExport.getExport(new FileInputStream("D:/wocao.xlsx"), new FileOutputStream("D:/wocao2.xlsx"),
                poiExcelExport -> poiExcelExport.exportSheet("zhutou", a).exportSheet("zhutou3", a)
                        .exportSheet("zhutou3", a).exportSheet("zhutou3", a).exportSheet("zhutou3", a)
                        .exportSheet("zhutou3", a));

    }


}