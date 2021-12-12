package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
        Context context=getApplicationContext();
        SQLiteDatabase sqLiteDatabase=context.openOrCreateDatabase("foodType",Context.MODE_PRIVATE,null);
        DBHelper dbHelper=new DBHelper(sqLiteDatabase);
        EditText age = (EditText) findViewById(R.id.age);
        EditText sex = (EditText) findViewById(R.id.sex);
        EditText weight = (EditText) findViewById(R.id.weight);
        EditText height = (EditText) findViewById(R.id.height);
        String age1 = age.getText().toString();
        String sex1 = sex.getText().toString();
        String weight1 = weight.getText().toString();
        String height1 = height.getText().toString();
        SharedPreferences sharePreferences = getSharedPreferences("com.example.final_project", Context.MODE_PRIVATE);
        String str=sharePreferences.getString(MainActivity.usernameKey,"");
        String username=str;
        sharePreferences.edit().remove("date").apply();
        sharePreferences.edit().remove("date1").apply();
        sharePreferences.edit().putString("age",age1).apply();
        sharePreferences.edit().putString("sex",sex1).apply();
        sharePreferences.edit().putString("weight",weight1).apply();
        sharePreferences.edit().putString("height",height1).apply();
        Log.d("db",dbHelper.getFoodNames().size()+"");
        if (dbHelper.getFoodNames().size()==0) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS foodType");
            String date = "******";
            int cn = 0;
            String line = "Food,Measure,Grams,Calories,Protein,Fat,Sat.Fat,Fiber,Carbs,Category\n" +
                    "Cows milk,1 qt.,976,660,32,40,36,0,48,Dairy products\n" +
                    "Milk skim,1 qt.,984,360,36,t,t,0,52,Dairy products\n" +
                    "Buttermilk,1 cup,246,127,9,5,4,0,13,Dairy products\n" +
                    "Evaporated undiluted,1 cup,252,345,16,20,18,0,24,Dairy products\n" +
                    "Fortified milk,6 cups,1419,1373,89,42,23,1.4,119,Dairy products\n" +
                    "Powdered milk,1 cup,103,515,27,28,24,0,39,Dairy products\n" +
                    "skim instant,0.33 cups,85,290,30,t,t,0,42,Dairy products\n" +
                    "skim non-instant,0.67 cup,85,290,30,t,t,1,42,Dairy products\n" +
                    "Goats milk,1 cup,244,165,8,10,8,0,11,Dairy products\n" +
                    "(0.5 cup ice cream),2 cups,540,690,24,24,22,0,70,Dairy products\n" +
                    "Cocoa,1 cup,252,235,8,11,10,0,26,Dairy products\n" +
                    "skim. milk,1 cup,250,128,18,4,3,1,13,Dairy products\n" +
                    "(cornstarch),1 cup,248,275,9,10,9,0,40,Dairy products\n" +
                    "Custard,1 cup,248,285,13,14,11,0,28,Dairy products\n" +
                    "Ice cream,1 cup,188,300,6,18,16,0,29,Dairy products\n" +
                    "Ice milk,1 cup,190,275,9,10,9,0,32,Dairy products\n" +
                    "Cream or half-and-half,0.5 cup,120,170,4,15,13,0,5,Dairy products\n" +
                    "or whipping,0.5 cup,119,430,2,44,27,1,3,Dairy products\n" +
                    "Cheese,1 cup,225,240,30,11,10,0,6,Dairy products\n" +
                    "uncreamed,1 cup,225,195,38,t,t,0,6,Dairy products\n" +
                    "Cheddar,1-in. cube,17,70,4,6,5,0,t,Dairy products\n" +
                    "Cheddar grated cup,0.5 cup,56,226,14,19,17,0,1,Dairy products\n" +
                    "Cream cheese,1 oz.,28,105,2,11,10,0,1,Dairy products\n" +
                    "Processed cheese,1 oz.,28,105,7,9,8,0,t,Dairy products\n" +
                    "Roquefort type,1 oz.,28,105,6,9,8,0,t,Dairy products\n" +
                    "Swiss,1 oz.,28,105,7,8,7,0,t,Dairy products\n" +
                    "Eggs raw,2,100,150,12,12,10,0,t,Dairy products\n" +
                    "Eggs Scrambled or fried,2,128,220,13,16,14,0,1,Dairy products\n" +
                    "Yolks,2,34,120,6,10,8,0,t,\"Fats, Oils, Shortenings\"\n" +
                    "Butter,1T.,14,100,t,11,10,0,t,\"Fats, Oils, Shortenings\"\n" +
                    "Butter,0.5 cup,112,113,114,115,116,117,118,\"Fats, Oils, Shortenings\"\n" +
                    "Butter,0.25 lb.,112,113,114,115,116,117,118,\"Fats, Oils, Shortenings\"\n" +
                    "Hydrogenated cooking fat,0.5 cup,100,665,0,100,88,0,0,\"Fats, Oils, Shortenings\"\n" +
                    "Lard,0.5 cup,110,992,0,110,92,0,0,\"Fats, Oils, Shortenings\"\n" +
                    "Margarine,0.5 cup,112,806,t,91,76,0,t,\"Fats, Oils, Shortenings\"\n" +
                    "Margarine 2 pat or,1 T.,14,100,t,11,9,0,t,\"Fats, Oils, Shortenings\"\n" +
                    "Mayonnaise,1 T.,15,110,t,12,5,0,t,\"Fats, Oils, Shortenings\"\n" +
                    "Corn oil,1 T.,14,125,0,14,5,0,0,\"Fats, Oils, Shortenings\"\n" +
                    "Olive oil,1T.,14,125,0,14,3,0,0,\"Fats, Oils, Shortenings\"\n" +
                    "Safflower seed oil,1 T.,14,125,0,14,3,0,0,\"Fats, Oils, Shortenings\"\n" +
                    "French dressing,1 T.,15,60,t,6,2,0,2,\"Fats, Oils, Shortenings\"\n" +
                    "Thousand Island sauce,1 T.,15,75,t,8,3,0,1,\"Fats, Oils, Shortenings\"\n" +
                    "Salt pork,2 oz.,60,470,3,55,,0,0,\"Meat, Poultry\"\n" +
                    "Bacon,2 slices,16,95,4,8,7,0,1,\"Meat, Poultry\"\n" +
                    "Beef,3 oz.,85,245,23,16,15,0,0,\"Meat, Poultry\"\n" +
                    "Hamburger,3 oz.,85,245,21,17,15,0,0,\"Meat, Poultry\"\n" +
                    "Ground lean,3 oz.,85,185,24,10,9,0,0,\"Meat, Poultry\"\n" +
                    "Roast beef,3 oz.,85,390,16,36,35,0,0,\"Meat, Poultry\"\n" +
                    "Steak,3 oz.,85,330,20,27,25,0,0,\"Meat, Poultry\"\n" +
                    "Steak lean as round,3 oz.,85,220,24,12,11,0,0,\"Meat, Poultry\"\n" +
                    "Corned beef,3 oz.,85,185,22,10,9,0,0,\"Meat, Poultry\"\n" +
                    "Corned beef hash canned,3 oz.,85,120,12,8,7,t,6,\"Meat, Poultry\"\n" +
                    "Corned beef hash Dried,2 oz.,56,115,19,4,4,0,0,\"Meat, Poultry\"\n" +
                    "Pot-pie,1 pie,227,480,18,28,25,t,32,\"Meat, Poultry\"\n" +
                    "Corned beef hash Stew,1 cup,235,185,15,10,9,t,15,\"Meat, Poultry\"\n" +
                    "chicken,3 oz.,85,185,23,9,7,0,0,\"Meat, Poultry\"\n" +
                    "Fried breast or leg and thigh chicken,3 oz.,85,245,25,15,11,0,0,\"Meat, Poultry\"\n" +
                    "Roasted chicken,3 0.5 oz.,100,290,25,20,16,0,0,\"Meat, Poultry\"\n" +
                    "Chicken livers fried,3 med.,100,140,22,14,12,0,2.3,\"Meat, Poultry\"\n" +
                    "Duck domestic,3 0.5 oz.,100,370,16,28,0,0,0,\"Meat, Poultry\"\n" +
                    "Lamb chop broiled,4 oz.,115,480,24,35,33,0,0,\"Meat, Poultry\"\n" +
                    "Leg roasted,3 oz.,86,314,20,14,14,0,0,\"Meat, Poultry\"\n" +
                    "Shoulder braised,3 oz.,85,285,18,23,21,0,0,\"Meat, Poultry\"\n" +
                    "Pork chop 1 thick,3.5 oz.,100,260,16,21,18,0,0,\"Meat, Poultry\"\n" +
                    "Ham pan-broiled,3 oz.,85,290,16,22,19,0,0,\"Meat, Poultry\"\n" +
                    "Ham as ,2 oz.,57,170,13,13,11,0,0,\"Meat, Poultry\"\n" +
                    "Ham canned spiced,2 oz.,57,165,8,14,12,0,1,\"Meat, Poultry\"\n" +
                    "Pork roast,3 oz.,85,310,21,24,21,0,0,\"Meat, Poultry\"\n" +
                    "Pork sausage,3 0.5 oz.,100,475,18,44,40,0,0,\"Meat, Poultry\"\n" +
                    "Turkey,3 0.5 oz.,100,265,27,15,0,0,0,\"Meat, Poultry\"\n" +
                    "Veal,3 oz.,85,185,23,9,8,0,0,\"Meat, Poultry\"\n" +
                    "Roast,3 oz.,85,305,13,14,13,0,0,\"Meat, Poultry\"\n" +
                    "Clams,3 oz.,85,87,12,1,0,0,2,\"Fish, Seafood\"\n" +
                    "Cod,3 0.5 oz.,100,170,28,5,0,0,0,\"Fish, Seafood\"\n" +
                    "Crab meat,3 oz.,85,90,14,2,0,0,1,\"Fish, Seafood\"\n" +
                    "Fish sticks fried,5,112,200,19,10,5,0,8,\"Fish, Seafood\"\n" +
                    "Flounder,3 0.5 oz.,100,200,30,8,0,0,0,\"Fish, Seafood\"\n" +
                    "Haddock,3 oz.,85,135,16,5,4,0,6,\"Fish, Seafood\"\n" +
                    "Halibut,3 0.5 oz.,100,182,26,8,0,0,0,\"Fish, Seafood\"\n" +
                    "Herring,1 small,100,211,22,13,0,0,0,\"Fish, Seafood\"\n" +
                    "Lobster,aver.,100,92,18,1,0,0,t,\"Fish, Seafood\"\n" +
                    "Mackerel,3 oz.,85,155,18,9,0,a,0,\"Fish, Seafood\"\n" +
                    "Oysters,6-8 med.,230,231,232,233,234,235,236,\"Fish, Seafood\"\n" +
                    "Oyster stew,1 cup,85,125,19,6,1,0,0,\"Fish, Seafood\"\n" +
                    "Salmon,3 oz.,85,120,17,5,1,0,0,\"Fish, Seafood\"\n" +
                    "Sardines,3 oz.,85,180,22,9,4,0,0,\"Fish, Seafood\"\n" +
                    "Scallops,3 0.5 oz.,100,104,18,8,0,0,10,\"Fish, Seafood\"\n" +
                    "Shad,3 oz.,85,170,20,10,0,0,0,\"Fish, Seafood\"\n" +
                    "Shrimp,3 oz.,85,110,23,1,0,0,0,\"Fish, Seafood\"\n" +
                    "Swordfish,1 steak,100,180,27,6,0,0,0,\"Fish, Seafood\"\n" +
                    "Tuna,3 oz.,85,170,25,7,3,0,0,\"Fish, Seafood\"\n" +
                    "Artichoke,1 large,100,Aug-44,2,t,t,2,10,Vegetables A-E\n" +
                    "Asparagus,6 spears,96,18,1,t,t,0.5,3,Vegetables A-E\n" +
                    "Beans,1 cup,125,25,1,t,t,0.8,6,Vegetables A-E\n" +
                    "Lima,1 cup,160,140,8,t,t,3,24,Vegetables A-E\n" +
                    "Lima dry cooked,1 cup,192,260,16,t,t,2,48,Vegetables A-E\n" +
                    "Navy baked with pork,3/4 cup,200,250,11,6,6,2,37,Vegetables A-E\n" +
                    "Red kidney,1 cup,260,230,15,1,0,2.5,42,Vegetables A-E\n" +
                    "Bean sprouts,1 cup,50,17,1,t,0,0.3,3,Vegetables A-E\n" +
                    "Beet greens,1 cup,100,27,2,t,0,1.4,6,Vegetables A-E\n" +
                    "Beetroots,1 cup,165,1,12,0,,t,0.8,Vegetables A-E\n" +
                    "Broccoli,1 cup,150,45,5,t,0,1.9,8,Vegetables A-E\n" +
                    "Brussels sprouts,1 cup,130,60,6,t,0,1.7,12,Vegetables A-E\n" +
                    "Sauerkraut,1 cup,150,32,1,t,0,1.2,7,Vegetables A-E\n" +
                    "Steamed cabbage,1 cup,170,40,2,t,0,1.3,9,Vegetables A-E\n" +
                    "Carrots,1 cup,150,45,1,t,0,0.9,10,Vegetables A-E\n" +
                    "Raw grated,1 cup,110,45,1,t,0,1.2,10,Vegetables A-E\n" +
                    "Strips from raw,1 mad.,50,20,t,t,0,0.5,5,Vegetables A-E\n" +
                    "Cauliflower,1 cup,120,30,3,t,0,1,6,Vegetables A-E\n" +
                    "Celery,1 cup,100,20,1,t,0,1,4,Vegetables A-E\n" +
                    "Stalk raw,1 large,40,5,1,t,0,0.3,1,Vegetables A-E\n" +
                    "Chard steamed,1 cup,150,30,2,t,0,1.4,7,Vegetables A-E\n" +
                    "Collards,1 cup,150,51,5,t,0,2,8,Vegetables A-E\n" +
                    "Corn,1 ear,100,92,3,1,t,0.8,21,Vegetables A-E\n" +
                    "cooked or canned,1 cup,200,170,5,t,0,1.6,41,Vegetables A-E\n" +
                    "Cucumbers,8,50,6,t,0,0,0.2,1,Vegetables A-E\n" +
                    "Dandelion greens,1 cup,180,80,5,1,0,3.2,16,Vegetables A-E\n" +
                    "Eggplant,1 cup,180,30,2,t,0,1,9,Vegetables A-E\n" +
                    "Endive,2 oz.,57,10,1,t,0,0.6,2,Vegetables A-E\n" +
                    "Kale,1 cup,110,45,4,1,0,0.9,8,Vegetables F-P\n" +
                    "Kohlrabi,1 cup,140,40,2,t,0,1.5,9,Vegetables F-P\n" +
                    "Lambs quarters steamed,1 cup,150,48,5,t,0,3.2,7,Vegetables F-P\n" +
                    "Lentils,1 cup,200,212,15,t,0,2.4,38,Vegetables F-P\n" +
                    "Lettuce,0.25 head,100,14,1,t,0,0.5,2,Vegetables F-P\n" +
                    "Iceberg,0.25 head,100,13,t,t,0,0.5,3,Vegetables F-P\n" +
                    "Mushrooms canned,4,120,12,2,t,0,t,4,Vegetables F-P\n" +
                    "Mustard greens,1,140,30,3,t,0,1.2,6,Vegetables F-P\n" +
                    "Okra,1 0.33 cups,100,32,1,t,0,1,7,Vegetables F-P\n" +
                    "Onions,1,210,80,2,t,0,1.6,18,Vegetables F-P\n" +
                    "Raw green,6 small,50,22,t,t,0,1,5,Vegetables F-P\n" +
                    "Parsley,2 T.,50,2,t,t,0,t,t,Vegetables F-P\n" +
                    "Parsnips,1 cup,155,95,2,1,0,3,22,Vegetables F-P\n" +
                    "Peas,1 cup,100,66,3,t,0,0.1,13,Vegetables F-P\n" +
                    "Fresh steamed peas,1 cup,100,70,5,t,0,2.2,12,Vegetables R-Z\n" +
                    "Frozen peas,1 cup,100,,5,t,0,1.8,12,Vegetables R-Z\n" +
                    "Split cooked peas,4 cups,100,115,8,t,0,0.4,21,Vegetables R-Z\n" +
                    "heated peas,1 cup,100,53,3,t,0,1,10,Vegetables R-Z\n" +
                    "Peppers canned,1 pod,38,10,t,t,0,t,2,Vegetables R-Z\n" +
                    "Peppers Raw green sweet,1 large,100,25,1,t,0,1.4,6,Vegetables R-Z\n" +
                    "Peppers with beef and crumbs,1 med.,150,255,19,9,8,1,24,Vegetables R-Z\n" +
                    "Potatoes baked,1 med.,100,100,2,t,0,0.5,22,Vegetables R-Z\n" +
                    "French-fried,10 pieces,60,155,-1,7,3,0.4,20,Vegetables R-Z\n" +
                    "Potatoes Mashed with milk and butter,1 cup,200,230,4,12,11,0.7,28,Vegetables R-Z\n" +
                    "Potatoes pan-tried,3/4 cup,100,268,4,14,6,0.4,33,Vegetables R-Z\n" +
                    "Scalloped with cheese potatoes,3/4 cup,100,145,6,8,7,0.4,14,Vegetables R-Z\n" +
                    "Steamed potatoes before peeling,1 med.,100,80,2,t,0,0.4,19,Vegetables R-Z\n" +
                    "Potato chips,10,20,110,1,7,4,t,10,Vegetables R-Z\n" +
                    "Radishes,5 small,50,10,t,0,0,0.3,2,Vegetables R-Z\n" +
                    "Rutabagas,4 cups,100,32,t,0,0,1.4,8,Vegetables R-Z\n" +
                    "Soybeans,1 cup,200,260,22,11,0,3.2,20,Vegetables R-Z\n" +
                    "Spinach,1 cup,100,26,3,t,0,1,3,Vegetables R-Z\n" +
                    "Squash,1 cup,210,35,1,t,0,0.6,8,Vegetables R-Z\n" +
                    "Winter mashed,1 cup,200,95,4,t,0,2.6,23,Vegetables R-Z\n" +
                    "Sweet potatoes,1 med.,110,155,2,1,0,1,36,Vegetables R-Z\n" +
                    "Candied,1 med.,175,235,2,6,5,1.5,80,Vegetables R-Z\n" +
                    "Tomatoes,1 cup,240,50,2,t,0,1,9,Vegetables R-Z\n" +
                    "Raw 2 by 2 0.5,1 med.,150,30,1,t,0,0.6,6,Vegetables R-Z\n" +
                    "Tomato juice,1 cup,240,50,2,t,0,0.6,10,Vegetables R-Z\n" +
                    "Tomato catsup,1 T.,17,15,t,t,0,t,4,Vegetables R-Z\n" +
                    "Turnip greens,1 cup,145,45,4,1,0,1.8,8,Vegetables R-Z\n" +
                    "Turnips steamed,1 cup,155,40,1,t,0,1.8,9,Vegetables R-Z\n" +
                    "Watercress stems raw,1 cup,50,9,1,t,0,0.3,1,Fruits A-F\n" +
                    "Apple juice canned,1 cup,250,125,t,0,0,0,34,Fruits A-F\n" +
                    "Apple vinegar,0.33 cup,100,14,t,0,0,0,3,Fruits A-F\n" +
                    "Apples raw,1 med,130,70,t,t,0,1,18,Fruits A-F\n" +
                    "Stewed or canned,1 cup,240,100,t,t,0,2,26,Fruits A-F\n" +
                    "Apricots,1 cup,250,220,2,t,0,1,57,Fruits A-F\n" +
                    "Dried uncooked,0.5 cup,75,220,4,t,0,1,50,Fruits A-F\n" +
                    "Fresh,3 med.,114,55,1,t,0,0.7,14,Fruits A-F\n" +
                    "Nectar or juice,1 cup,250,140,1,t,0,2,36,Fruits A-F\n" +
                    "Avocado,0.5 large,108,185,2,18,12,1.8,6,Fruits A-F\n" +
                    "Banana,1 med.,150,85,1,t,0,0.9,23,Fruits A-F\n" +
                    "Blackberries,1 cup,144,85,2,1,0,6.6,19,Fruits A-F\n" +
                    "Blueberries,1 cup,250,245,1,t,0,2,65,Fruits A-F\n" +
                    "Cantaloupe,0.5 med.,380,40,1,t,0,2.2,9,Fruits A-F\n" +
                    "Cherries,1 cup,257,100,2,1,0,2,26,Fruits A-F\n" +
                    "Fresh raw,1 cup,114,65,1,t,0,0.8,15,Fruits A-F\n" +
                    "Cranberry sauce sweetened,1 cup,277,530,t,t,0,1.2,142,Fruits A-F\n" +
                    "Dates,1 cup,178,505,4,t,0,3.6,134,Fruits A-F\n" +
                    "Figs,2,42,120,2,t,0,1.9,30,Fruits A-F\n" +
                    "Fresh raw figs,3 med.,114,90,2,t,0,1,22,Fruits A-F\n" +
                    "figs Canned with syrup ,3,115,130,1,t,0,1,32,Fruits A-F\n" +
                    "Fruit cocktail canned,1 cup,256,195,1,t,0,0.5,50,Fruits A-F\n" +
                    "Grapefruit sections,1 cup,250,170,1,t,0,0.5,44,Fruits G-P\n" +
                    "Grapefruit fresh 5inch diameter,0.5/2021,285,50,1,t,t,1,14,Fruits G-P\n" +
                    "Grapefruit juice,1 cup,250,100,1,t,0,1,24,Fruits G-P\n" +
                    "Grapes,1 cup,153,70,1,t,0,0.8,16,Fruits G-P\n" +
                    "European as Muscat Tokay,1 cup,160,100,1,t,0,0.7,26,Fruits G-P\n" +
                    "Grape juice,1 cup,250,160,1,t,0,t,42,Fruits G-P\n" +
                    "Lemon juice,0.5 cup,125,30,t,t,0,t,10,Fruits G-P\n" +
                    "Lemonade concentratefrozen,6-oz. can,220,430,t,t,0,t,112,Fruits G-P\n" +
                    "Limeade concentrate frozen,6-oz. can,218,405,t,t,0,t,108,Fruits G-P\n" +
                    "Olives large,10,65,72,1,10,9,0.8,3,Fruits G-P\n" +
                    "OlivesRipe,10,65,105,1,13,12,1,1,Fruits G-P\n" +
                    "Oranges 3inch diameter,1 med.,180,60,2,t,t,1,16,Fruits G-P\n" +
                    "Orange juice,8 oz. or,250,112,2,t,0,0.2,25,Fruits G-P\n" +
                    "Frozen ,6-oz. can,210,330,2,t,t,0.4,78,Fruits G-P\n" +
                    "Papaya,0.5 med.,200,75,1,t,0,1.8,18,Fruits G-P\n" +
                    "Peaches,1 cup,257,200,1,t,0,1,52,Fruits G-P\n" +
                    "Fresh raw,1 med.,114,35,1,t,0,0.6,10,Fruits G-P\n" +
                    "Pears,1 cup,255,195,1,t,0,2,50,Fruits G-P\n" +
                    "Raw 3 by 2V,1 med.,182,100,1,1,0,2,25,Fruits G-P\n" +
                    "Persimmons,1 med.,125,75,1,t,0,2,20,Fruits G-P\n" +
                    "Pineapple,1 large slice,122,95,t,t,0,0.4,26,Fruits G-P\n" +
                    "Pineapple Crushed,1 cup,260,205,1,t,0,0.7,55,Fruits G-P\n" +
                    "Raw diced,1 cup,140,75,1,t,0,0.6,19,Fruits G-P\n" +
                    "Pineapple juice,1 cup,250,120,1,t,0,0.2,32,Fruits G-P\n" +
                    "Plums,1 cup,256,185,1,t,0,0.7,50,Fruits G-P\n" +
                    "Raw 2inch diameter,1,60,30,t,t,0,0.2,7,Fruits G-P\n" +
                    "Prunes,1 cup,270,300,3,1,0,0.8,81,Fruits G-P\n" +
                    "Prune juice,1 cup,240,170,1,t,0,0.7,45,Fruits G-P\n" +
                    "Raisins,0.5 cup,88,230,2,t,0,0.7,82,Fruits R-Z\n" +
                    "Raspberries,0.5 cup,100,100,t,t,0,2,25,Fruits R-Z\n" +
                    "Raw red,3/4 cup,100,57,t,t,0,5,14,Fruits R-Z\n" +
                    "Rhubarb sweetened,1 cup,270,385,1,t,0,1.9,98,Fruits R-Z\n" +
                    "Strawberries,1 cup,227,242,1,t,0,1.3,60,Fruits R-Z\n" +
                    "Raw,1 cup,149,54,t,t,0,1.9,12,Fruits R-Z\n" +
                    "Tangerines,I med.,114,40,1,t,0,1,10,Fruits R-Z\n" +
                    "Watermelon,1 wedge,925,120,2,1,0,3.6,29,Fruits R-Z\n" +
                    "Biscuits,1,38,130,3,4,3,t,18,\"Breads, cereals, fastfood,grains\"\n" +
                    "Bran flakes,1 cup,25,117,3,t,0,0.1,32,\"Breads, cereals, fastfood,grains\"\n" +
                    "Bread cracked wheat,1 slice,23,60,2,1,1,0.1,12,\"Breads, cereals, fastfood,grains\"\n" +
                    "Rye,1 slice,23,55,2,1,1,0.1,12,\"Breads, cereals, fastfood,grains\"\n" +
                    "White 20 slices or,1-lb. loaf,454,\"1,225\",39,15,12,9,229,\"Breads, cereals, fastfood,grains\"\n" +
                    "Whole-wheat,1-lb. loaf,454,\"1,100\",48,14,10,67.5,216,\"Breads, cereals, fastfood,grains\"\n" +
                    "Whole-wheat,1 slice,23,55,2,1,0,0.31,11,\"Breads, cereals, fastfood,grains\"\n" +
                    "Corn bread ground meal,1 serving,50,100,3,4,2,0.3,15,\"Breads, cereals, fastfood,grains\"\n" +
                    "Cornflakes,1 cup,25,110,2,t,0,0.1,25,\"Breads, cereals, fastfood,grains\"\n" +
                    "Corn grits cooked,1 cup,242,120,8,t,0,0.2,27,\"Breads, cereals, fastfood,grains\"\n" +
                    "Corn meal,1 cup,118,360,9,4,2,1.6,74,\"Breads, cereals, fastfood,grains\"\n" +
                    "Crackers,2 med.,14,55,1,1,0,t,10,\"Breads, cereals, fastfood,grains\"\n" +
                    "Soda 2 0.5 square,2,11,45,1,1,0,t,8,\"Breads, cereals, fastfood,grains\"\n" +
                    "Farina,1 cup,238,105,3,t,0,8,22,\"Breads, cereals, fastfood,grains\"\n" +
                    "Flour,1 cup,110,460,39,22,0,2.9,33,\"Breads, cereals, fastfood,grains\"\n" +
                    "Wheat (all purpose),1 cup,110,400,12,1,0,0.3,84,\"Breads, cereals, fastfood,grains\"\n" +
                    "Wheat (whole),1 cup,120,390,13,2,0,2.8,79,\"Breads, cereals, fastfood,grains\"\n" +
                    "Macaroni,1 cup,140,155,5,1,0,0.1,32,\"Breads, cereals, fastfood,grains\"\n" +
                    "Baked with cheese,1 cup,220,475,18,25,24,t,44,\"Breads, cereals, fastfood,grains\"\n" +
                    "Muffins,1,48,135,4,5,4,t,19,\"Breads, cereals, fastfood,grains\"\n" +
                    "Noodles,1 cup,160,200,7,2,2,0.1,37,\"Breads, cereals, fastfood,grains\"\n" +
                    "Oatmeal,1 cup,236,150,5,3,2,4.6,26,\"Breads, cereals, fastfood,grains\"\n" +
                    "Pancakes 4 inch diam.\",4,108,250,7,9,0,0.1,28,\"Breads, cereals, fastfood,grains\"\n" +
                    "Wheat pancakes 4 inch diam.,4,108,250,7,9,0,0.1,28,\"Breads, cereals, fastfood,grains\"\n" +
                    "Pizza 14 inch diam.,1 section,75,180,8,6,5,t,23,\"Breads, cereals, fastfood,grains\"\n" +
                    "Popcorn salted,2 cups,28,152,3,7,2,0.5,20,\"Breads, cereals, fastfood,grains\"\n" +
                    "Puffed rice,1 cup,14,55,t,t,0,t,12,\"Breads, cereals, fastfood,grains\"\n" +
                    "Puffed wheat presweetened,1 cup,28,105,1,t,0,0.6,26,\"Breads, cereals, fastfood,grains\"\n" +
                    "Rice,1 cup,208,748,15,3,0,1.2,154,\"Breads, cereals, fastfood,grains\"\n" +
                    "Converted,1 cup,187,677,14,t,0,0.4,142,\"Breads, cereals, fastfood,grains\"\n" +
                    "White,1 cup,191,692,14,t,0,0.3,150,\"Breads, cereals, fastfood,grains\"\n" +
                    "Rice flakes,1 cup,30,115,2,t,0,0.1,26,\"Breads, cereals, fastfood,grains\"\n" +
                    "Rice polish,0.5 cup,50,132,6,6,0,1.2,28,\"Breads, cereals, fastfood,grains\"\n" +
                    "Rolls,1 large,50,411,3,12,11,0.1,23,\"Breads, cereals, fastfood,grains\"\n" +
                    "of refined flour,1,38,115,3,2,2,t,20,\"Breads, cereals, fastfood,grains\"\n" +
                    "whole-wheat,1,40,102,4,1,0,0.1,20,\"Breads, cereals, fastfood,grains\"\n" +
                    "Spaghetti with meat sauce,1 cup,250,285,13,10,6,0.5,35,\"Breads, cereals, fastfood,grains\"\n" +
                    "with tomatoes and cheese,1 cup,250,210,6,5,3,0.5,36,\"Breads, cereals, fastfood,grains\"\n" +
                    "Spanish rice,1 cup,250,217,4,4,0,1.2,40,\"Breads, cereals, fastfood,grains\"\n" +
                    "Shredded wheat biscuit,1,28,100,3,1,0,0.7,23,\"Breads, cereals, fastfood,grains\"\n" +
                    "Waffles,1,75,240,8,9,1,0.1,30,\"Breads, cereals, fastfood,grains\"\n" +
                    "Wheat germ,1 cup,68,245,17,7,3,2.5,34,\"Breads, cereals, fastfood,grains\"\n" +
                    "Wheat-germ cereal toasted,1 cup,65,260,20,7,3,2.5,36,\"Breads, cereals, fastfood,grains\"\n" +
                    "Wheat meal cereal unrefined,3/4 cup,30,103,4,1,0,0.7,25,\"Breads, cereals, fastfood,grains\"\n" +
                    "Wheat cooked,3/4 cup,200,275,12,1,0,4.4,35,\"Breads, cereals, fastfood,grains\"\n" +
                    "Bean soups,1 cup,250,190,8,5,4,0.6,30,Soups\n" +
                    "Beef soup,1 cup,250,100,6,4,4,0.5,11,Soups\n" +
                    "Bouillon,1 cup,240,24,5,0,0,0,0,Soups\n" +
                    "chicken soup,1 cup,250,75,4,2,2,0,10,Soups\n" +
                    "Clam chowder,1 cup,255,85,5,2,8,0.5,12,Soups\n" +
                    "Cream soups,1 cup,255,200,7,12,11,1.2,18,Soups\n" +
                    "Noodle,1 cup,250,115,6,4,3,0.2,13,Soups\n" +
                    "Split-pea soup,1 cup,250,147,8,3,3,0.5,25,Soups\n" +
                    "Tomato soup,1 cup,245,175,6,7,6,0.5,22,Soups\n" +
                    "Vegetable,1 cup,250,80,4,2,2,0,14,Soups\n" +
                    "Apple betty,1 serving,100,150,1,4,0,0.5,29,\"Desserts, sweets\"\n" +
                    "Bread pudding,3/4 cup,200,374,11,12,11,0.2,56,\"Desserts, sweets\"\n" +
                    "Cakes,1 slice,40,110,3,t,0,0,23,\"Desserts, sweets\"\n" +
                    "Chocolate fudge,1 slice,120,420,5,14,12,0.3,70,\"Desserts, sweets\"\n" +
                    "Cupcake,1,50,160,3,3,2,t,31,\"Desserts, sweets\"\n" +
                    "Fruit cake,1 slice,30,105,2,4,3,0.2,17,\"Desserts, sweets\"\n" +
                    "Gingerbread,1 slice,55,180,2,7,6,t,28,\"Desserts, sweets\"\n" +
                    "Plain with no icing,1 slice,55,180,4,5,4,t,31,\"Desserts, sweets\"\n" +
                    "Sponge cake,1 slice,40,115,3,2,2,0,22,\"Desserts, sweets\"\n" +
                    "Candy,5,25,104,t,3,3,0,19,\"Desserts, sweets\"\n" +
                    "Chocolate creams,2,30,130,t,4,4,0,24,\"Desserts, sweets\"\n" +
                    "Fudge,2 pieces,90,370,t,12,11,0.1,80,\"Desserts, sweets\"\n" +
                    "Hard candies,1 oz.,28,90,t,0,0,0,28,\"Desserts, sweets\"\n" +
                    "Marshmallows,5,30,98,1,0,0,0,23,\"Desserts, sweets\"\n" +
                    "Milk chocolate,2-oz. bar,56,290,2,6,6,0.2,44,\"Desserts, sweets\"\n" +
                    "Chocolate syrup,2 T.,40,80,t,t,t,0,22,\"Desserts, sweets\"\n" +
                    "Doughnuts,1,33,135,2,7,4,t,17,\"Desserts, sweets\"\n" +
                    "Gelatin made with water,1 cup,239,155,4,t,t,0,36,\"Desserts, sweets\"\n" +
                    "Honey,2 T.,42,120,t,0,0,0,30,\"Jams, Jellies\"\n" +
                    "Ice cream,2 cups,300,250,0,0,12,10,0,\"Desserts, sweets\"\n" +
                    "Ices,1 cup,150,117,0,0,0,0,48,\"Desserts, sweets\"\n" +
                    "preserves,1 T.,20,55,0,0,0,t,14,\"Jams, Jellies\"\n" +
                    "Jellies,1 T.,20,50,0,0,0,0,13,\"Jams, Jellies\"\n" +
                    "Molasses,1 T.,20,45,0,0,0,8,11,\"Jams, Jellies\"\n" +
                    "Cane Syrup,1 T.,20,50,0,0,0,0,13,\"Jams, Jellies\"\n" +
                    "9-inch diam. pie\",1 slice,135,330,3,13,11,0.1,53,\"Desserts, sweets\"\n" +
                    "Cherry Pie,1 slice,135,340,3,13,11,0.1,55,\"Desserts, sweets\"\n" +
                    "Custard,1 slice,130,265,7,11,10,0,34,\"Desserts, sweets\"\n" +
                    "Lemon meringue,1 slice,120,300,4,12,10,0.1,45,\"Desserts, sweets\"\n" +
                    "Mince,1 slice,135,340,3,9,8,0.7,62,\"Desserts, sweets\"\n" +
                    "Pumpkin Pie,1 slice,130,265,5,12,11,8,34,\"Desserts, sweets\"\n" +
                    "Puddings Sugar,1 cup,200,770,0,0,0,0,199,\"Desserts, sweets\"\n" +
                    "3 teaspoons sugar,1 T.,12,50,0,0,0,0,12,\"Desserts, sweets\"\n" +
                    "Brown firm-packed dark sugar,1 cup,220,815,0,t,0,0,210,\"Jams, Jellies\"\n" +
                    "Syrup,2 T.,40,100,0,0,0,0,25,\"Jams, Jellies\"\n" +
                    "table blends sugar,2 T.,40,110,0,0,0,0,29,\"Jams, Jellies\"\n" +
                    "Tapioca cream pudding,1 cup,250,335,10,10,9,0,42,\"Desserts, sweets\"\n" +
                    "Almonds,0.5 cup,70,425,13,38,28,1.8,13,Seeds and Nuts\n" +
                    "roasted and salted,0.5 cup,70,439,13,40,31,1.8,13,Seeds and Nuts\n" +
                    "Brazil nuts,0.5 cup,70,457,10,47,31,2,7,Seeds and Nuts\n" +
                    "Cashews,0.5 cup,70,392,12,32,28,0.9,20,Seeds and Nuts\n" +
                    "coconut sweetened,0.5 cup,50,274,1,20,19,2,26,Seeds and Nuts\n" +
                    "Peanut butter,0.33 cup,50,300,12,25,17,0.9,9,Seeds and Nuts\n" +
                    "Peanut butter natural,0.33 cup,50,284,13,24,10,0.9,8,Seeds and Nuts\n" +
                    "Peanuts,0.33 cup,50,290,13,25,16,1.2,9,Seeds and Nuts\n" +
                    "Pecans,0.5 cup,52,343,5,35,25,1.1,7,Seeds and Nuts\n" +
                    "Sesame seeds,0.5 cup,50,280,9,24,13,3.1,10,Seeds and Nuts\n" +
                    "Sunflower seeds,0.5 cup,50,280,12,26,7,1.9,10,Seeds and Nuts\n" +
                    "Walnuts,0.5 cup,50,325,7,32,7,1,8,Seeds and Nuts\n" +
                    "Beer,2 cups,480,228,t,0,0,0,8,\"Drinks,Alcohol, Beverages\"\n" +
                    "Gin,1 oz.,28,70,0,0,0,0,t,\"Drinks,Alcohol, Beverages\"\n" +
                    "Wines,0.5 cup,120,164,t,0,0,0,9,\"Drinks,Alcohol, Beverages\"\n" +
                    "Table (12.2% alcohol),0.5 cup,120,100,t,0,0,0,5,\"Drinks,Alcohol, Beverages\"\n" +
                    "Carbonated drinks Artificially sweetened,12 oz.,346,0,0,0,0,0,0,\"Drinks,Alcohol, Beverages\"\n" +
                    "Club soda,12 oz.,346,0,0,0,0,0,0,\"Drinks,Alcohol, Beverages\"\n" +
                    "Cola drinks,12 oz.,346,137,0,0,0,0,38,\"Drinks,Alcohol, Beverages\"\n" +
                    "Fruit-flavored soda,12 oz.,346,161,0,0,0,0,42,\"Drinks,Alcohol, Beverages\"\n" +
                    "Ginger ale,12 oz.,346,105,0,0,0,0,28,\"Drinks,Alcohol, Beverages\"\n" +
                    "Root beer,12 oz.,346,140,0,0,0,0,35,\"Drinks,Alcohol, Beverages\"\n" +
                    "Coffee,1 cup,230,3,t,0,0,0,1,\"Drinks,Alcohol, Beverages\"\n" +
                    "Tea,1 cup,230,4,0,t,0,0,1,\"Drinks,Alcohol, Beverages\"";
            String[] spline = line.split("\n");
            for (int i = 0; i < spline.length; i++) {
                if (cn == 0) {
                    cn += 1;
                    continue;
                }
                String[] values = spline[i].split(",");
                String cat = values[9];
                if (spline[i].contains("\"")) {
                    String[] val = spline[i].split("\"");
                    cat = val[val.length - 1];
                }
                dbHelper.insertFood(values[0], cat, values[3], values[1], date, username, values[4], values[8], values[5]);
            }
        }
        if(dbHelper.getExeNames().size()==0) {
            add_exedb();
        }
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
    public void add_exedb(){
        Context context=getApplicationContext();
        SQLiteDatabase sqLiteDatabase=context.openOrCreateDatabase("exeType",Context.MODE_PRIVATE,null);
        DBHelper dbHelper=new DBHelper(sqLiteDatabase);
        SharedPreferences sharedPreferences=getSharedPreferences("com.example.final_project",Context.MODE_PRIVATE);
        String str=sharedPreferences.getString(MainActivity.usernameKey,"");
        String username=str;
        DateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS exeType");
        String date="******";
        int cn=0;
        String line="\"Activity, Exercise or Sport (1 hour)\",130 lb,155 lb,180 lb,205 lb,Calories per kg\n" +
                "\"Cycling, mountain bike, bmx\",502,598,695,791,1.75072971940299\n" +
                "\"Cycling, <10 mph, leisure bicycling\",236,281,327,372,0.823235629850746\n" +
                "\"Cycling, >20 mph, racing\",944,1126,1308,1489,3.29497352835821\n" +
                "\"Cycling, 10-11.9 mph, light\",354,422,490,558,1.23485344477612\n" +
                "\"Cycling, 12-13.9 mph, moderate\",472,563,654,745,1.64782526567164\n" +
                "\"Cycling, 14-15.9 mph, vigorous\",590,704,817,931,2.05944308059702\n" +
                "\"Cycling, 16-19 mph, very fast, racing\",708,844,981,1117,2.47106089552239\n" +
                "Unicycling,295,352,409,465,1.02972154029851\n" +
                "\"Stationary cycling, very light\",177,211,245,279,0.61742672238806\n" +
                "\"Stationary cycling, light\",325,387,449,512,1.13262599402985\n" +
                "\"Stationary cycling, moderate\",413,493,572,651,1.44133935522388\n" +
                "\"Stationary cycling, vigorous\",620,739,858,977,2.16234753432836\n" +
                "\"Stationary cycling, very vigorous\",738,880,1022,1163,2.57464235223881\n" +
                "\"Calisthenics, vigorous, pushups, situps…\",472,563,654,745,1.64782526567164\n" +
                "\"Calisthenics, light\",207,246,286,326,0.721008179104478\n" +
                "\"Circuit training, minimal rest\",472,563,654,745,1.64782526567164\n" +
                "\"Weight lifting, body building, vigorous\",354,422,490,558,1.23485344477612\n" +
                "\"Weight lifting, light workout\",177,211,245,279,0.61742672238806\n" +
                "Health club exercise,325,387,449,512,1.13262599402985\n" +
                "Stair machine,531,633,735,838,1.85295717014925\n" +
                "\"Rowing machine, light\",207,246,286,326,0.721008179104478\n" +
                "\"Rowing machine, moderate\",413,493,572,651,1.44133935522388\n" +
                "\"Rowing machine, vigorous\",502,598,695,791,1.75072971940299\n" +
                "\"Rowing machine, very vigorous\",708,844,981,1117,2.47106089552239\n" +
                "Ski machine,413,493,572,651,1.44133935522388\n" +
                "\"Aerobics, low impact\",295,352,409,465,1.02972154029851\n" +
                "\"Aerobics, high impact\",413,493,572,651,1.44133935522388\n" +
                "\"Aerobics, step aerobics\",502,598,695,791,1.75072971940299\n" +
                "\"Aerobics, general\",384,457,531,605,1.33843490149254\n" +
                "Jazzercise,354,422,490,558,1.23485344477612\n" +
                "\"Stretching, hatha yoga\",236,281,327,372,0.823235629850746\n" +
                "Mild stretching,148,176,204,233,0.515199271641791\n" +
                "Instructing aerobic class,354,422,490,558,1.23485344477612\n" +
                "Water aerobics,236,281,327,372,0.823235629850746\n" +
                "\"Ballet, twist, jazz, tap\",266,317,368,419,0.927494089552239\n" +
                "\"Ballroom dancing, slow\",177,211,245,279,0.61742672238806\n" +
                "\"Ballroom dancing, fast\",325,387,449,512,1.13262599402985\n" +
                "\"Running, 5 mph (12 minute mile)\",472,563,654,745,1.64782526567164\n" +
                "\"Running, 5.2 mph (11.5 minute mile)\",531,633,735,838,1.85295717014925\n" +
                "\"Running, 6 mph (10 min mile)\",590,704,817,931,2.05944308059702\n" +
                "\"Running, 6.7 mph (9 min mile)\",649,774,899,1024,2.2652519880597\n" +
                "\"Running, 7 mph (8.5 min mile)\",679,809,940,1070,2.36815644179104\n" +
                "\"Running, 7.5mph (8 min mile)\",738,880,1022,1163,2.57464235223881\n" +
                "\"Running, 8 mph (7.5 min mile)\",797,950,1103,1256,2.77977425671642\n" +
                "\"Running, 8.6 mph (7 min mile)\",826,985,1144,1303,2.88267871044776\n" +
                "\"Running, 9 mph (6.5 min mile)\",885,1056,1226,1396,3.08916462089552\n" +
                "\"Running, 10 mph (6 min mile)\",944,1126,1308,1489,3.29497352835821\n" +
                "\"Running, 10.9 mph (5.5 min mile)\",1062,1267,1471,1675,3.70659134328358\n" +
                "\"Running, cross country\",531,633,735,838,1.85295717014925\n" +
                "\"Running, general\",472,563,654,745,1.64782526567164\n" +
                "\"Running, on a track, team practice\",590,704,817,931,2.05944308059702\n" +
                "\"Running, stairs, up\",885,1056,1226,1396,3.08916462089552\n" +
                "\"Track and field (shot, discus)\",236,281,327,372,0.823235629850746\n" +
                "\"Track and field (high jump, pole vault)\",354,422,490,558,1.23485344477612\n" +
                "Track and field (hurdles),590,704,817,931,2.05944308059702\n" +
                "Archery,207,246,286,326,0.721008179104478\n" +
                "Badminton,266,317,368,419,0.927494089552239\n" +
                "\"Basketball game, competitive\",472,563,654,745,1.64782526567164\n" +
                "\"Playing basketball, non game\",354,422,490,558,1.23485344477612\n" +
                "\"Basketball, officiating\",413,493,572,651,1.44133935522388\n" +
                "\"Basketball, shooting baskets\",266,317,368,419,0.927494089552239\n" +
                "\"Basketball, wheelchair\",384,457,531,605,1.33843490149254\n" +
                "\"Running, training, pushing wheelchair\",472,563,654,745,1.64782526567164\n" +
                "Billiards,148,176,204,233,0.515199271641791\n" +
                "Bowling,177,211,245,279,0.61742672238806\n" +
                "\"Boxing, in ring\",708,844,981,1117,2.47106089552239\n" +
                "\"Boxing, punching bag\",354,422,490,558,1.23485344477612\n" +
                "\"Boxing, sparring\",531,633,735,838,1.85295717014925\n" +
                "\"Coaching: football, basketball, soccer…\",236,281,327,372,0.823235629850746\n" +
                "\"Cricket (batting, bowling)\",295,352,409,465,1.02972154029851\n" +
                "Croquet,148,176,204,233,0.515199271641791\n" +
                "Curling,236,281,327,372,0.823235629850746\n" +
                "Darts (wall or lawn),148,176,204,233,0.515199271641791\n" +
                "Fencing,354,422,490,558,1.23485344477612\n" +
                "\"Football, competitive\",531,633,735,838,1.85295717014925\n" +
                "\"Football, touch, flag, general\",472,563,654,745,1.64782526567164\n" +
                "\"Football or baseball, playing catch\",148,176,204,233,0.515199271641791\n" +
                "\"Frisbee playing, general\",177,211,245,279,0.61742672238806\n" +
                "\"Frisbee, ultimate frisbee\",472,563,654,745,1.64782526567164\n" +
                "\"Golf, general\",266,317,368,419,0.927494089552239\n" +
                "\"Golf, walking and carrying clubs\",266,317,368,419,0.927494089552239\n" +
                "\"Golf, driving range\",177,211,245,279,0.61742672238806\n" +
                "\"Golf, miniature golf\",177,211,245,279,0.61742672238806\n" +
                "\"Golf, walking and pulling clubs\",254,303,351,400,0.885519904477612\n" +
                "\"Golf, using power cart\",207,246,286,326,0.721008179104478\n" +
                "Gymnastics,236,281,327,372,0.823235629850746\n" +
                "Hacky sack,236,281,327,372,0.823235629850746\n" +
                "Handball,708,844,981,1117,2.47106089552239\n" +
                "\"Handball, team\",472,563,654,745,1.64782526567164\n" +
                "\"Hockey, field hockey\",472,563,654,745,1.64782526567164\n" +
                "\"Hockey, ice hockey\",472,563,654,745,1.64782526567164\n" +
                "\"Riding a horse, general\",236,281,327,372,0.823235629850746\n" +
                "\"Horesback riding, saddling horse\",207,246,286,326,0.721008179104478\n" +
                "\"Horseback riding, grooming horse\",207,246,286,326,0.721008179104478\n" +
                "\"Horseback riding, trotting\",384,457,531,605,1.33843490149254\n" +
                "\"Horseback riding, walking\",148,176,204,233,0.515199271641791\n" +
                "\"Horse racing, galloping\",472,563,654,745,1.64782526567164\n" +
                "\"Horse grooming, moderate\",354,422,490,558,1.23485344477612\n" +
                "Horseshoe pitching,177,211,245,279,0.61742672238806\n" +
                "Jai alai,708,844,981,1117,2.47106089552239\n" +
                "\"Martial arts, judo, karate, jujitsu\",590,704,817,931,2.05944308059702\n" +
                "\"Martial arts, kick boxing\",590,704,817,931,2.05944308059702\n" +
                "\"Martial arts, tae kwan do\",590,704,817,931,2.05944308059702\n" +
                "Krav maga training,590,704,817,931,2.05944308059702\n" +
                "Juggling,236,281,327,372,0.823235629850746\n" +
                "Kickball,413,493,572,651,1.44133935522388\n" +
                "Lacrosse,472,563,654,745,1.64782526567164\n" +
                "Orienteering,531,633,735,838,1.85295717014925\n" +
                "Playing paddleball,354,422,490,558,1.23485344477612\n" +
                "\"Paddleball, competitive\",590,704,817,931,2.05944308059702\n" +
                "Polo,472,563,654,745,1.64782526567164\n" +
                "\"Racquetball, competitive\",590,704,817,931,2.05944308059702\n" +
                "Playing racquetball,413,493,572,651,1.44133935522388\n" +
                "\"Rock climbing, ascending rock\",649,774,899,1024,2.2652519880597\n" +
                "\"Rock climbing, rappelling\",472,563,654,745,1.64782526567164\n" +
                "\"Jumping rope, fast\",708,844,981,1117,2.47106089552239\n" +
                "\"Jumping rope, moderate\",590,704,817,931,2.05944308059702\n" +
                "\"Jumping rope, slow\",472,563,654,745,1.64782526567164\n" +
                "Rugby,590,704,817,931,2.05944308059702\n" +
                "\"Shuffleboard, lawn bowling\",177,211,245,279,0.61742672238806\n" +
                "Skateboarding,295,352,409,465,1.02972154029851\n" +
                "Roller skating,413,493,572,651,1.44133935522388\n" +
                "\"Roller blading, in-line skating\",708,844,981,1117,2.47106089552239\n" +
                "Sky diving,177,211,245,279,0.61742672238806\n" +
                "\"Soccer, competitive\",590,704,817,931,2.05944308059702\n" +
                "Playing soccer,413,493,572,651,1.44133935522388\n" +
                "Softball or baseball,295,352,409,465,1.02972154029851\n" +
                "\"Softball, officiating\",236,281,327,372,0.823235629850746\n" +
                "\"Softball, pitching\",354,422,490,558,1.23485344477612\n" +
                "Squash,708,844,981,1117,2.47106089552239\n" +
                "\"Table tennis, ping pong\",236,281,327,372,0.823235629850746\n" +
                "Tai chi,236,281,327,372,0.823235629850746\n" +
                "Playing tennis,413,493,572,651,1.44133935522388\n" +
                "\"Tennis, doubles\",354,422,490,558,1.23485344477612\n" +
                "\"Tennis, singles\",472,563,654,745,1.64782526567164\n" +
                "Trampoline,207,246,286,326,0.721008179104478\n" +
                "\"Volleyball, competitive\",472,563,654,745,1.64782526567164\n" +
                "Playing volleyball,177,211,245,279,0.61742672238806\n" +
                "\"Volleyball, beach\",472,563,654,745,1.64782526567164\n" +
                "Wrestling,354,422,490,558,1.23485344477612\n" +
                "Wallyball,413,493,572,651,1.44133935522388\n" +
                "\"Backpacking, Hiking with pack\",413,493,572,651,1.44133935522388\n" +
                "\"Carrying infant, level ground\",207,246,286,326,0.721008179104478\n" +
                "\"Carrying infant, upstairs\",295,352,409,465,1.02972154029851\n" +
                "\"Carrying 16 to 24 lbs, upstairs\",354,422,490,558,1.23485344477612\n" +
                "\"Carrying 25 to 49 lbs, upstairs\",472,563,654,745,1.64782526567164\n" +
                "\"Standing, playing with children, light\",165,197,229,261,0.576806543283582\n" +
                "\"Walk/run, playing with children, moderate\",236,281,327,372,0.823235629850746\n" +
                "\"Walk/run, playing with children, vigorous\",295,352,409,465,1.02972154029851\n" +
                "Carrying small children,177,211,245,279,0.61742672238806\n" +
                "\"Loading, unloading car\",177,211,245,279,0.61742672238806\n" +
                "\"Climbing hills, carrying up to 9 lbs\",413,493,572,651,1.44133935522388\n" +
                "\"Climbing hills, carrying 10 to 20 lb\",443,528,613,698,1.5449208119403\n" +
                "\"Climbing hills, carrying 21 to 42 lb\",472,563,654,745,1.64782526567164\n" +
                "\"Climbing hills, carrying over 42 lb\",531,633,735,838,1.85295717014925\n" +
                "Walking downstairs,177,211,245,279,0.61742672238806\n" +
                "\"Hiking, cross country\",354,422,490,558,1.23485344477612\n" +
                "Bird watching,148,176,204,233,0.515199271641791\n" +
                "\"Marching, rapidly, military\",384,457,531,605,1.33843490149254\n" +
                "\"Childrens games, hopscotch, dodgeball\",295,352,409,465,1.02972154029851\n" +
                "Pushing stroller or walking with children,148,176,204,233,0.515199271641791\n" +
                "Pushing a wheelchair,236,281,327,372,0.823235629850746\n" +
                "Race walking,384,457,531,605,1.33843490149254\n" +
                "\"Rock climbing, mountain climbing\",472,563,654,745,1.64782526567164\n" +
                "Walking using crutches,295,352,409,465,1.02972154029851\n" +
                "Walking the dog,177,211,245,279,0.61742672238806\n" +
                "\"Walking, under 2.0 mph, very slow\",118,141,163,186,0.411617814925373\n" +
                "\"Walking 2.0 mph, slow\",148,176,204,233,0.515199271641791\n" +
                "Walking 2.5 mph,177,211,245,279,0.61742672238806\n" +
                "\"Walking 3.0 mph, moderate\",195,232,270,307,0.679710997014925\n" +
                "\"Walking 3.5 mph, brisk pace\",224,267,311,354,0.782615450746269\n" +
                "\"Walking 3.5 mph, uphill\",354,422,490,558,1.23485344477612\n" +
                "\"Walking 4.0 mph, very brisk\",295,352,409,465,1.02972154029851\n" +
                "Walking 4.5 mph,372,443,515,586,1.29713771940299\n" +
                "Walking 5.0 mph,472,563,654,745,1.64782526567164\n" +
                "\"Boating, power, speed boat\",148,176,204,233,0.515199271641791\n" +
                "\"Canoeing, camping trip\",236,281,327,372,0.823235629850746\n" +
                "\"Canoeing, rowing, light\",177,211,245,279,0.61742672238806\n" +
                "\"Canoeing, rowing, moderate\",413,493,572,651,1.44133935522388\n" +
                "\"Canoeing, rowing, vigorous\",708,844,981,1117,2.47106089552239\n" +
                "\"Crew, sculling, rowing, competition\",708,844,981,1117,2.47106089552239\n" +
                "Kayaking,295,352,409,465,1.02972154029851\n" +
                "Paddle boat,236,281,327,372,0.823235629850746\n" +
                "\"Windsurfing, sailing\",177,211,245,279,0.61742672238806\n" +
                "\"Sailing, competition\",295,352,409,465,1.02972154029851\n" +
                "\"Sailing, yachting, ocean sailing\",177,211,245,279,0.61742672238806\n" +
                "\"Skiing, water skiing\",354,422,490,558,1.23485344477612\n" +
                "Ski mobiling,413,493,572,651,1.44133935522388\n" +
                "\"Skin diving, fast\",944,1126,1308,1489,3.29497352835821\n" +
                "\"Skin diving, moderate\",738,880,1022,1163,2.57464235223881\n" +
                "\"Skin diving, scuba diving\",413,493,572,651,1.44133935522388\n" +
                "Snorkeling,295,352,409,465,1.02972154029851\n" +
                "\"Surfing, body surfing or board surfing\",177,211,245,279,0.61742672238806\n" +
                "\"Whitewater rafting, kayaking, canoeing\",295,352,409,465,1.02972154029851\n" +
                "\"Swimming laps, freestyle, fast\",590,704,817,931,2.05944308059702\n" +
                "\"Swimming laps, freestyle, slow\",413,493,572,651,1.44133935522388\n" +
                "Swimming backstroke,413,493,572,651,1.44133935522388\n" +
                "Swimming breaststroke,590,704,817,931,2.05944308059702\n" +
                "Swimming butterfly,649,774,899,1024,2.2652519880597\n" +
                "\"Swimming leisurely, not laps\",354,422,490,558,1.23485344477612\n" +
                "Swimming sidestroke,472,563,654,745,1.64782526567164\n" +
                "Swimming synchronized,472,563,654,745,1.64782526567164\n" +
                "\"Swimming, treading water, fast, vigorous\",590,704,817,931,2.05944308059702\n" +
                "\"Swimming, treading water, moderate\",236,281,327,372,0.823235629850746\n" +
                "\"Water aerobics, water calisthenics\",236,281,327,372,0.823235629850746\n" +
                "Water polo,590,704,817,931,2.05944308059702\n" +
                "Water volleyball,177,211,245,279,0.61742672238806\n" +
                "Water jogging,472,563,654,745,1.64782526567164\n" +
                "\"Diving, springboard or platform\",177,211,245,279,0.61742672238806\n" +
                "\"Ice skating, < 9 mph\",325,387,449,512,1.13262599402985\n" +
                "\"Ice skating, average speed\",413,493,572,651,1.44133935522388\n" +
                "\"Ice skating, rapidly\",531,633,735,838,1.85295717014925\n" +
                "\"Speed skating, ice, competitive\",885,1056,1226,1396,3.08916462089552\n" +
                "\"Cross country snow skiing, slow\",413,493,572,651,1.44133935522388\n" +
                "\"Cross country skiing, moderate\",472,563,654,745,1.64782526567164\n" +
                "\"Cross country skiing, vigorous\",531,633,735,838,1.85295717014925\n" +
                "\"Cross country skiing, racing\",826,985,1144,1303,2.88267871044776\n" +
                "\"Cross country skiing, uphill\",974,1161,1348,1536,3.39787798208955\n" +
                "\"Snow skiing, downhill skiing, light\",295,352,409,465,1.02972154029851\n" +
                "\"Downhill snow skiing, moderate\",354,422,490,558,1.23485344477612\n" +
                "\"Downhill snow skiing, racing\",472,563,654,745,1.64782526567164\n" +
                "\"Sledding, tobagganing, luge\",413,493,572,651,1.44133935522388\n" +
                "Snow shoeing,472,563,654,745,1.64782526567164\n" +
                "Snowmobiling,207,246,286,326,0.721008179104478\n" +
                "General housework,207,246,286,326,0.721008179104478\n" +
                "Cleaning gutters,295,352,409,465,1.02972154029851\n" +
                "Painting,266,317,368,419,0.927494089552239\n" +
                "\"Sit, playing with animals\",148,176,204,233,0.515199271641791\n" +
                "\"Walk / run, playing with animals\",236,281,327,372,0.823235629850746\n" +
                "Bathing dog,207,246,286,326,0.721008179104478\n" +
                "\"Mowing lawn, walk, power mower\",325,387,449,512,1.13262599402985\n" +
                "\"Mowing lawn, riding mower\",148,176,204,233,0.515199271641791\n" +
                "\"Walking, snow blower\",207,246,286,326,0.721008179104478\n" +
                "\"Riding, snow blower\",177,211,245,279,0.61742672238806\n" +
                "Shoveling snow by hand,354,422,490,558,1.23485344477612\n" +
                "Raking lawn,254,303,351,400,0.885519904477612\n" +
                "\"Gardening, general\",236,281,327,372,0.823235629850746\n" +
                "\"Bagging grass, leaves\",236,281,327,372,0.823235629850746\n" +
                "Watering lawn or garden,89,106,123,140,0.310067367164179\n" +
                "\"Weeding, cultivating garden\",266,317,368,419,0.927494089552239\n" +
                "\"Carpentry, general\",207,246,286,326,0.721008179104478\n" +
                "Carrying heavy loads,472,563,654,745,1.64782526567164\n" +
                "Carrying moderate loads upstairs,472,563,654,745,1.64782526567164\n" +
                "General cleaning,207,246,286,326,0.721008179104478\n" +
                "\"Cleaning, dusting\",148,176,204,233,0.515199271641791\n" +
                "Taking out trash,177,211,245,279,0.61742672238806\n" +
                "\"Walking, pushing a wheelchair\",236,281,327,372,0.823235629850746\n" +
                "\"Teach physical education,exercise class\",236,281,327,372,0.823235629850746\n";
        String[]spline=line.split("\n");
        for(int i=0;i<spline.length;i++){
            if(cn==0){
                cn+=1;
                continue;
            }
            String[] values=spline[i].split(",");
            String name=values[0];
            if(spline[i].contains("\"")){
                String[] val=spline[i].split("\"");
                name=val[1];
            }
            dbHelper.insertExe(name, (int)(Double.valueOf(values[values.length-1])*Double.valueOf(sharedPreferences.getString(MainActivity.weight,""))*0.45359237) +"","1 hour",username,date);
        }
    }
}