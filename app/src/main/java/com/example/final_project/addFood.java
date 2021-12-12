package com.example.final_project;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import java.util.ArrayList;
public class addFood extends AppCompatActivity implements SearchView.OnQueryTextListener {
    // Declare Variables
    ListView list;
    ListViewAdapter adapter;
    SearchView editsearch;
    ArrayList<FoodType> arraylist = new ArrayList<FoodType>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("s","before!!!!!!!");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_food);
        list = (ListView) findViewById(R.id.listview);
        // Generate sample data
        Context context=getApplicationContext();
        SQLiteDatabase sqLiteDatabase=context.openOrCreateDatabase("foodType",Context.MODE_PRIVATE,null);
        DBHelper dbHelper=new DBHelper(sqLiteDatabase);
        Log.d("s","before2!!!!!!!");
        arraylist.addAll(dbHelper.getFoodNames());
        Log.d("s","After!!!!!!!!");
        System.out.println(arraylist.size());
        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, arraylist);
        // Binds the Adapter to the ListView
        list.setAdapter(adapter);
        list.setClickable(true);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                FoodType food =(FoodType) list.getItemAtPosition(position);
                Intent intent = new Intent(addFood.this,add_food2.class);
                String name=food.getFood();
                String calory=food.getCalory();
                String ft=food.getFt();
                String pr=food.getPr();
                String nc=food.getNc();
                intent.putExtra("name", name);
                intent.putExtra("calory", calory);
                intent.putExtra("ft",ft);
                intent.putExtra("nc", nc);
                intent.putExtra("pr", pr);
                intent.putExtra("food", food);
                startActivity(intent);
            }
        });
        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }

}