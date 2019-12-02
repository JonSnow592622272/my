package com.shotgun.my.web.util.newExcel;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author wulm
 * @desc
 **/
public interface ExcelWriter {

    /**
     * 添加sheet表
     */
    <T> SheetWriter<T> addSheet(String name, List<T> list);

    /**
     * 导出数据
     */
    void export(OutputStream outputStream) throws IOException;

    /**
     * 对wookbook处理并导出数据
     */
    void export(OutputStream outputStream, Consumer<Workbook> consumer) throws IOException;

}
