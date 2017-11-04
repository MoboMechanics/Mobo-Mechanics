package com.example.saddam.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem extends AppCompatActivity  implements View.OnClickListener,ExpandableListView.OnChildClickListener {

    com.example.saddam.myapplication.ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    HashMap<String,Integer> images;
    HashMap<String,String> videos;
    ImageView img;

    public ArrayList<String> problems;
    public ArrayList<String> solutions;

    Button find;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problems);
        expListView = (ExpandableListView) findViewById(R.id.problems);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        find = (Button) findViewById(R.id.find_mechanic);

        problems = (ArrayList<String>) getIntent().getSerializableExtra("problems");
        solutions = (ArrayList<String>) getIntent().getSerializableExtra("solutions");
        // preparing list data
        prepareListData(problems,solutions);

//        getActionBar().setDisplayShowHomeEnabled(true);
        LoadImages();
        LoadVideos();
        img= (ImageView) findViewById(R.id.solTutorial);
        img.setOnClickListener(this);
        expListView.setOnChildClickListener(this);


        listAdapter = new com.example.saddam.myapplication.ExpandableListAdapter(this, listDataHeader,
                listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
        find.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.home)
            finish();
        return true;
    }

    private void prepareListData(ArrayList<String> prob, ArrayList<String> sol) {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        List<List<String>> Solution = new ArrayList<List<String>>(problems.size());

        for(int i = 0; i < problems.size(); i++)  {
            Solution.add(new ArrayList<String>());
        }
        for(int i=0; i<problems.size();i++)
        {
            listDataHeader.add(problems.get(i));
            Solution.get(i).add(sol.get(i));
            listDataChild.put(listDataHeader.get(i), Solution.get(i));
        }
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition,
                                int childPosition, long id)
    {
        Toast.makeText(getApplicationContext(),"toast is showing",Toast.LENGTH_LONG).show();
        String data=listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition).toString();

        if(data=="Check Engine Oil level"){
            Intent you=new Intent(this,YoutubeActivity.class);
            Config.YOUTUBE_VIDEO_CODE="Yo2hJym2Ihw";
            startActivity(you);
            Toast.makeText(getApplicationContext(),data,Toast.LENGTH_LONG).show();
        }
        else {
            ImageView img = (ImageView) findViewById(R.id.solTutorial);
            img.setVisibility(View.VISIBLE);
            img.setBackground(getResources().getDrawable(R.drawable.remove_spark_plug));
        }
        //Toast.makeText(getApplicationContext(),data,Toast.LENGTH_LONG).show();

/*
        String key=data;
        Integer value=0;
        String val=null;
        boolean flag=false;
        for(String keyy : images.keySet()) {
            if(keyy==key) {
                value = (Integer) images.get(key);
                flag=false;
                //Toast.makeText(this, "Key: " + keyy + " Value: " + value, Toast.LENGTH_LONG).show();
            }
        }
        for(String keyy : videos.keySet()) {
            if(keyy==key) {
                val = (String) videos.get(key);
                flag=true;
                //Toast.makeText(this, "Key: " + keyy + " Value: " + value, Toast.LENGTH_LONG).show();
            }
        }
        if(flag==false) {
            ImageView img = (ImageView) findViewById(R.id.solTutorial);
            img.setVisibility(View.VISIBLE);
            img.setBackground(getResources().getDrawable(value));
        }
        else {

            Intent intent=new Intent(this, YoutubeActivity.class);
            Config.YOUTUBE_VIDEO_CODE=val;
            //intent.putExtra("id",val);
            startActivity(intent);
        }*/
        return true;
    }

    public void LoadImages(){
        images=new HashMap<String, Integer>();
        images.put("Replace plug",R.drawable.remove_spark_plug);
        images.put("Replace plug or clean it if Cleanable",R.drawable.remove_spark_plug);
        images.put("charge car Battery",R.drawable.howtojumpstart);
        images.put("Check Air Pressure in Tyres",R.drawable.airguage);
        images.put("Check Engine Oil level",R.drawable.oillevel);
        images.put("Check Transmission Fluid Level",R.drawable.oillevel);
        images.put("Check Air Filter",R.drawable.filter);
        images.put("Insert Coolant",R.drawable.coolant);
        images.put("Schedule a brake inspection asap",R.drawable.brake);
    }

    public void LoadVideos(){
        videos=new HashMap<String,String>();
        videos.put("Change Belt","dCCS1d40WGU");
        videos.put("Change Engine Oil","Yo2hJym2Ihw");
        videos.put("Grease the Belt","dDzVDNdcQiM");
        videos.put("Correct the Alignment of the belt","yKFAmfeaycs");
        videos.put("Check Fan or Refer Mechanic","6VHlzGaFNGo");
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.find_mechanic:
                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(i);
                break;
            case R.id.solTutorial:
                recreate();
        }
    }
}
