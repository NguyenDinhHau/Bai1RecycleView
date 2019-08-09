package com.example.recycleview;

import java.util.ArrayList;

public class SectionDataModel {
    private String headTitle;
    private ArrayList<SingleItemModel> allItemInSection;

    public SectionDataModel() {
    }

    public String getHeadTitle() {
        return headTitle;
    }

    public void setHeadTitle(String headTitle) {
        this.headTitle = headTitle;
    }

    public ArrayList<SingleItemModel> getAllItemInSection() {
        return allItemInSection;
    }

    public void setAllItemInSection(ArrayList<SingleItemModel> allItemInSection) {
        this.allItemInSection = allItemInSection;
    }

    public SectionDataModel(String headTitle, ArrayList<SingleItemModel> allItemInSection) {
        this.headTitle = headTitle;
        this.allItemInSection = allItemInSection;
    }
}
