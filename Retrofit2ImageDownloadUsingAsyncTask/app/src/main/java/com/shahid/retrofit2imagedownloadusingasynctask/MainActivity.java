package com.shahid.retrofit2imagedownloadusingasynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static final String IMAGE_URL = "https://www.audubon.org/sites/default/files/styles/hero_image/public/web_groombaltimoreoriole-and-a-male-red-breasted-grosbeak.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new DownloadTask().execute(IMAGE_URL);
       // ImageView imageView =  findViewById(R.id.imageViewID);

        //Picasso.get().load(Uri.parse(IMAGE_URL)).into(imageView);
    }

    private class DownloadTask extends AsyncTask<String,Void, Bitmap>{

        @Override
        protected Bitmap doInBackground(String... strings) {

            try {
                URL imageUrl = new URL(strings[0]);
                HttpURLConnection connection = (HttpURLConnection) imageUrl.openConnection();
                connection.connect();

                InputStream inputStream = connection.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                return bitmap;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);

            ((ImageView)findViewById(R.id.imageViewID)).setImageBitmap(bitmap);

        }
    }
}
