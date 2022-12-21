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

//deuxième activité gérant l'affichage de la liste de favoris
//AppCompatActivity permet d'uiliser des fonctions de barre d'outils,dark & light mode, ... et ceux même sur de plus anciens Androïd
public class Gallery extends AppCompatActivity {

    ImageButton toHome;
    RecyclerView recyclerView;
    ArrayList<String> dataName;
    ArrayList<Integer> dataId;
    RVAdapter rvAdapter;
    final String TAG = "Gallery";

    //utile pour une évolution future de l'appli
    private AppBarConfiguration appBarConfiguration;

    @Override
    //création de l'activité
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_page);

        //création de la recycle view et notamment de RvAdapter qui s'occupe de la mise en forme de la recycle view
        rvAdapter = new RVAdapter(AppData.getInstance().getList2(),AppData.getInstance().getList());
        //rv_fruit est ici chaque ligne de la recycle view donc pour nous l'image et son texte associé
        recyclerView = (RecyclerView) findViewById(R.id.rv_fruits);
        recyclerView.setAdapter(rvAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.hasFixedSize();
        //ajout d'une mise en forme esthétique par le biai d'une autre classe car optionnel
        recyclerView.addItemDecoration(
                new /*OptionalRV*/DividerItemDecoration(
                        this,
                        LinearLayoutManager.VERTICAL
                )
        );
        //wallpaper manager est une class androïd permettant l'accès et la modification du wallpaper du système
        final WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
        //ajout des intéractions humaines
        recyclerView.addOnItemTouchListener(
                //appel à la class spécialisée dans l'intéraction avec la recycle view
                new RVItemTouchListener(
                        this,
                        new RVItemTouchListener.ItemTouchListener() {

                            @Override
                            public void onItemTouch(View view, int position) {
                                String value = "wallpaper applied";
                                Log.d(TAG, value);
                                //le toast est un petit texte qui apparaît en bas de l'écran afin d'afficher une information rapide
                                //ici le toast prévient l'utilisateur que le nouveau wallpaper est bien affecté
                                Toast.makeText(Gallery.this, value, Toast.LENGTH_SHORT).show();
                                try {
                                    //définie le fond d'écran en appelant la fonction setResource et en passant le fichier drawable
                                    wallpaperManager.setResource((int)AppData.getInstance().getList().get(position));
                                } catch (IOException e) {
                                    // ici, les erreurs peuvent être enregistrées au lieu de printStackTrace (évite de s'afficher aux yeux de l'utilisateur)
                                    e.printStackTrace();
                                }
                            }
                        }
                )
        );
        //permet de gérer des intéractions plus complexe que le touch lister (notamment le swipe)
        ItemTouchHelper.Callback touchHelperCallback = new RVItemTouchHelperCallback(rvAdapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(touchHelperCallback);
        touchHelper.attachToRecyclerView(recyclerView);

        //intent est une class permettant de donner une description abstraite d'une action à réaliser ce qui est nécessaire par exemple pour
        //le de démarrage d'une nouvelle activité, elle permet une navigation fluide pour l'utilisateur.
        Intent intentHome = new Intent(this,MainActivity.class);

        // permet de retourner à l'activité principale
        toHome = (ImageButton) findViewById(R.id.toHome);

        //démarre l'activité principale
        toHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentHome);
            }
        });
    }
}
