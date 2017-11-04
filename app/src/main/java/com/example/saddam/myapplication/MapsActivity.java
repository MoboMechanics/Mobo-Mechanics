package com.example.saddam.myapplication;

import android.graphics.Color;
import android.location.Address;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;



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

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    // GPSTracker class
    GPSTracker gps;



    ArrayList<MapPointInfo> MapPointInfoList = new ArrayList<>();

    // set current location here
    LatLng basePoint = new LatLng(31.48,74.32);      // base point, all other points will connect to this




///////////////////////////////
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
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



        mFirebaseInstance = FirebaseDatabase.getInstance();
        // get reference to 'users' node
        mFirebaseDatabase = mFirebaseInstance.getReference("users");
        // store app title to 'app_title' node
        mFirebaseInstance.getReference("app_title").setValue("Mobo Mechanics");

        /*mFirebaseDatabase.addValueEventListener(
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
                });*/






       /* MapPointInfoList.add(new MapPointInfo(basePoint,"Your Location"));
        // add all other points
        MapPointInfoList.add(new MapPointInfo(new LatLng(31.50,74.35),"Electrician"));
        MapPointInfoList.add(new MapPointInfo(new LatLng(31.47,74.37),"Mechanic"));
        MapPointInfoList.add(new MapPointInfo((new LatLng(31.51,74.40)),"EFI Mechanic"));
        */
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //  Getting Location
        //gps = new GPSTracker(MapsActivity.this);


        // Check if GPS enabled
        //if(gps.canGetLocation()) {

            //double latitude = gps.getLatitude();
            //double longitude = gps.getLongitude();

            MapPointInfoList.add(new MapPointInfo(new LatLng(basePoint.latitude,basePoint.longitude),"Your Location"));
            // \n is for new line
            //Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
        //} else {
            // Can't get location.
            // GPS or network is not enabled.
            // Ask user to enable GPS/network in settings.
         //   gps.showSettingsAlert();
        //}

        // add all other points
        MapPointInfoList.add(new MapPointInfo(new LatLng(31.50,74.35),"Electrician\nContact:03335575499"));
        MapPointInfoList.add(new MapPointInfo(new LatLng(31.47,74.37),"Mechanic\nContact:03331234567"));
        MapPointInfoList.add(new MapPointInfo((new LatLng(31.51,74.40)),"EFI Mechanic\nContact:03335575499"));
        addMarkersToMap();

        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(MapPointInfoList.get(0).getCoordinates(), 12);
        mMap.animateCamera(cameraUpdate);
    }


    // also address can be changed to LatLan
    // convert address to lng lat and add markers to map
    public void addMarkersToMap() {
        mMap.clear();


  //  setting up USER's Current Location MARKER
        mMap.addMarker(new MarkerOptions()
                .position(MapPointInfoList.get(0).getCoordinates())
                .title(MapPointInfoList.get(0).getPointInfo())
                //   .snippet(addressArrayList.get(i))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                .alpha(0.7f)
        );

     //   String[] addrs = new String[addressArrayList.size()];
     //   addrs = addressArrayList.toArray(addrs);
        List<Address> addressList;

            for (int i = 1; i < MapPointInfoList.size(); i++) {
                try {
              //      addressList = geoCoder.getFromLocationName(addrs[i], 1);
                  //  if (addressList == null || addressList.isEmpty() || addressList.equals("")) {
                  //      addressList = geoCoder.getFromLocationName("san francisco", 1);
                //    }
                  //  latitude[i] = addressList.get(0).getLatitude();
                //    longitude[i] = addressList.get(0).getLongitude();
                   // System.out.println("latitude = " + latLngs. + " longitude = " + longitude[i]);
                    mMap.addMarker(new MarkerOptions()
                            .position(MapPointInfoList.get(i).getCoordinates())
                            .title(MapPointInfoList.get(i).getPointInfo())
                         //   .snippet(addressArrayList.get(i))
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.mechanicpic))
                            .alpha(0.7f)
                    );
                } catch (Exception e) {
                    e.printStackTrace();
                } // end catch
            }
            for(int i=1;i<MapPointInfoList.size();i++)
            {
                PathBuilder(MapPointInfoList.get(0).getCoordinates(),MapPointInfoList.get(i).getCoordinates());
            }


        }

        public void PathBuilder(LatLng src, LatLng dist)
        {
            String url = getMapsApiDirectionsUrl(src, dist);
            ReadTask downloadTask = new ReadTask();
            // Start downloading json data from Google Directions API
            downloadTask.execute(url);

        }

    private String  getMapsApiDirectionsUrl(LatLng origin,LatLng dest) {
        // Origin of route
        String str_origin = "origin="+origin.latitude+","+origin.longitude;

        // Destination of route
        String str_dest = "destination="+dest.latitude+","+dest.longitude;


        // Sensor enabled
        String sensor = "sensor=false";

        // Building the parameters to the web service
        String parameters = str_origin+"&"+str_dest+"&"+sensor;

        // Output format
        String output = "json";

        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/"+output+"?"+parameters;


        return url;

    }

    private class ReadTask extends AsyncTask<String, Void , String> {

        @Override
        protected String doInBackground(String... url) {
            // TODO Auto-generated method stub
            String data = "";
            try {
                MapHttpConnection http = new MapHttpConnection();
                data = http.readUr(url[0]);


            } catch (Exception e) {
                // TODO: handle exception
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            new ParserTask().execute(result);
        }

    }
    public class MapHttpConnection {
        public String readUr(String mapsApiDirectionsUrl) throws IOException {
            String data = "";
            InputStream istream = null;
            HttpURLConnection urlConnection = null;
            try {
                URL url = new URL(mapsApiDirectionsUrl);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.connect();
                istream = urlConnection.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(istream));
                StringBuffer sb = new StringBuffer();
                String line ="";
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                data = sb.toString();
                br.close();


            }
            catch (Exception e) {
                Log.d("Exception while url", e.toString());
            } finally {
                istream.close();
                urlConnection.disconnect();
            }
            return data;

        }
    }

    private class ParserTask extends AsyncTask<String,Integer, List<List<HashMap<String , String >>>> {
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(
                String... jsonData) {
            // TODO Auto-generated method stub
            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;
            try {
                jObject = new JSONObject(jsonData[0]);
                PathJSONParser parser = new PathJSONParser();
                routes = parser.parse(jObject);


            } catch (Exception e) {
                e.printStackTrace();
            }
            return routes;
        }

        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> routes) {
            ArrayList<LatLng> points;
            points = null;
            PolylineOptions polyLineOptions = null;

            // traversing through routes
            for (int i = 0; i < routes.size(); i++) {
                points = new ArrayList<LatLng>();
                polyLineOptions = new PolylineOptions();
                List<HashMap<String, String>> path = routes.get(i);

                for (int j = 0; j < path.size(); j++) {
                    HashMap<String, String> point = path.get(j);

                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);

                    points.add(position);
                }

                polyLineOptions.addAll(points);
                polyLineOptions.width(8);
                polyLineOptions.color(Color.BLUE);

            }

            mMap.addPolyline(polyLineOptions);

        }}

    public class MapPointInfo
    {
        private LatLng ll;
        private String pointInfo;



        public MapPointInfo(LatLng ll, String titleInfo) {
            this.ll = ll;
            pointInfo=titleInfo;
        }

        public LatLng getCoordinates() {
            return ll;
        }

        public String getPointInfo() {
            return pointInfo;
        }

        public void setCoordinates(LatLng ll) {
            this.ll = ll;
        }

        public void setPointInfo(String pointInfo) {
            this.pointInfo = pointInfo;
        }
    }
}