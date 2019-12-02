package com.shotgun.my.web.util.newExcel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author wulm
 * @desc
 **/
public class AbstractExcel implements Excel {

    private List<Consumer<AbstractExcel>> steps;


    void setFileI(InputStream inputStream) {

    }


    @Override
    public Excel setFile(InputStream inputStream) {
        setFileI(inputStream);
        Consumer<AbstractExcel> a = s -> {

        };


        return this;
    }

    @Override
    public void getOrCreateSheet(String sheetname) {

    }

    @Override
    public Excel export(OutputStream outputStream) throws IOException {
        return null;
    }

    @Override
    public void execute() {

    }
}
