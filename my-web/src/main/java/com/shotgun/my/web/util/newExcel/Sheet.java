package com.shotgun.my.web.util.newExcel;

import java.util.function.Function;

/**
 * Created by keeley on 2016/12/26.
 */
public interface Sheet<T> {

    /**
     * 设置sheet的名称
     */
    Sheet<T> setName(String name);

    /**
     * 获取sheet名称
     */
    String getName();

    /**
     * 添加序号列（1,2,3.......）
     */
    Sheet<T> addIndexColumn(String ColumnName);

    /**
     * 添加一列
     */
    <K> Sheet<T> addColumn(String title, Function<T, K> value);

    /**
     * 添加一列
     */
    <K> Sheet<T> addColumn(String title, Function<T, K> value, String defaultValue, String... map);


}
