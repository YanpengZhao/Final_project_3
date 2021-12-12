package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {



    public static String usernameKey = "username";
    public static String passwordKey = "password";
    public static String weight = "weight";
    public static String height = "height";
    public static String age = "age";
    public static String sex = "sex";
    public static String date = "date";
    public static String CaloriePerDay = "CaloriePerDay";

    public void clickFunction(View view) {
        TextInputEditText myTextField = (TextInputEditText) findViewById(R.id.Account);
        TextInputEditText password = (TextInputEditText) findViewById(R.id.Password);
        SharedPreferences sharePreferences = getSharedPreferences("com.example.final_project", Context.MODE_PRIVATE);
        String str = myTextField.getText().toString();
        String pass = password.getText().toString();
        sharePreferences.edit().putString("user", str).apply();
        if(!sharePreferences.contains("user")){
            Context context = getApplicationContext();
            CharSequence text = "No account signed up yet";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }else {
            sharePreferences.edit().putString("username", str).apply();
            goToActivity2();
        }
    }

    public void goToActivity2() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
    public void signUp(View view){
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences("com.example.final_project", Context.MODE_PRIVATE);
        DateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String date = dateFormat.format(new Date());
        if (!sharedPreferences.getString("user", "").equals("")) {
            goToActivity2();
        } else {
            setContentView(R.layout.activity_main);
        }
        setContentView(R.layout.activity_main);
    }

}