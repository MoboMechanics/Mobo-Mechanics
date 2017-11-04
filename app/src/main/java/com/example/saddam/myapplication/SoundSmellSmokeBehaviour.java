package com.example.saddam.myapplication;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SoundSmellSmokeBehaviour extends AppCompatActivity implements View.OnClickListener {

    Button next;
    CheckBox soundChk = null,smokeChk=null,smellChk=null,behaviourChk=null;
    ArrayList<String> symptoms,sound,smoke,smell,behaviour,CheckedList;
    int intValue=0;
    SymptomDbHelper db;

    TextView showText,showTextt,showTexttt,showTextttt;
    boolean soundd = false, smelll = false, smokee = false, behaviourr = false, check=false;
    int loop=0;

    boolean smk=false;
    public String get =null;
    public URL url;
    private ProgressDialog pDialog;
    public String symptom=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_smell_smoke_behaviour);

        sound=new ArrayList<>();
        sound.add("Squeaky Belt noise");
        smoke=new ArrayList<>();

        smoke.add("Blue Smoke");
        smoke.add("White Smoke");
        smoke.add("Black Smoke");

        smell=new ArrayList<>();
        smell.add("Burning Rubber");
        smell.add("Burning Oil");
        smell.add("Gasoline Smell");
        smell.add("Burning Carpet");

        behaviour=new ArrayList<>();
        behaviour.add("Engine missfire");
        behaviour.add("Lack of acceleration");
        behaviour.add("OverHeating engine");

        next= (Button) findViewById(R.id.nexxt);
        next.setOnClickListener(this);

        showText= (TextView) findViewById(R.id.showText);
        showTextt= (TextView) findViewById(R.id.showTextt);
        showTexttt= (TextView) findViewById(R.id.showTexttt);
        showTextttt= (TextView) findViewById(R.id.showTextttt);

        LinearLayout container= (LinearLayout) findViewById(R.id.containerr);
        LinearLayout containerr= (LinearLayout) findViewById(R.id.containerrr);
        LinearLayout containerrr= (LinearLayout) findViewById(R.id.containerrrr);
        LinearLayout containerrrr= (LinearLayout) findViewById(R.id.containerrrrr);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Intent mIntent = getIntent();

        soundd=mIntent.getBooleanExtra("sound",false);
        smelll=mIntent.getBooleanExtra("smell",false);
        smokee=mIntent.getBooleanExtra("smoke",false);
        behaviourr=mIntent.getBooleanExtra("behaviour",false);

        if(soundd==true)
        {
            //    setSoundSymptoms();
            //  sound = db.getAllSoundSymptom();
            showText.setVisibility(View.VISIBLE);
            showText.setText("Engine Sound");

            for(int i=0; i<sound.size();i++)
            {
                soundChk=new CheckBox(this);
                soundChk.setText(sound.get(i));
                soundChk.setId(loop);
                container.addView(soundChk);
                loop++;
            }
            container.setVisibility(View.VISIBLE);
        }
        if(smelll==true)
        {
            showTextt.setVisibility(View.VISIBLE);
            //setSmellSymptoms();
            //smell = db.getAllSmellSymptom();
            showTextt.setText("Engine Smell");
            for(int i=0; i<smell.size();i++)
            {
                smellChk=new CheckBox(this);
                smellChk.setText(smell.get(i));
                smellChk.setId(loop);
                containerr.addView(smellChk);
                loop++;
            }
            containerr.setVisibility(View.VISIBLE);

        }
        if(smokee==true)
        {
            showTexttt.setVisibility(View.VISIBLE);
            showTexttt.setText("Engine Smoke");
            for(int i=0; i<smoke.size();i++)
            {
                smokeChk=new CheckBox(this);
                smokeChk.setText(smoke.get(i));
                smokeChk.setId(loop);
                containerrr.addView(smokeChk);
                loop++;
            }
            containerrr.setVisibility(View.VISIBLE);

        }
        if(behaviourr==true)
        {
            showTextttt.setVisibility(View.VISIBLE);
            showTextttt.setText("Engine Behaviour");
            for(int i=0; i<behaviour.size();i++)
            {
                behaviourChk=new CheckBox(this);
                behaviourChk.setText(behaviour.get(i));
                behaviourChk.setId(loop);
                containerrrr.addView(behaviourChk);
                loop++;
            }
            containerrrr.setVisibility(View.VISIBLE);
        }
        Log.d("Loop : ", ""+loop);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.home)
            finish();
        return true;
    }
    @Override
    public void onClick(View v) {
        int totalCB = 0;
        boolean isSmoke = smokee;
        CheckedList = new ArrayList<String>();
        switch (v.getId()) {
            case R.id.nexxt:
                for (int i = 0; i < loop; i++) {
                    CheckBox cb = (CheckBox) findViewById(i);
                    boolean checked = cb.isChecked();// status of checkbox

                    if (checked) {
                        String st = cb.getText().toString();
                        Log.d("Checked: ", st);

                        CheckedList.add((st.replaceAll(" ", "-").toLowerCase()));
                        check = true;
                    }
                }
                if (check == false) {
                    Toast.makeText(this, "Please Select an Option to proceed", Toast.LENGTH_SHORT).show();
                } else {
                    Log.d("Checked: ", CheckedList.get(0));

                    if (checkSmoke(CheckedList) > 1) {
                        smk = true;
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setMessage("Smoke is always one!")
                                .setCancelable(false)
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog alert = builder.create();
                        alert.show();
                        isSmoke = false;
                    }

                    if (CheckedList.size() > 0)
                        symptom = CheckedList.get(0);
                    else {
                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this).setTitle("!!!!!!")
                                .setMessage("Select one option")
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish();
                                    }
                                });
                        alertDialog.create();
                        alertDialog.show();
                    }
                    if (CheckedList.size() > 1) {
                        symptom = symptom + "-and";
                        for (int k = 1; k < CheckedList.size(); k++) {
                            symptom = symptom + "-" + (CheckedList.get(k)).toLowerCase();
                            if (k < CheckedList.size() - 1) {
                                symptom = symptom + "-and";
                            }
                        }
                    }


                    if (!smk && CheckedList.size() > 0) {
                        new getString().execute();
                    }
                    smk = false;

                    Log.d("Checked: ", CheckedList.get(0));
                    break;
                }
        }
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
            pDialog = new ProgressDialog(SoundSmellSmokeBehaviour.this);
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

    public void setSoundSymptoms() {
        String[] Symptoms = {"Squeaky belt noise"};
        db = new SymptomDbHelper(this);

        for (int i = 0; i < Symptoms.length; i++) {
            db.insertSoundSymptom(Symptoms[i]);
        }
    }


    public int checkSmoke(ArrayList<String> lst)
    {
        int count=0;
        String[] Symptoms = {"Blue-Smoke","White-Smoke","Black-Smoke"};
        for(int i=0; i<lst.size(); i++)
        {
            for(int j=0; j<3; j++)
            {
                if(lst.get(i).compareToIgnoreCase(Symptoms[j])==0)
                {
                    count++;
                }
            }
        }

        Log.d("count",count+"");
        return count;

    }
    public void setSmokeSymptoms() {
        String[] Symptoms = {"Blue Smoke","White Smoke","Black Smoke"};
        db = new SymptomDbHelper(this);

        for (int i = 0; i < Symptoms.length; i++) {
            db.insertSmokeSymptom(Symptoms[i]);
        }
    }
    public void setSmellSymptoms() {
        String[] Symptoms = {"Burning Rubber","Burning Oil","Gasoline Smell","Burning Carpet"};
        db = new SymptomDbHelper(this);

        for (int i = 0; i < Symptoms.length; i++) {
            db.insertSmellSymptom(Symptoms[i]);
        }
    }
    public void setBehaviourSymptoms() {
        String[] Symptoms = {"Engine missfire","Lack of acceleration","OverHeating engine"};
        db = new SymptomDbHelper(this);

        for (int i = 0; i < Symptoms.length; i++) {
            db.insertBehaviourSymptom(Symptoms[i]);
        }
    }
}
