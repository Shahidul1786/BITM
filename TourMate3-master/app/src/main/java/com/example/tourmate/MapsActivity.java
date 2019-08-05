package com.example.tourmate;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.location.Address;
import android.location.Geocoder;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tourmate.Adapters.NearbyAdapter;
import com.example.tourmate.Interface.NearbyLiatiner;
import com.example.tourmate.LocationAndMap.NearbySearch.NearbyPojo.NearbyResponse;
import com.example.tourmate.LocationAndMap.NearbySearch.NearbyPojo.Result;
import com.example.tourmate.LocationAndMap.NearbySearch.NearbyService;
import com.example.tourmate.LocationAndMap.NearbySearch.RetrofitClient;
import com.example.tourmate.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback, NearbyLiatiner {

    private GoogleMap mMap;
    private BottomSheetBehavior mBottomSheetBehavior;
    private List<String> searchList = new ArrayList<>();
    private Spinner spinner;
    private RecyclerView recyclerView;
    private NearbyAdapter nearbyAdapter;
    private String address;
    private  LatLng latLng;
    private ProgressDialog dialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        spinner = findViewById(R.id.bottomSpinner);
        recyclerView = findViewById(R.id.nearbyRecycler);
        dialog = new ProgressDialog(this);
        if(getIntent() !=null) {
            address = getIntent().getStringExtra("addressevent");
        }
         latLng = getLocationFromAddress(address);




        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        searchList.add("Categories");
        searchList.add("restaurant");
        searchList.add("mosque");
        searchList.add("atm");
        searchList.add("bank");
        searchList.add("night_club");
        searchList.add("bus_station");

        ArrayAdapter<String> spnnerAadpter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,searchList);
        spnnerAadpter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spinner.setAdapter(spnnerAadpter);
        mBottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.bottom_sheet));
        mBottomSheetBehavior.setHideable(false);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i !=0){
                    getNearbyPlaces(latLng,searchList.get(i));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setRotateGesturesEnabled(true);

        if(latLng !=null) {
            LatLng sydney = new LatLng(latLng.latitude, latLng.longitude);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 14f));
            mMap.addMarker(new MarkerOptions().position(sydney).title(address));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }else {
            Toast.makeText(this, "Geocoder problem", Toast.LENGTH_SHORT).show();
        }



    }
    private void getNearbyPlaces(LatLng latLng, String s){
        dialog.setMessage("Loading");
        dialog.show();
        final String apiKey = getString(R.string.nearby_place_api_key);
        String endUrl = String.format("place/nearbysearch/json?location=%f,%f&radius=1500&type=%s&key=%s",
                latLng.latitude, latLng.longitude,s, apiKey);
        NearbyService service = RetrofitClient.getClient()
                .create(NearbyService.class);
        service.getNearbyPlaces(endUrl)
                .enqueue(new Callback<NearbyResponse>() {
                    @Override
                    public void onResponse(Call<NearbyResponse> call, Response<NearbyResponse> response) {
                        if(response.isSuccessful()){

                            mMap.clear();
                            NearbyResponse nearby1d = response.body();
                            if(nearby1d !=null) {
                                nearbyAdapter = new NearbyAdapter(MapsActivity.this, response.body());
                            }else {
                                Toast.makeText(MapsActivity.this, "Not Found", Toast.LENGTH_SHORT).show();
                            }
                            recyclerView.setAdapter(nearbyAdapter);
                            recyclerView.setLayoutManager(new LinearLayoutManager(MapsActivity.this));
//                            nearbyFragment.getNearbyObject(response.body().getResults());
                            NearbyResponse nearbyResponse = response.body();
                            List<Result> resultList = nearbyResponse.getResults();
                            for(Result r : resultList){
                                double lat = r.getGeometry().getLocation().getLat();
                                double lng = r.getGeometry().getLocation().getLng();
                                LatLng rest = new LatLng(lat, lng);
                                mMap.addMarker(new MarkerOptions()
                                        .position(rest)
                                        .title(r.getName()));
                            }
                            dialog.dismiss();
                            Log.i("MAP ACTIVITY",response.body().toString());

                        }else {
                            dialog.dismiss();
                            Toast.makeText(MapsActivity.this, "Try Again ", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<NearbyResponse> call, Throwable t) {
                            dialog.dismiss();
                        Toast.makeText(MapsActivity.this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }


    @Override
    public void getLatlon(LatLng latLng) {
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        mMap.clear();
        recyclerView.scrollToPosition(0);
        mMap.addMarker(new MarkerOptions()
                .position(latLng));

    }

    public LatLng getLocationFromAddress(String strAddress){

        Geocoder coder = new Geocoder(this);
        List<Address> address;
        LatLng latLng ;

        try {
            address = coder.getFromLocationName(strAddress,5);
            if (address==null) {
                return null;
            }
            //  Toast.makeText(getActivity(), String.valueOf(address.size()), Toast.LENGTH_SHORT).show();
            if(address.size()>0) {
                Address location = address.get(0);
                double lat = location.getLatitude();
                double lon = location.getLongitude();
                latLng = new LatLng(lat, lon);
                return latLng;
            }else {
                return null;
            }


        } catch (IOException e) {
            Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
            return null;
        }

    }

}
