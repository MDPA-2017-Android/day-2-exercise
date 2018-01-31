package com.lasalle.mdpa.architecture.model;

public class Item {

    private String firstText;
    private String secondText;

    public Item(String firstText, String secondText) {
        this.firstText = firstText;
        this.secondText = secondText;
    }

    public String getFirstText() {
        return firstText;
    }

    public void setFirstText(String firstText) {
        this.firstText = firstText;
    }

    public String getSecondText() {
        return secondText;
    }

    public void setSecondText(String secondText) {
        this.secondText = secondText;
    }
}
