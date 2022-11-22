package com.example.pinder_project_e4;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.io.IOException;

import java.util.ArrayList;

public class Gallery extends AppCompatActivity {

    ImageButton toHome;
    RecyclerView recyclerView;
    ArrayList<String> dataName;
    ArrayList<Integer> dataId;
    RVAdapter rvAdapter;
    final String TAG = "Gallery";

    void initdata() {
        dataName = new ArrayList<String>();
        dataName.add("Allee");
        dataName.add("Automne");
        dataName.add("BMW");
        dataName.add("Bougie");
        dataName.add("Planète");

        dataId = new ArrayList<Integer>();
        dataId.add(R.drawable.allee);
        dataId.add(R.drawable.automne);
        dataId.add(R.drawable.bmw);
        dataId.add(R.drawable.bougie);
        dataId.add(R.drawable.terre);
    }

    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_page);

        initdata();
        rvAdapter = new RVAdapter(dataName,dataId);
        recyclerView = (RecyclerView) findViewById(R.id.rv_fruits);
        recyclerView.setAdapter(rvAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.hasFixedSize();
        recyclerView.addItemDecoration(
                new /*OptionalRV*/DividerItemDecoration(
                        this,
                        LinearLayoutManager.VERTICAL
                )
        );
        final WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
        recyclerView.addOnItemTouchListener(
                new RVItemTouchListener(
                        this,
                        new RVItemTouchListener.ItemTouchListener() {

                            @Override
                            public void onItemTouch(View view, int position) { //define custom code when touching an item
                                String value = "wallpaper applied";
                                Log.d(TAG, value);
                                Toast.makeText(Gallery.this, value, Toast.LENGTH_SHORT).show();
                                try {
                                    // set the wallpaper by calling the setResource function and
                                    // passing the drawable file
                                    wallpaperManager.setResource(dataId.get(position));
                                } catch (IOException e) {
                                    // here the errors can be logged instead of printStackTrace
                                    e.printStackTrace();
                                }
                            }
                        }
                )
        );
        ItemTouchHelper.Callback touchHelperCallback = new RVItemTouchHelperCallback(rvAdapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(touchHelperCallback);
        touchHelper.attachToRecyclerView(recyclerView);


        Intent intentHome = new Intent(this,MainActivity.class);

        toHome = (ImageButton) findViewById(R.id.toHome);

        toHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentHome);
            }
        });
    }
}
