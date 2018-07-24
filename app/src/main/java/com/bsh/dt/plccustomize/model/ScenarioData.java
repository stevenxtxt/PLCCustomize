package com.bsh.dt.plccustomize.model;

/**
 * Created by XuTe on 2018/7/3.
 */

public class ScenarioData {
    private int scenarioId;
    private int resourceId;
    private boolean isSelected;
    private Data data;

    public ScenarioData(int scenarioId, int resourceId, boolean isSelected) {
        this.scenarioId = scenarioId;
        this.resourceId = resourceId;
        this.isSelected = isSelected;
    }

    public int getScenarioId() {
        return scenarioId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
