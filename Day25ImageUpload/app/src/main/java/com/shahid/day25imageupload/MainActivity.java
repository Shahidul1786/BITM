package com.shahid.day25imageupload;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button selectItem,upload;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        selectItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openGallery(view);
            }
        });

    }

    private void openGallery(View view) {

        Intent intent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent,0);
    }

    private void init() {

        selectItem =findViewById(R.id.selectBTNID);
        upload =findViewById(R.id.uploadBTNID);
        imageView =findViewById(R.id.imageViewID);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Activity.RESULT_OK){

            if (requestCode == 0){
                Bundle bundle = data.getExtras();
                Bitmap bitmap = (Bitmap) bundle.get("data");

                imageView.setImageBitmap(bitmap);
            }
            else if (requestCode == 1 ){

                Uri uri = data.getData();

                imageView.setImageURI(uri);

            }

        }
    }
}
