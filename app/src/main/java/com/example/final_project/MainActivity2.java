package com.example.final_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationBarView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity2 extends AppCompatActivity {
    private String text1;
    private NavigationBarView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bottomNavigationView=findViewById(R.id.bottomnav);
        bottomNavigationView.setOnItemSelectedListener(bottomnavFunction);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();
        Context context=getApplicationContext();
        SQLiteDatabase sqLiteDatabase=context.openOrCreateDatabase("foodType",Context.MODE_PRIVATE,null);
        DBHelper dbHelper=new DBHelper(sqLiteDatabase);
        SharedPreferences sharedPreferences=getSharedPreferences("com.example.final_project",Context.MODE_PRIVATE);
        String height=sharedPreferences.getString(MainActivity.height,"");
        String weight=sharedPreferences.getString(MainActivity.weight,"");
        String age=sharedPreferences.getString(MainActivity.age,"");
        String sex=sharedPreferences.getString(MainActivity.sex,"");
        double a=6.23;
        double b=12.7;
        double c=6.8;
        double d=66;
        if(sex=="female"){
            a=4.35;
            b=4.7;
            c=4.7;
            d=665;
        }
        String username=sharedPreferences.getString(MainActivity.usernameKey,"");
        double e=Double.valueOf(weight)*a+Double.valueOf(height)*b-Double.valueOf(age)*c+d;
        int e1=(int)e;
        ArrayList<planType> planTypes= dbHelper.getPlan(username);
        double pu=0;
        if (planTypes.size()!=0){
            pu=Double.valueOf(planTypes.get(planTypes.size()-1).getCalory());
        }
        int f=(int)(e-500*Double.valueOf(pu));
        sharedPreferences.edit().putString("CaloriePerDay",String.valueOf(f)).apply();
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu2, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if(item.getItemId()==R.id.setting){
            Intent  intent=new Intent(this,MainSetting.class);
            startActivity(intent);
            return true;
        }
        if(item.getItemId()==R.id.logout){
            goToActivity1();
            return true;
        }
        return false;
//respond to menu item selection
    }

    private NavigationBarView.OnItemSelectedListener bottomnavFunction=new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment=null;
            switch (item.getItemId()){
                case R.id.home:
                    fragment=new HomeFragment();
                    break;
                case R.id.food:
                    fragment=new FoodFragment();
                    break;
                case R.id.add:
                    fragment=new AddFragment();
                    break;
                case R.id.graph:
                    fragment=new GraphFragment();
                    break;
                case R.id.friend:
                    fragment=new FriendFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
            return true;
        }
    };
    public void clickSetting(View view){
        Intent intent=new Intent(this,MainSetting.class);
        startActivity(intent);
    }
    public void create_food(View view){
        goToActivity2();
    }
    public void suggestion(View view){
        Intent intent=new Intent(this, suggest.class);
        startActivity(intent);
    }
    public void food_cal(View view){
        Intent intent=new Intent(this, food_cal.class);
        startActivity(intent);
    }
    public void timeline(View view){
        Fragment fragment=new TimelineFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
    }
    public void progress(View view){
        Fragment fragment=new ProgressFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
    }
    public void addfood(View view){
        Intent intent=new Intent(this, addFood.class);
        startActivity(intent);
    }
    public void exercise(View view){
        Intent intent=new Intent(this, add_exercise.class);
        startActivity(intent);
    }
    public void plan(View view){
        Intent intent=new Intent(this,add_plan.class);
        startActivity(intent);
    }
    public void  goToActivity2(){
        Intent intent=new Intent(this,CreateFood.class);
        startActivity(intent);
    }

    public void  goToActivity1(){
        Intent intent = new Intent(this,MainActivity.class);
        SharedPreferences sharedPreferences = getSharedPreferences("com.example.final_project", Context.MODE_PRIVATE);
        sharedPreferences.edit().remove("user").apply();
        sharedPreferences.edit().remove("username").apply();
        startActivity(intent);
    }

    public void  goToAddFood(View view){
        Intent intent=new Intent(this,addFood.class);
        startActivity(intent);
    }

    public void  goToAddExe(View view){
        Intent intent=new Intent(this,add_exercise.class);
        startActivity(intent);
    }

}