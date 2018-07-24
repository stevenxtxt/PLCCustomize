package com.bsh.dt.plccustomize.model;

/**
 * Created by XuTe on 2018/7/5.
 */

public class LayoutTemplate extends BaseBean {
    private int layouttype;
    private boolean isSelected;
    private int imgSelectedResource;
    private int imgNotSelectedResource;

    public int getLayouttype() {
        return layouttype;
    }

    public void setLayouttype(int layouttype) {
        this.layouttype = layouttype;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getImgSelectedResource() {
        return imgSelectedResource;
    }

    public void setImgSelectedResource(int imgSelectedResource) {
        this.imgSelectedResource = imgSelectedResource;
    }

    public int getImgNotSelectedResource() {
        return imgNotSelectedResource;
    }

    public void setImgNotSelectedResource(int imgNotSelectedResource) {
        this.imgNotSelectedResource = imgNotSelectedResource;
    }
}
