package com.nts.bitm.labtest1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private ImageView image;
    private TextView name, director;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        image = findViewById(R.id.detailsImage);
        name = findViewById(R.id.detailsNameTV);
        director = findViewById(R.id.detailsDirectorTV);


        String movieName = name.getText().toString();
        String directorName = director.getText().toString();
        int img = image.getImageAlpha();

        movieName = getIntent().getStringExtra("Movie");
        directorName = getIntent().getStringExtra("Director");
        img = getIntent().getIntExtra("Image", R.drawable.download);
        name.setText(movieName);
        director.setText(directorName);
        image.setImageResource(img);


    }
}
