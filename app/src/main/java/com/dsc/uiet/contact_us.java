package com.dsc.uiet;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageButton;
import android.view.View;

public class contact_us extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        AppCompatImageButton button = findViewById(R.id.imageButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            String fbPageUrl = "https://www.facebook.com/uietkuk";

            try {
                getPackageManager().getPackageInfo("com.facebook.katana", 0);
                Intent fb = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/" ));
                startActivity(fb);
                                } catch (Exception e) {
                Intent fb = new Intent(Intent.ACTION_VIEW, Uri.parse(fbPageUrl));
                startActivity(fb);
            }

            }
                    });
        AppCompatImageButton button1 = findViewById(R.id.imageButton1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2)
            {

                Uri uri = Uri.parse("http://instagram.com/uietkurukshetra/");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/uietkurukshetra/")));
                }
            }

        });}}
