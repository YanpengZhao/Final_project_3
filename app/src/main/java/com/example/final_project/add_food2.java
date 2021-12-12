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
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class add_food2 extends AppCompatActivity {
    FoodType curFood;
    TextView textview;
    TextView textview2;
    TextView textview3;
    EditText ed1;
    String gotten;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food2);
        curFood=(FoodType) getIntent().getSerializableExtra("food");
        textview=(TextView)findViewById(R.id.nameF);
        textview.setText(curFood.getFood());
        textview2=(TextView)findViewById(R.id.calF);
        textview2.setText(curFood.getCalory());
        textview3=(TextView) findViewById(R.id.serF);
        textview3.setText(curFood.getServing());
        ed1=(EditText)findViewById(R.id.servesizeEn);
        gotten=ed1.getText().toString();
    }
    public void add_back(View view){
        ed1=(EditText)findViewById(R.id.servesizeEn);
        gotten=ed1.getText().toString();
        String name=curFood.getFood();
        String calory=curFood.getCalory();
        Log.d("cccccccccc",calory);
        String serving=curFood.getServing();
        String category=curFood.getCategory();
        String pr=curFood.getPr();
        String nc=curFood.getNc();
        String ft=curFood.getFt();
        Context context=getApplicationContext();
        SQLiteDatabase sqLiteDatabase=context.openOrCreateDatabase("foodType",Context.MODE_PRIVATE,null);
        DBHelper dbHelper=new DBHelper(sqLiteDatabase);
        SharedPreferences sharedPreferences=getSharedPreferences("com.example.final_project",Context.MODE_PRIVATE);
        String str=sharedPreferences.getString(MainActivity.usernameKey,"");
        String username=str;
        DateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String date = dateFormat.format(new Date());
        Pattern pattern = Pattern.compile("(^(-?)(0|([1-9][0-9]*))(\\.[0-9]+)?)(([a-z]|[A-Z])+)$");
        Matcher matcher = pattern.matcher(serving);
        double base=0;
        String unit="";
        if (matcher.find())
        {
            base=Double.valueOf(matcher.group(1).toString());
            unit=matcher.group(6).toString();
        }
        Matcher matcher1=pattern.matcher(gotten);
        double got1=0;
        Log.d("ddddddddd",gotten);

        got1=Double.valueOf(gotten);
        Matcher matcher2=pattern.matcher(calory);
        double got2=0;
        got2=Double.valueOf(calory);
        double res=got1*base;
        double cal=got1*got2;
        serving=res+"";
        calory=cal+"";
        Log.d("",calory);
        sharedPreferences.edit().putString("date",date).apply();
        dbHelper.insertFood(name,category,calory,serving,date,username,pr,nc,ft);
        Intent intent=new Intent(this,MainActivity2.class);
        startActivity(intent);
    }

}