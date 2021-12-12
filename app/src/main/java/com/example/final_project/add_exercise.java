package com.example.final_project;

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

public class add_exercise extends AppCompatActivity implements SearchView.OnQueryTextListener {
    ListView list;
    ListViewAdapter2 adapter;
    SearchView editsearch;
    ArrayList<ExeType> arraylist = new ArrayList<ExeType>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_exercise);
        list = (ListView) findViewById(R.id.listview2);
        // Generate sample data
        Context context=getApplicationContext();
        SQLiteDatabase sqLiteDatabase=context.openOrCreateDatabase("exeType",Context.MODE_PRIVATE,null);
        DBHelper dbHelper=new DBHelper(sqLiteDatabase);
        Log.d("s","before2!!!!!!!");
        arraylist.addAll(dbHelper.getExeNames());
        Log.d("s","After!!!!!!!!");
        System.out.println(arraylist.size());
        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter2(this, arraylist);
        // Binds the Adapter to the ListView
        list.setAdapter(adapter);
        list.setClickable(true);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                ExeType food =(ExeType) list.getItemAtPosition(position);
                Intent intent = new Intent(add_exercise.this,add_exe_2.class);
                String name=food.getExe();
                String calory=food.getCalory();
                String unit=food.getUnit();
                intent.putExtra("name", name);
                intent.putExtra("calory", calory);
                intent.putExtra("unit", unit);
                intent.putExtra("food", food);
                startActivity(intent);
            }
        });
        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) findViewById(R.id.search2);
        editsearch.setOnQueryTextListener(this);
    }
    public void create_exe(View view){
        Intent intent=new Intent(this,create_exe.class);
        startActivity(intent);
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