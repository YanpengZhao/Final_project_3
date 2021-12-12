package com.example.final_project;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DBHelper {
    SQLiteDatabase sqLiteDatabase;
    public DBHelper(SQLiteDatabase sqLiteDatabase){
        this.sqLiteDatabase=sqLiteDatabase;
    }
    public void createTable(){
        sqLiteDatabase.execSQL("CREATE  TABLE IF NOT EXISTS foodType"+"(id INTEGER PRIMARY KEY,food TEXT,category TEXT,calory TEXT,serving TEXT,date TEXT,username TEXT,pr TEXT,nc TEXT,ft TEXT)");
    }
    public void createTableE(){
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS exeType"+"(id INTEGER PRIMARY KEY, exe TEXT, calory TEXT,unit TEXT,username TEXT,date TEXT)");
    }
    public void createTable3(){
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS planType"+"(id INTEGER PRIMARY KEY, calory TEXT,username TEXT)");
    }
    public ArrayList<ExeType>getUserExe(String username1){
        createTableE();
        Cursor c=sqLiteDatabase.rawQuery(String.format("SELECT * from exeType where username like '%s'",username1),null);
        int exeIndex=c.getColumnIndex("exe");
        int caloryIndex=c.getColumnIndex("calory");
        int unitIndex=c.getColumnIndex("unit");
        int dateIndex=c.getColumnIndex("date");
        int usernameIndex=c.getColumnIndex("username");
        c.moveToFirst();
        ArrayList<ExeType>noteList=new ArrayList<>();
        while(!c.isAfterLast()){
            String date=c.getString(dateIndex);
            String exe=c.getString(exeIndex);
            String calory=c.getString(caloryIndex);
            String unit=c.getString(unitIndex);
            String username=c.getString(usernameIndex);
            ExeType note=new ExeType(exe,calory,unit,username,date);
            if(username.equals(username1) && !date.equals("******")){
                noteList.add(note);
            }
            c.moveToNext();
        }
        c.close();
        sqLiteDatabase.close();
        return noteList;
    }

    public ArrayList<FoodType> getUserFood(String username1){
        createTable();
        ArrayList<FoodType> toreturn=new ArrayList<>();
        Cursor c=sqLiteDatabase.rawQuery(String.format("SELECT * from foodType where username like '%s'",username1),null);
        int dateIndex=c.getColumnIndex("date");
        int foodIndex=c.getColumnIndex("food");
        int categoryIndex=c.getColumnIndex("category");
        int caloryIndex=c.getColumnIndex("calory");
        int servingIndex=c.getColumnIndex("serving");
        int prIndex=c.getColumnIndex("pr");
        int ncIndex=c.getColumnIndex("nc");
        int ftIndex=c.getColumnIndex("ft");
        int usernameIndex=c.getColumnIndex("username");
        c.moveToFirst();
        while(!c.isAfterLast()){
            String date=c.getString(dateIndex);
            String food=c.getString(foodIndex);
            String category=c.getString(categoryIndex);
            String calory=c.getString(caloryIndex);
            String serving=c.getString(servingIndex);
            String pr=c.getString(prIndex);
            String nc=c.getString(ncIndex);
            String ft=c.getString(ftIndex);
            String username=c.getString(usernameIndex);
            FoodType note=new FoodType(food,category,calory,serving,date,username,pr,nc,ft);
            if(username.equals(username1) && !date.equals("******")){
                toreturn.add(note);
            }
            c.moveToNext();
        }
        c.close();
        return toreturn;
    }
    public ArrayList<ExeType> getExeNames(){
        createTableE();
        ArrayList<ExeType> toreturn=new ArrayList<>();
        Cursor c=sqLiteDatabase.rawQuery(String.format("SELECT * from exeType"),null);
        int dateIndex=c.getColumnIndex("date");
        int exeIndex=c.getColumnIndex("exe");
        int caloryIndex=c.getColumnIndex("calory");
        int unitIndex=c.getColumnIndex("unit");
        int usernameIndex=c.getColumnIndex("username");
        c.moveToFirst();
        while(!c.isAfterLast()){
            String date=c.getString(dateIndex);
            String exe=c.getString(exeIndex);
            String calory=c.getString(caloryIndex);
            String unit=c.getString(unitIndex);
            String username=c.getString(usernameIndex);
            ExeType note=new ExeType(exe,calory,unit,username,date);
            if(date.equals("******")){
                toreturn.add(note);
            }
            c.moveToNext();
        }
        c.close();
        sqLiteDatabase.close();
        return toreturn;
    }
    public ArrayList<planType> getPlan(String username){
        createTable3();
        ArrayList<planType> toreturn=new ArrayList<>();
        Cursor c=sqLiteDatabase.rawQuery(String.format("SELECT * from planType where username like '%s'",username),null);
        int caloryIndex=c.getColumnIndex("calory");
        int usernameIndex=c.getColumnIndex("username");
        c.moveToFirst();
        while(!c.isAfterLast()){
            String calory=c.getString(caloryIndex);
            String username1=c.getString(usernameIndex);
            planType note=new planType(calory,username1);
            toreturn.add(note);
            c.moveToNext();
        }
        c.close();
        sqLiteDatabase.close();
        return toreturn;
    }
    public ArrayList<FoodType> getFoodNames(){
        createTable();
        ArrayList<FoodType> toreturn=new ArrayList<>();
        Cursor c=sqLiteDatabase.rawQuery(String.format("SELECT * from foodType"),null);
        int dateIndex=c.getColumnIndex("date");
        int foodIndex=c.getColumnIndex("food");
        int categoryIndex=c.getColumnIndex("category");
        int caloryIndex=c.getColumnIndex("calory");
        int servingIndex=c.getColumnIndex("serving");
        int prIndex=c.getColumnIndex("pr");
        int ncIndex=c.getColumnIndex("nc");
        int ftIndex=c.getColumnIndex("ft");
        int usernameIndex=c.getColumnIndex("username");
        c.moveToFirst();
        while(!c.isAfterLast()){
            String date=c.getString(dateIndex);
            String food=c.getString(foodIndex);
            String category=c.getString(categoryIndex);
            String calory=c.getString(caloryIndex);
            String serving=c.getString(servingIndex);
            String pr=c.getString(prIndex);
            String nc=c.getString(ncIndex);
            String ft=c.getString(ftIndex);
            String username=c.getString(usernameIndex);
            FoodType note=new FoodType(food,category,calory,serving,date,username,pr,nc,ft);
            if(date.equals("******")){
                toreturn.add(note);
            }
            c.moveToNext();
        }
        c.close();
        return toreturn;
    }
    public void insertFood(String food,String category,String calory,String serving,String date,String username,String pr,String nc,String ft){
        createTable();
        sqLiteDatabase.execSQL(String.format("INSERT INTO foodType(food,category,calory,serving,date,username,pr,nc,ft) VALUES ('%s','%s','%s','%s','%s','%s','%s','%s','%s')",food,category,calory,serving,date,username,pr,nc,ft));
    }
    public void insertExe(String exe,String calory,String unit,String username,String date){
        createTableE();
        sqLiteDatabase.execSQL(String.format("INSERT INTO exeType(exe,calory,unit,username,date) VALUES ('%s','%s','%s','%s','%s')",exe,calory,unit,username,date));
    }
    public void insertPlan(String calory,String username){
        createTable3();
        sqLiteDatabase.execSQL(String.format("INSERT INTO planType(calory,username) VALUES ('%s','%s')",calory,username));
    }

}
