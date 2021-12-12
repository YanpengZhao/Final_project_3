package com.example.final_project;

import java.io.Serializable;

public class FoodType implements Serializable {
    private String food;
    private String category;
    private String calory;
    private String serving;
    private String date;
    private String username;
    private String pr;
    private String nc;
    private String ft;
    public  FoodType(String food, String category,String calory,String serving,String date,String username,String pr,String nc,String ft){
        this.food=food;
        this.category=category;
        this.calory=calory;
        this.serving=serving;
        this.date=date;
        this.username=username;
        this.pr=pr;
        this.nc=nc;
        this.ft=ft;
    }
    public String getFood(){
        return food;
    }
    public String getCategory(){
        return category;
    }
    public String getCalory(){
        return calory;
    }
    public String getServing(){
        return serving;
    }
    public String getDate(){
        return date;
    }
    public String getUsername(){
        return username;
    }
    public String getPr(){
        return pr;
    }
    public String getNc(){
        return nc;
    }
    public String getFt(){
        return ft;
    }

}
