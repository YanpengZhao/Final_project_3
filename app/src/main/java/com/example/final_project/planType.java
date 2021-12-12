package com.example.final_project;

import java.io.Serializable;

public class planType implements Serializable {
    private String calory;
    private String username;
    public planType(String calory,String  username){
        this.calory=calory;
        this.username=username;
    }
    public String getCalory(){
        return this.calory;
    }
    public String getUsername(){
        return this.username;
    }
}
