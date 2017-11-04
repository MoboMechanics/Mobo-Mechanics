package com.example.saddam.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class ProblemSolution extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_solution);

        EditText text = (EditText) findViewById(R.id.problemsolution);
        String passedArg = getIntent().getExtras().getString("get");
        text.setText(passedArg);
    }
}
