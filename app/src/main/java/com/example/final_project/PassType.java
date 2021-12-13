package com.example.final_project;

public class PassType {
    private String password;
    private String username;
    public PassType(String password,String username){
        this.password=password;
        this.username=username;
    }
    public String getPassword(){
        return this.password;
    }
    public String getUsername(){
        return this.username;
    }
}
