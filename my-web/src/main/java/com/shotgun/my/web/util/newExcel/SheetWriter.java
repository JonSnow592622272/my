package com.shotgun.my.web.util.newExcel;

import java.util.Map;
import java.util.function.Function;

/**
 * Created by keeley on 2016/12/26.
 */
public interface SheetWriter<T> {


    /**
     * 获取sheet名称
     */
    String getName();

    /**
     * 设置sheet的名称
     */
    SheetWriter<T> setName(String name);

    /**
     * 设置顶部标题内容
     */
    SheetWriter<T> setTopHead(String ColumnName);

    /**
     * 添加序号列（1,2,3.......）
     */
    SheetWriter<T> addIndexColumn(String ColumnName);

    /**
     * 添加一列空列
     */
    <K> SheetWriter<T> addColumn(String title);

    /**
     * 添加一列
     */
    <K> SheetWriter<T> addColumn(String title, Function<T, K> value);

    /**
     * 添加一列，并设置默认值
     */
    <K> SheetWriter<T> addColumn(String title, Function<T, K> value, String defaultValue);

    /**
     * 添加一列，并设置默认值，并映射文本
     */
    <K> SheetWriter<T> addColumn(String title, Function<T, K> value, String defaultValue,
            Map<K, String> valueMapping);


}
