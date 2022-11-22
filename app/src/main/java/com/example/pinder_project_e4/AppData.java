package com.example.pinder_project_e4;

import java.util.ArrayList;

public class AppData {
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private ArrayList<String> list2 = new ArrayList<String>();
    private static AppData instance;

    private AppData(){};
    public ArrayList getList() {
        return this.list;
    }
    public void setList(ArrayList list) {
        this.list = list;
    }
    public ArrayList getList2() {
        return this.list2;
    }
    public void setList2(ArrayList list2) {
        this.list2 = list2;
    }

    public static AppData getInstance() {
        if (instance == null) {
            instance = new AppData();
        }
        return instance;
    }
}