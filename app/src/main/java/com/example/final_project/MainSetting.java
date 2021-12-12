package com.example.final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainSetting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        ArrayList<String> settingList = new ArrayList<>();
        settingList.add("Profile");
        settingList.add("Private");
        settingList.add("Notification");
        settingList.add("Feedback");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, settingList);
        ListView listView = (ListView) findViewById(R.id.settingList1);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(position == 0) {
                    Intent intent = new Intent(getApplicationContext(), settingProfile.class);
                    startActivity(intent);
                }
                else if(position == 1){
                    Intent intent = new Intent(getApplicationContext(), settingPrivate.class);
                    startActivity(intent);
                }
                else if(position == 2){
                    Intent intent = new Intent(getApplicationContext(), settingNotification.class);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(getApplicationContext(), settingFeedback.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void clickFunction(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
        startActivity(intent);
    }
}