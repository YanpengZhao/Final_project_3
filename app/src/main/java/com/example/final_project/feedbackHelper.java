package com.example.final_project;

public class feedbackHelper {
    String MainProblem;
    String Description;

    public feedbackHelper(String a, String b){
        this.MainProblem = a;
        this.Description = b;
    }

    public String getMainProblem(){
        return this.MainProblem;
    }

    public String getDescription(){
        return this.Description;
    }
}
