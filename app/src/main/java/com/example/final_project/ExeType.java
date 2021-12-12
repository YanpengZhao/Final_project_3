package com.example.final_project;

import java.io.Serializable;

public class ExeType implements Serializable {
    private String exe;
    private String calory;
    private String unit;
    private String username;
    private String  date;
    public ExeType(String exe,String calory, String unit,String  username, String date){
        this.exe=exe;
        this.calory=calory;
        this.unit=unit;
        this.username=username;
        this.date=date;
    }
    public String getExe(){
        return this.exe;
    }
    public String getCalory(){
        return this.calory;
    }
    public String getUnit(){
        return this.unit;
    }
    public String getUsername(){
        return this.username;
    }
    public String getDate(){
        return this.date;
    }

}
