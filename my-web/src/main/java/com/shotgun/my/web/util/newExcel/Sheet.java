package com.shotgun.my.web.util.newExcel;

import java.util.Map;
import java.util.function.Function;

/**
 * Created by keeley on 2016/12/26.
 */
public interface Sheet<T> {


    /**
     * 获取sheet名称
     */
    String getName();

    /**
     * 设置sheet的名称
     */
    Sheet<T> setName(String name);

    /**
     * 设置顶部标题内容
     */
    Sheet<T> setTopHead(String ColumnName);

    /**
     * 添加序号列（1,2,3.......）
     */
    Sheet<T> addIndexColumn(String ColumnName);

    /**
     * 添加一列空列
     */
    <K> Sheet<T> addColumn(String title);

    /**
     * 添加一列
     */
    <K> Sheet<T> addColumn(String title, Function<T, K> value);

    /**
     * 添加一列，并设置默认值
     */
    <K> Sheet<T> addColumn(String title, Function<T, K> value, String defaultValue);

    /**
     * 添加一列，并设置默认值，并映射文本
     */
    <K> Sheet<T> addColumn(String title, Function<T, K> value, String defaultValue,
            Map<K, String> valueMapping);


}
