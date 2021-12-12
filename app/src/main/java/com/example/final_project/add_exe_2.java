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
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class add_exe_2 extends AppCompatActivity {

    ExeType curFood;
    TextView textview;
    TextView textview2;
    TextView textview3;
    EditText ed1;
    String gotten;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exe2);
        curFood=(ExeType) getIntent().getSerializableExtra("food");
        textview=(TextView)findViewById(R.id.nameF2);
        textview.setText(curFood.getExe());
        textview2=(TextView)findViewById(R.id.calF2);
        textview2.setText(curFood.getCalory());
        textview3=(TextView) findViewById(R.id.serF2);
        textview3.setText(curFood.getUnit());
        ed1=(EditText)findViewById(R.id.servesizeEn2);
        gotten=ed1.getText().toString();
    }
    public void add_back2(View view){

        String name=curFood.getExe();
        String calory=curFood.getCalory();
        String serving=curFood.getUnit();
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
        gotten=ed1.getText().toString();
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
        dbHelper.insertExe(name,calory,serving,username,date);
        sharedPreferences.edit().putString("date1",date).apply();
        Intent intent=new Intent(this,MainActivity2.class);
        startActivity(intent);
    }
}