package com.example.final_project;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class settingProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_profile);
        SharedPreferences sharePreferences = getSharedPreferences("com.example.final_project", Context.MODE_PRIVATE);
        int age = Integer.parseInt(sharePreferences.getString("age",""));
        String sex = sharePreferences.getString("sex","");
        int weight = Integer.parseInt(sharePreferences.getString("weight",""));
        int height = Integer.parseInt(sharePreferences.getString("height",""));
        double bodyMassIndex = weight * 0.453592 / (Math.pow(((double)height/100),2));
        ArrayList<String> settingList = new ArrayList<>();
        settingList.add("Age                                                                "+age);
        settingList.add("Sex                                                                "+sex);
        settingList.add("Weight                                                          "+weight+"lb");
        settingList.add("Height                                                           "+height+"cm");
        settingList.add("Body Mass Index(BMI)                               "+String.format("%.2f", bodyMassIndex));


        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, settingList);
        ListView listView = (ListView) findViewById(R.id.settingList1);
        listView.setAdapter(adapter);
    }

    public void clickFunction(View view){
        Intent intent = new Intent(this, MainSetting.class);
        startActivity(intent);
    }
}