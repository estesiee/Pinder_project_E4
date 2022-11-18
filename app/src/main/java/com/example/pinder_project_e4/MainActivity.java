package com.example.pinder_project_e4;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import java.util.ArrayList;
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
    ArrayList<ArrayList<Integer>> allWallpaper = initTabWp();

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
                imageView.setImageResource(newPic());
            }
        });

        toGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentGallery);
            }
        });
    }

    private ArrayList<ArrayList<Integer>> initTabWp(){
        ArrayList<ArrayList<Integer>> value = new ArrayList<ArrayList<Integer>>();
        value.add(fill(R.drawable.crop, 0));
        value.add(fill(R.drawable.tokyowallpaper, 0));

        return value;
    }

    private ArrayList<Integer> fill(int value,int state){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(value);
        list.add(state);
        return list;
    }

    private int newPic(){
        Random random = new Random();
        return allWallpaper.get(random.nextInt(allWallpaper.size())).get(0);
    }
}