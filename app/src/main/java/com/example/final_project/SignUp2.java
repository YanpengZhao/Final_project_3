package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class SignUp2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);
    }

    public void backFunction(View view){
        Intent intent = new Intent(getApplicationContext(), SignUp.class);
        startActivity(intent);
    }

    public void finishFunction(View view){
        EditText age = (EditText) findViewById(R.id.age);
        EditText sex = (EditText) findViewById(R.id.sex);
        EditText weight = (EditText) findViewById(R.id.weight);
        EditText height = (EditText) findViewById(R.id.height);
        String age1 = age.getText().toString();
        String sex1 = sex.getText().toString();
        String weight1 = weight.getText().toString();
        String height1 = height.getText().toString();
        SharedPreferences sharePreferences = getSharedPreferences("com.example.final_project", Context.MODE_PRIVATE);
        sharePreferences.edit().remove("date").apply();
        sharePreferences.edit().putString("age",age1).apply();
        sharePreferences.edit().putString("sex",sex1).apply();
        sharePreferences.edit().putString("weight",weight1).apply();
        sharePreferences.edit().putString("height",height1).apply();

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}