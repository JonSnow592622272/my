package com.shotgun.my.web.util.excel;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @author wulm
 * @version 1.0.0
 * @desc
 */
public class ExcelExportMapping<T> {

    private List<String> titles;
    private Map<String, Function<T, ?>> titless;


    public ExcelExportMapping addColumn() {

        return this;
    }

}