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

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        SharedPreferences sharePreferences = getSharedPreferences("com.example.final_project", Context.MODE_PRIVATE);
        if(sharePreferences.contains("user")){
            sharePreferences.edit().remove("user").apply();
        }
    }

    public void backFunction(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public void nextFunction(View view){
        TextInputEditText Account = (TextInputEditText) findViewById(R.id.Account1);
        TextInputEditText Password1 = (TextInputEditText) findViewById(R.id.password1);
        TextInputEditText Password2 = (TextInputEditText) findViewById(R.id.password2);
        TextInputEditText Email = (TextInputEditText) findViewById(R.id.email);
        String account = Account.getText().toString();
        String password1 = Password1.getText().toString();
        String password2 = Password2.getText().toString();
        String email = Email.getText().toString();

        if(password1.equals(password2)){
            SharedPreferences sharePreferences = getSharedPreferences("com.example.final_project", Context.MODE_PRIVATE);
            sharePreferences.edit().putString("username", account).apply();
            sharePreferences.edit().putString("password", password1).apply();
            sharePreferences.edit().putString("email", email).apply();
            Intent intent = new Intent(getApplicationContext(), SignUp2.class);
            intent.putExtra("account",account);
            intent.putExtra("pass",password1);
            startActivity(intent);
        }else{
            Context context = getApplicationContext();
            CharSequence text = "Different password entered";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

}