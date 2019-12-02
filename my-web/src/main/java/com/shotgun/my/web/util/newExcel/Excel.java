package com.shotgun.my.web.util.newExcel;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author wulm
 * @desc
 **/
public interface Excel {

//    /**
//     * 添加sheet表
//     */
//    <T> Sheet<T> addSheet(String name, List<T> list);

    /**
     * @author wulm
     * @desc 设置导入文件或导出的模板文件
     **/
    Excel setFile(InputStream inputStream);

    void getOrCreateSheet(String sheetname);

    /**
     * @author wulm
     * @desc 导出数据
     **/
    Excel export(OutputStream outputStream);

//    /**
//     * @author wulm
//     * @desc 对wookbook处理并导出数据
//     **/
//    Excel export(OutputStream outputStream, Consumer<Workbook> consumer) throws IOException;

    /**
     * @author wulm
     * @desc 执行
     **/
    void execute();
}
