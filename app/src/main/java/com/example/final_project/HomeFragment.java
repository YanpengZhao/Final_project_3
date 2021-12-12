package com.example.final_project;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        // Inflate the layout for this fragment
        double totalCalorie = 0;
        TextView textView = (TextView) rootView.findViewById(R.id.textView19);
        TextView textView1 = (TextView) rootView.findViewById(R.id.textView10);
        TextView textView2 = (TextView) rootView.findViewById(R.id.textView11);
        TextView textView3 = (TextView) rootView.findViewById(R.id.textView12);
        TextView textView4 = (TextView) rootView.findViewById(R.id.textView9);
        ListView listView = (ListView) rootView.findViewById(R.id.foodlist);
        ListView listView1 = (ListView) rootView.findViewById(R.id.exelist);
        Button button1 = (Button) rootView.findViewById(R.id.button8);
        Button button2 = (Button) rootView.findViewById(R.id.button9);
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String date = dateFormat.format(new Date());
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("com.example.final_project", Context.MODE_PRIVATE);
        String[] dateSplit = date.split("/");
        int day = Integer.parseInt(dateSplit[1]);
        int day1 = 0;
        int day2 = 0;
        String name = sharedPreferences.getString("username","");
        String text = "it's "+dateSplit[0]+"/"+dateSplit[1]+", Welcome "+name+"!";
        textView.setText(text);
        Context context=this.getActivity().getApplicationContext();
        SQLiteDatabase sqLiteDatabase=context.openOrCreateDatabase("foodType",Context.MODE_PRIVATE,null);
        DBHelper dbHelper=new DBHelper(sqLiteDatabase);

        if(sharedPreferences.contains("date") || sharedPreferences.contains("date1")) {
            if(sharedPreferences.contains("date")) {
                String date1 = sharedPreferences.getString("date", "");
                String[] dateSplit1 = date1.split("/");
                day1 = Integer.parseInt(dateSplit1[1]);
                if (day == day1) {
                    button1.setVisibility(View.INVISIBLE);
                    button2.setVisibility(View.INVISIBLE);
                    textView1.setVisibility(View.INVISIBLE);
                    ArrayList<FoodType> foodList = new ArrayList<FoodType>();
                    foodList = dbHelper.getUserFood(name);
                    ArrayList<String> displayNotes = new ArrayList<>();
                    for (FoodType food : foodList) {
                        String date3 = food.getDate();
                        if (!date3.equals("******")) {
                            String[] date4 = date3.split("/");
                            if (dateSplit[1].equals(date4[1])) {
                                totalCalorie = totalCalorie + Double.parseDouble(food.getCalory());
                                displayNotes.add(String.format("Name:%s  Type:%s  Calorie:%s", food.getFood(), food.getCategory(), food.getCalory()));
                            }
                        }
                    }
                    listView.setAdapter(new ArrayAdapter<String>(rootView.getContext(), android.R.layout.simple_list_item_1, displayNotes));
                }
            }
            if(sharedPreferences.contains("date1")) {
                String date2 = sharedPreferences.getString("date1", "");
                String[] dateSplit2 = date2.split("/");
                day2 = Integer.parseInt(dateSplit2[1]);
                if (day == day2) {
                    button1.setVisibility(View.INVISIBLE);
                    button2.setVisibility(View.INVISIBLE);
                    textView1.setVisibility(View.INVISIBLE);
                    ArrayList<ExeType> exeList = new ArrayList<ExeType>();
                    exeList = dbHelper.getUserExe(name);
                    ArrayList<String> displayNotes1 = new ArrayList<>();
                    for (ExeType exe : exeList) {
                        String date3 = exe.getDate();
                        if (!date3.equals("******")) {
                            String[] date4 = date3.split("/");
                            if (dateSplit[1].equals(date4[1])) {
                                totalCalorie = totalCalorie - Double.parseDouble(exe.getCalory());
                                displayNotes1.add(String.format("Name:%s  Calorie:%s", exe.getExe(), exe.getCalory()));
                            }
                        }
                    }
                    listView1.setAdapter(new ArrayAdapter<String>(rootView.getContext(), android.R.layout.simple_list_item_1, displayNotes1));
                }
            }
            textView4.setVisibility(View.INVISIBLE);
            if(sharedPreferences.contains("CaloriePerDay")) {
                textView4.setVisibility(View.VISIBLE);
                double calorieRequired = Double.parseDouble(sharedPreferences.getString("CaloriePerDay",""));
                double calorie = totalCalorie - calorieRequired;
                if (calorie <= 0) {
                    double calorieAbs = Math.abs(calorie);
                    textView4.setText("Your calorie intake in total is " + totalCalorie + " cal. \nYou still have to get " + calorieAbs + " cal");
                } else {
                    double calorieAbs = Math.abs(calorie);
                    textView4.setText("Your calorie intake in total is " + totalCalorie + " cal. \nYou still have to burn " + calorieAbs + " cal");
                }
            }
            if(day!=day1 && day!=day2){
                textView2.setVisibility(View.INVISIBLE);
                textView3.setVisibility(View.INVISIBLE);
                listView.setVisibility(View.INVISIBLE);
                listView1.setVisibility(View.INVISIBLE);
                textView4.setVisibility(View.INVISIBLE);
                textView1.setText("Looks like you haven't added any food or exercise today!");

            }
        }else{
            textView2.setVisibility(View.INVISIBLE);
            textView3.setVisibility(View.INVISIBLE);
            listView.setVisibility(View.INVISIBLE);
            listView1.setVisibility(View.INVISIBLE);
            textView4.setVisibility(View.INVISIBLE);
            textView1.setText("Looks like it's the first time you use the app, \ntry to add some food or exercise!");
        }
        return rootView;
    }
}