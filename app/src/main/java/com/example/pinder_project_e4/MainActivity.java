package com.example.pinder_project_e4;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import java.util.ArrayList;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.navigation.ui.AppBarConfiguration;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    ImageButton love;
    ImageButton remove;
    ImageButton toGallery;
    int idImage;
    ArrayList<Integer> allWallpaper = initTabWp();

    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        Intent intentGallery = new Intent(this,Gallery.class);

        imageView = (ImageView) findViewById(R.id.wallpaper);

        int random = newPic();
        imageView.setImageResource(random);

        love = (ImageButton) findViewById(R.id.love);
        remove = (ImageButton) findViewById(R.id.remove);
        toGallery = (ImageButton) findViewById(R.id.toGallery);

        love.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              if(allWallpaper.isEmpty()){
                  Toast.makeText(MainActivity.this, "No Image Available", Toast.LENGTH_SHORT).show();
                  return;
              }
              else {
                  boolean test = allWallpaper.remove((Object)idImage);
                  ArrayList l = new ArrayList();
                  ArrayList l2 = new ArrayList();
                  l = AppData.getInstance().getList();
                  l2 = AppData.getInstance().getList2();

                  if(l.contains(idImage)){
                      Toast.makeText(MainActivity.this, "Already Liked", Toast.LENGTH_SHORT).show();
                  }
                  else {
                      l.add(idImage);
                      AppData.getInstance().setList(l);
                      l2.add("Appuyer pour l'appliquer");
                      AppData.getInstance().setList2(l2);
                      Toast.makeText(MainActivity.this, "Image Liked", Toast.LENGTH_SHORT).show();
                  }
                  if(!allWallpaper.isEmpty()) {
                      int random = newPic();
                      imageView.setImageResource(random);
                  }
                  else{
                      imageView.setImageResource(R.drawable.see_you);
                      return;
                  }
              }
          }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(allWallpaper.isEmpty()){
                    Toast.makeText(MainActivity.this, "No Image Available", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    boolean test = allWallpaper.remove((Object)idImage);
                    if(!allWallpaper.isEmpty()) {
                        int random = newPic();
                        imageView.setImageResource(random);
                    }
                    else{
                        imageView.setImageResource(R.drawable.see_you);
                        return;
                    }
                }
            }
        });

        toGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentGallery);
            }
        });
    }

    private ArrayList<Integer> initTabWp(){
        ArrayList<Integer> value = new ArrayList<Integer>();
        value.add(R.drawable.tokyowallpaper);
        value.add(R.drawable.crop);
        value.add(R.drawable.allee);
        value.add(R.drawable.automne);
        value.add(R.drawable.bmw);
        /*value.add(R.drawable.bougie);
        value.add(R.drawable.cascade);
        value.add(R.drawable.cerf);
        value.add(R.drawable.cerise);
        value.add(R.drawable.chatbleu);
        value.add(R.drawable.chatchad);
        value.add(R.drawable.chatoux);
        value.add(R.drawable.coucher);
        value.add(R.drawable.creed);
        value.add(R.drawable.lac);
        value.add(R.drawable.loup);
        value.add(R.drawable.mug);
        value.add(R.drawable.mustang);
        value.add(R.drawable.naruto);
        value.add(R.drawable.ours);
        value.add(R.drawable.papillon);
        value.add(R.drawable.plage);
        value.add(R.drawable.plage_bleu);
        value.add(R.drawable.space);
        value.add(R.drawable.spaceboom);
        value.add(R.drawable.tokyowallpaper);
        value.add(R.drawable.terre);
        value.add(R.drawable.tigre);*/
        return value;
    }

    private int newPic(){
        Random random = new Random();
        idImage = allWallpaper.get(random.nextInt(allWallpaper.size()));
        return idImage;
    }
}