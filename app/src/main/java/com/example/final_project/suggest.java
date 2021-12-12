package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class suggest extends AppCompatActivity {
    static String height;
    static String weight;
    static String age;
    static String sex;
    TextView textview;
    TextView textview2;
    TextView textview3;
    TextView textview4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest);
        Context context=getApplicationContext();
        SQLiteDatabase sqLiteDatabase=context.openOrCreateDatabase("foodType",Context.MODE_PRIVATE,null);
        DBHelper dbHelper=new DBHelper(sqLiteDatabase);
        SharedPreferences sharedPreferences=getSharedPreferences("com.example.final_project",Context.MODE_PRIVATE);
        String str=sharedPreferences.getString(MainActivity.usernameKey,"");
        String username=str;
        height=sharedPreferences.getString(MainActivity.height,"");
        weight=sharedPreferences.getString(MainActivity.weight,"");
        age=sharedPreferences.getString(MainActivity.age,"");
        sex=sharedPreferences.getString(MainActivity.sex,"");
        textview=(TextView)findViewById(R.id.textView5);
        String tx1=String.format("Due to your weight: %1$s,height: %2$s, age: %3$s and sex: %4$s",height,weight,age,sex);
        textview.setText(tx1);
        textview2=(TextView)findViewById(R.id.textView6);
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
        textview2.setText("Your suggested calory intake per day is "+e1+" cal");
        textview3=(TextView) findViewById(R.id.textView7);
        ArrayList<planType>planTypes= dbHelper.getPlan(username);
        double pu=0;
        if (planTypes.size()!=0){
            pu=Double.valueOf(planTypes.get(planTypes.size()-1).getCalory());
        }
        Log.d("b",pu+"");
        String t3=String.format("You want to lose %s pounds per week",pu);
        textview3.setText(t3);
        Log.d("c",planTypes.toString());
        int f=(int)(e-500*Double.valueOf(pu));
        sharedPreferences.edit().putString("CaloriePerDay",String.valueOf(f)).apply();
        textview4=(TextView)findViewById(R.id.textView8);
        String t4="Your new siggested calory intake is "+f+" cal";
        textview4.setText(t4);

    }
    public void back(View view){
        Intent intent=new Intent(this,MainActivity2.class);
        startActivity(intent);
    }
}