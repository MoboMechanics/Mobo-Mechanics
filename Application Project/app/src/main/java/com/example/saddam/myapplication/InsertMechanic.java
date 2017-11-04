package com.example.saddam.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class InsertMechanic extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText inputname, inputexpertise,inputphone,inputshop,inputaddress;
    private Button btnSave,btnGet;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private DatabaseReference mDatabase;
    private String userId;

    ArrayList<User>  list = new ArrayList<User>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_mechanic);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        //txtDetails = (TextView) findViewById(R.id.txt_user);
        inputname = (EditText) findViewById(R.id.name);
        inputexpertise = (EditText) findViewById(R.id.expert);
        inputphone = (EditText) findViewById(R.id.phone);
        inputshop = (EditText) findViewById(R.id.shop);
        inputaddress = (EditText) findViewById(R.id.address);
        btnSave = (Button) findViewById(R.id.btn_save);
        btnGet=(Button)findViewById(R.id.btn_get);

        mFirebaseInstance = FirebaseDatabase.getInstance();
        // get reference to 'users' node
        mFirebaseDatabase = mFirebaseInstance.getReference("users");
        // store app title to 'app_title' node
        mFirebaseInstance.getReference("app_title").setValue("Mobo Mechanics");

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFirebaseDatabase.addValueEventListener(
                        new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot)
                            {
                                User user1;
                                for (DataSnapshot messageSnapshot: dataSnapshot.getChildren()) {
                                    String temp1 = (String) messageSnapshot.child("Latitude").getValue().toString();
                                    String temp2 = (String) messageSnapshot.child("Longitude").getValue().toString();
                                    user1 = messageSnapshot.getValue(User.class);
                                    user1.latitude = Double.parseDouble(temp1);
                                    user1.logitude = Double.parseDouble(temp2);
                                    list.add(user1);
                                }
                                finish();
                            }
                            @Override
                            public void onCancelled(DatabaseError databaseError)
                            {
                                Log.w(TAG, "getUser:onCancelled", databaseError.toException());
                            }
                        });
            }
        });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = inputname.getText().toString();
                String phone = inputphone.getText().toString();
                String expert=inputexpertise.getText().toString();
                String shop=inputshop.getText().toString();
                String address=inputaddress.getText().toString();
                double logitude=10.0;
                double latitude=5.0;
                if (TextUtils.isEmpty(userId)) {
                    createUser(name,expert,phone,shop,address,logitude,latitude);
                }
            }
        });
    }





    private void createUser(String name,String expert,String phone,String shop,String address,double logitude,double latitude) {
        if (TextUtils.isEmpty(userId)) {
            userId = mFirebaseDatabase.push().getKey();
        }
        User user = new User(name,expert,phone,shop,address,logitude,latitude);
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("name", name);
        map2.put("Latitude", Double.toString(latitude));
        map2.put("Longitude",  Double.toString(logitude));
        map2.put("address", address);
        map2.put("shopname", shop);
        map2.put("phone", phone);
        map2.put("expertise",expert);
        mFirebaseDatabase.child(name).setValue(map2);
        inputaddress.setText("");
        inputexpertise.setText("");
        inputphone.setText("");
        inputshop.setText("");
        inputname.setText("");
    }

   /* @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_save:

                String name = inputname.getText().toString();
                String phone = inputphone.getText().toString();
                String expert=inputexpertise.getText().toString();
                String shop=inputshop.getText().toString();
                String address=inputaddress.getText().toString();
                double logitude=10.0;
                double latitude=5.0;
                if (TextUtils.isEmpty(userId)) {
                    createUser(name,expert,phone,shop,address,logitude,latitude);
                }
                break;
        }
    }*/
}