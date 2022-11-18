package com.example.pinder_project_e4;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.navigation.ui.AppBarConfiguration;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    ImageButton love;
    ImageButton remove;
    ImageButton toGallery;

    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        Intent intentGallery = new Intent(this,Gallery.class);

        imageView = (ImageView) findViewById(R.id.wallpaper);
        love = (ImageButton) findViewById(R.id.love);
        remove = (ImageButton) findViewById(R.id.remove);
        toGallery = (ImageButton) findViewById(R.id.toGallery);

        love.setOnClickListener(new View.OnClickListener() {
          @Override
                  public void onClick(View view) {
              //System.out.println("Keep");
          }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //System.out.println("Kick");
                imageView.setImageResource(R.drawable.crop);
            }
        });

        toGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentGallery);
            }
        });
    }
}