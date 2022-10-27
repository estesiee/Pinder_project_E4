package com.example.pinder_project_e4;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;


import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.navigation.ui.AppBarConfiguration;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button keep;
    Button kick;

    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        imageView = (ImageView) findViewById(R.id.wallpaper);
        //this.imageView.setImageResource(R.drawable.tokyowallpaper);
        keep = (Button) findViewById(R.id.keep);
        kick = (Button) findViewById(R.id.kick);
        keep.setOnClickListener(new View.OnClickListener() {
          @Override
                  public void onClick(View view) {
              System.out.println("Keep");
          }
        });
    }
}