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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Gallery extends AppCompatActivity {

    ImageButton toHome;
    RecyclerView recyclerView;
    ArrayList<String> data;
    RVAdapter rvAdapter;

    void initData() {
        data = new ArrayList<>();
        data.add("Tokyo");
        data.add("Circle");
        data.add("Circle");
        data.add("Circle");
        data.add("Circle");
        data.add("Circle");
        data.add("Circle");
        data.add("Circle");
        data.add("Circle");
        data.add("Circle");
        data.add("Circle");
        data.add("Circle");

    }

    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_page);

        initData();
        rvAdapter = new RVAdapter(data);
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
