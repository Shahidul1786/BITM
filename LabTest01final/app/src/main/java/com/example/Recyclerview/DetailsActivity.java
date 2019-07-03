package com.example.Recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView name,director;

    private String aName,aDirector;
    private int img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        init();

        aName = name.getText().toString();
        aDirector = director.getText().toString();
        img = imageView.getImageAlpha();


        aName = getIntent().getStringExtra("Movie");
        aDirector = getIntent().getStringExtra("Director");
        img = getIntent().getIntExtra("Image",R.drawable.pc1);

        imageView.setImageResource( img);

        name.setText(aName);
        director.setText(aDirector);



    }

    private void init() {

        imageView = findViewById(R.id.detailsimageviewID);
        name = findViewById(R.id.namedetailsTVID);
        director = findViewById(R.id.directordetailsTVID);
    }
}
