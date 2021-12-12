package com.example.final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class settingNotification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_notification);


    }

    public void clickFunction(View view){
        Intent intent = new Intent(this, MainSetting.class);
        startActivity(intent);
    }
}