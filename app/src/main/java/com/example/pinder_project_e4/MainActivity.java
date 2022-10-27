package com.example.pinder_project_e4;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;


import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.navigation.ui.AppBarConfiguration;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    ImageButton love;
    ImageButton remove;

    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        imageView = (ImageView) findViewById(R.id.wallpaper);
        love = (ImageButton) findViewById(R.id.love);
        remove = (ImageButton) findViewById(R.id.remove);
        love.setOnClickListener(new View.OnClickListener() {
          @Override
                  public void onClick(View view) {
              System.out.println("Keep");
          }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Kick");
            }
        });
    }
}