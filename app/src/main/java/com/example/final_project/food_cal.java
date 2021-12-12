package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class food_cal extends AppCompatActivity {
    ArrayList<FoodType> foodname = new ArrayList<FoodType>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_cal);
        Context context=getApplicationContext();
        SQLiteDatabase sqLiteDatabase=context.openOrCreateDatabase("foodType", Context.MODE_PRIVATE,null);
        DBHelper dbHelper=new DBHelper(sqLiteDatabase);
        foodname.addAll(dbHelper.getFoodNames());
        Log.d("a",foodname.toString());
        TableLayout prices = (TableLayout)findViewById(R.id.table);
        prices.setStretchAllColumns(true);
        prices.bringToFront();
        TableRow t1=new TableRow(this);
        TextView d1 = new TextView(this);
        TextView d2 = new TextView(this);
        TextView d3 = new TextView(this);
        TextView d4 = new TextView(this);
        d1.setText("FOOD");
        d2.setText("CATEGORY");
        d3.setText("CALORIE");
        d4.setText("SERVING");
        t1.addView(d1);
        t1.addView(d2);
        t1.addView(d3);
        t1.addView(d4);
        prices.addView(t1);
        for(int i = 0; i < foodname.size(); i++){
            TableRow tr =  new TableRow(this);
            TextView c1 = new TextView(this);
            c1.setText(foodname.get(i).getFood());
            TextView c2 = new TextView(this);
            c2.setText(foodname.get(i).getCategory());
            TextView c3 = new TextView(this);
            c3.setText(foodname.get(i).getCalory());
            TextView c4 = new TextView(this);
            c4.setText(foodname.get(i).getServing());
            tr.addView(c1);
            tr.addView(c2);
            tr.addView(c3);
            tr.addView(c4);
            prices.addView(tr);
        }
    }
}