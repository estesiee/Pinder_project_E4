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
    ArrayList<ArrayList<Integer>> likedWallpaper = new ArrayList<ArrayList<Integer>>();

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
                int random = newPic();
                imageView.setImageResource(allWallpaper.get(random).get(0));
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
        value.add(fill(R.drawable.allee, 0));
        value.add(fill(R.drawable.automne, 0));
        value.add(fill(R.drawable.bmw, 0));
        value.add(fill(R.drawable.bougie, 0));
        value.add(fill(R.drawable.cascade, 0));
        value.add(fill(R.drawable.cerf, 0));
        value.add(fill(R.drawable.cerise, 0));
        value.add(fill(R.drawable.chatbleu, 0));
        value.add(fill(R.drawable.chatchad, 0));
        value.add(fill(R.drawable.chatoux, 0));
        value.add(fill(R.drawable.coucher, 0));
        value.add(fill(R.drawable.creed, 0));
        value.add(fill(R.drawable.lac, 0));
        value.add(fill(R.drawable.loup, 0));
        value.add(fill(R.drawable.mug, 0));
        value.add(fill(R.drawable.mustang, 0));
        value.add(fill(R.drawable.naruto, 0));
        value.add(fill(R.drawable.ours, 0));
        value.add(fill(R.drawable.papillon, 0));
        value.add(fill(R.drawable.plage, 0));
        value.add(fill(R.drawable.plage_bleu, 0));
        value.add(fill(R.drawable.space, 0));
        value.add(fill(R.drawable.spaceboom, 0));
        value.add(fill(R.drawable.tokyowallpaper, 0));
        value.add(fill(R.drawable.terre, 0));
        value.add(fill(R.drawable.tigre, 0));
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
        return random.nextInt(allWallpaper.size());
    }
}