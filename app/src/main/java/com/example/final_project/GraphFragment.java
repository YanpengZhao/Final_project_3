package com.example.final_project;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GraphFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GraphFragment extends Fragment {

    LineGraphSeries<DataPoint> series;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GraphFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GraphFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GraphFragment newInstance(String param1, String param2) {
        GraphFragment fragment = new GraphFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_graph, container, false);
        GraphView graph = (GraphView) rootView.findViewById(R.id.graph);
        Context context=this.getActivity().getApplicationContext();
        SQLiteDatabase sqLiteDatabase=context.openOrCreateDatabase("foodType",Context.MODE_PRIVATE,null);
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("com.example.final_project", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("username","");
        DBHelper dbHelper=new DBHelper(sqLiteDatabase);
        dbHelper.getUserFood(name);
        ArrayList<FoodType> foodList = new ArrayList<FoodType>();
        foodList = dbHelper.getUserFood(name);
        ArrayList<DataPoint> datapp=new ArrayList<>();

        ArrayList<String> hold=new ArrayList<>();
        ArrayList<Double> tcal=new ArrayList<>();
        for(int i=0;i<foodList.size();i++){
            String fn=foodList.get(i).getDate().split(" ")[0];
            if(!hold.contains(fn)) {
                hold.add(fn);
            }
        }
        for (int k=0;k<hold.size();k++){
            Double addcal=0.0;
            for(int p=0;p<foodList.size();p++){
                String bla=foodList.get(p).getDate().split(" ")[0];
                String blu=hold.get(k);
                if(bla.equals(blu)){
                    addcal+=Double.valueOf(foodList.get(p).getCalory());
                    Log.d("addcal",addcal+"");
                }
            }
            tcal.add(addcal);
        }
        DataPoint[]  datap=new DataPoint[hold.size()];
        if(foodList.size()!=0){
            for(int i=0;i<hold.size();i++){
                datap[i]=new DataPoint(i+1,tcal.get(i));
            }
        }
        Log.d("a",hold.toString());
        Log.d("b",tcal.toString());
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(datap);
        series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
            }
        });

        series.setTitle("calories assumption past 7 days");
        graph.getLegendRenderer().setVisible(true);
//series.setValuesOnTopSize(50);
        graph.addSeries(series);
        series.setDataWidth(0.5);
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        graph.getViewport().setMinX(1);
        graph.getViewport().setMaxX(7);
        graph.getViewport().setMinY(0);
        graph.getViewport().setMaxY(10000);
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setXAxisBoundsManual(true);
        return rootView;
    }
}