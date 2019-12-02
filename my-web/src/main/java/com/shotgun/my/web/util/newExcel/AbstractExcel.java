package com.shotgun.my.web.util.newExcel;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author wulm
 * @desc
 **/
public abstract class AbstractExcel implements Excel {

    private List<Consumer<AbstractExcel>> steps = new ArrayList<>();


    abstract void setFileI(InputStream inputStream);


    abstract void exportI(OutputStream outputStream);

    @Override
    public Excel setFile(InputStream inputStream) {
        steps.add(ae -> ae.setFileI(inputStream));
        return this;
    }

    @Override
    public void getOrCreateSheet(String sheetname) {

    }

    @Override
    public Excel export(OutputStream outputStream) {
        steps.add(ae -> ae.exportI(outputStream));
        return this;
    }

    @Override
    public void execute() {

    }
}
