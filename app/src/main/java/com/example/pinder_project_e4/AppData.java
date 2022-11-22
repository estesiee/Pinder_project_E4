package com.example.pinder_project_e4;

import java.util.ArrayList;

public class AppData {
    private ArrayList list;
    private static AppData instance;

    private AppData(){};
    public ArrayList getList() {return this.list;}
    public void setList(ArrayList list) {this.list = list;}

    public static AppData getInstance() {
        if (instance == null) {
            instance = new AppData();
        }
        return instance;
    }
}
    //Call this in your activity
    //List list = AppData.getInstace().getList();