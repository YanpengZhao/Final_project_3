package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;

import java.util.ArrayList;

public class add_plan extends AppCompatActivity {
    planType plan;
    String gotten;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plan);
        String[] data=new String[100];
        for(int i=0;i<100;i++){
            data[i]= ""+i;
        }
        NumberPicker picker=findViewById(R.id.np1);
        picker.setMinValue(0);
        picker.setMaxValue(data.length-1);
        picker.setDisplayedValues(data);
    }
    public void add_back3(View view){
        Context context=getApplicationContext();
        SQLiteDatabase sqLiteDatabase=context.openOrCreateDatabase("foodType",Context.MODE_PRIVATE,null);
        DBHelper dbHelper=new DBHelper(sqLiteDatabase);
        SharedPreferences sharedPreferences=getSharedPreferences("com.example.final_project", Context.MODE_PRIVATE);
        String str=sharedPreferences.getString(MainActivity.usernameKey,"");
        String username=str;
        NumberPicker prN=(NumberPicker) findViewById(R.id.np1);
        gotten=prN.getValue()+"";
        Log.d("a",gotten);
        dbHelper.insertPlan(gotten,username);
        String height=sharedPreferences.getString(MainActivity.height,"");
        String weight=sharedPreferences.getString(MainActivity.weight,"");
        String age=sharedPreferences.getString(MainActivity.age,"");
        String sex=sharedPreferences.getString(MainActivity.sex,"");
        double a=6.23;
        double b=12.7;
        double c=6.8;
        double d=66;
        if(sex=="female"){
            a=4.35;
            b=4.7;
            c=4.7;
            d=665;
        }
        double e=Double.valueOf(weight)*a+Double.valueOf(height)*b-Double.valueOf(age)*c+d;
        int e1=(int)e;
        ArrayList<planType> planTypes= dbHelper.getPlan(username);
        double pu=0;
        if (planTypes.size()!=0){
            pu=Double.valueOf(planTypes.get(planTypes.size()-1).getCalory());
        }
        int f=(int)(e-500*Double.valueOf(pu));
        sharedPreferences.edit().putString("CaloriePerDay",String.valueOf(f)).apply();
        Intent intent=new Intent(this,MainActivity2.class);
        startActivity(intent);

    }
}