package com.example.final_project;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class settingFeedback extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_feedback);
    }

    public void clickFunction(View view){
        Intent intent = new Intent(this, MainSetting.class);
        startActivity(intent);
    }
    public void submitFunction(View view){
        TextInputEditText text1 = (TextInputEditText) findViewById(R.id.textInputEditText);
        TextInputEditText text2 = (TextInputEditText) findViewById(R.id.textInputEditText1);
        String mainProblem = text1.getText().toString();
        String description = text2.getText().toString();
        feedbackHelper fbH = new feedbackHelper(mainProblem,description);
        FirebaseDatabase store = FirebaseDatabase.getInstance();
        DatabaseReference ref = store.getReference("feedback");
        ref.child("MainProblem").setValue(fbH.getMainProblem());
        ref.child("Description").setValue(fbH.getDescription());
        Intent intent = new Intent(this, MainSetting.class);
        startActivity(intent);
    }
}