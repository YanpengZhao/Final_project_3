package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class create_exe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_exe);
    }
    public void create_back(View view){
        EditText nameE=(EditText) findViewById(R.id.nameEn2);
        EditText caloryE=(EditText) findViewById(R.id.calEn2);
        EditText serveE=(EditText) findViewById(R.id.unitEn);
        String name=nameE.getText().toString();
        String calory=caloryE.getText().toString();
        String unit=serveE.getText().toString();
        Context context=getApplicationContext();
        SQLiteDatabase sqLiteDatabase=context.openOrCreateDatabase("exeType",Context.MODE_PRIVATE,null);
        DBHelper dbHelper=new DBHelper(sqLiteDatabase);
        SharedPreferences sharedPreferences=getSharedPreferences("com.example.final_project",Context.MODE_PRIVATE);
        String str=sharedPreferences.getString(MainActivity.usernameKey,"");
        String username=str;
        DateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String date="******";
        dbHelper.insertExe(name,calory,unit,username,date);
        Intent intent=new Intent(this,MainActivity2.class);
        startActivity(intent);
    }
    public void createOnline(View view){
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
        Intent intent=new Intent(this,MainActivity2.class);
        startActivity(intent);
    }
}