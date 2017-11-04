package com.example.saddam.myapplication;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class GeneralActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout linear;
    ArrayList<String> CheckedList, symptoms;
    SymptomDbHelper db;
    public String symptom=null;

    private ProgressDialog pDialog;
    public String get;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);

        setSymptoms();
        symptoms = db.getAllSymptom();

        Button next = (Button) findViewById(R.id.next);
        LinearLayout myRoot = (LinearLayout) findViewById(R.id.container);
        LinearLayout a = new LinearLayout(this);
        a.setOrientation(LinearLayout.VERTICAL);
        a.setGravity(LinearLayout.TEXT_ALIGNMENT_CENTER);
        for (int i = 0; i < symptoms.size(); i++) {
            CheckBox chkbox = new CheckBox(this);
            chkbox.setText(symptoms.get(i));
            chkbox.setId(i);
            a.addView(chkbox);
        }
        myRoot.addView(a);
        next.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int totalCB = 0;
        CheckedList = new ArrayList<String>();
        switch (v.getId()) {
            case R.id.next:
                totalCB = symptoms.size();
                for (int i = 0; i < totalCB; i++) {
                    CheckBox cb = (CheckBox) findViewById(i);
                    boolean checked = cb.isChecked();// status of checkbox

                    if(checked){
                        String st=cb.getText().toString();
                        CheckedList.add((st.replaceAll(" ","-").toLowerCase()));
                    }
                }


                if(CheckedList.size()>0)
                symptom = CheckedList.get(0);
                else {
                    final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this).setTitle("!!!!!!")
                            .setMessage("Select one option")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                    alertDialog.create();
                    alertDialog.show();
                }
                if(CheckedList.size()>1)
                {
                    symptom = symptom +"-and";
                    for(int k=1;k<CheckedList.size(); k++)
                    {
                        symptom = symptom+"-"+(CheckedList.get(k)).toLowerCase();
                        if(k<CheckedList.size()-1)
                        {
                            symptom = symptom +"-and";
                        }
                    }
                }
        }
        if(CheckedList.size()>0)
        new getString().execute();
    }


    /**
     * Async task class to get json by making HTTP call
     */
    private class getString extends AsyncTask<Object, Object, String> {


        @Override
        protected String doInBackground(Object... params) {

            InputStream stream = null;

            HttpHandler a = new HttpHandler();

            get=a.makeServiceCall("http://10.0.2.2:8080/WebService/NewServlet?symptom="+symptom);
            ///get = a.convertStreamToString(gtet);

            return get;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(GeneralActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();

            Toast.makeText(getApplicationContext(),get,Toast.LENGTH_LONG).show();

            get=get.replace("(","");
            get=get.replace(")","");

            StringTokenizer st  = new StringTokenizer(get,",");

            ArrayList<String> arr = new ArrayList<String>();

            ArrayList<String> problems = new ArrayList<String>();
            ArrayList<String> solutions = new ArrayList<String>();

            while (st.hasMoreTokens()) {
                arr.add(st.nextToken().toString());
            }



            for(int i=0; i< arr.size(); i++)
            {
                StringTokenizer stnzr = new StringTokenizer(arr.get(i).toString(),"-");

                problems.add(stnzr.nextToken().toString());
                solutions.add(stnzr.nextToken().toString());
            }

            Intent intent = new Intent(getApplicationContext(), Problem.class);
            intent.putExtra("problems", problems);
            intent.putExtra("solutions", solutions);
            //intent.putExtra("get", get); // getText() SHOULD NOT be static!!!

            startActivity(intent);
        }
    }


















    public void setSymptoms() {
        String[] Symptoms = {"Hard Start","High Fuel Consumption","Jerking Car","Gear Slipping"};
        db = new SymptomDbHelper(this);

        for (int i = 0; i < Symptoms.length; i++) {
            db.insertSymptom(Symptoms[i]);
            Log.d(db.numberOfRows()+"", "Rows number: ");
        }
    }

}