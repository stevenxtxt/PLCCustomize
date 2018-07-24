package com.bsh.dt.plccustomize.model;

/**
 * Created by XuTe on 2018/6/4.
 */

public class Program extends BaseBean {
    private int programid;
    private String name;
    private int pictureVertical;
    private int pictureHorizontal;

    public int getProgramid() {
        return programid;
    }

    public void setProgramid(int programid) {
        this.programid = programid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPictureVertical() {
        return pictureVertical;
    }

    public void setPictureVertical(int pictureVertical) {
        this.pictureVertical = pictureVertical;
    }

    public int getPictureHorizontal() {
        return pictureHorizontal;
    }

    public void setPictureHorizontal(int pictureHorizontal) {
        this.pictureHorizontal = pictureHorizontal;
    }
}
