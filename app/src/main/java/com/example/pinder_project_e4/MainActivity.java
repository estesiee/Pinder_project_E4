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
// activité principal, affichage des images que l'ont peut liket ou disliker, un algorythme gère l'apparition des image et leurs likes (voir plus bas)
public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    ImageButton love;
    ImageButton remove;
    ImageButton toGallery;
    int idImage;
    ArrayList<Integer> allWallpaper = initTabWp();

    private AppBarConfiguration appBarConfiguration;

    @Override
    //création de l'activité, ici la page principale
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // utilisation du layout de la page principale, interface design pour l'utilisateur
        setContentView(R.layout.home_page);

        Intent intentGallery = new Intent(this,Gallery.class);

        imageView = (ImageView) findViewById(R.id.wallpaper);

        // appelle de la fonction donnant l'image suivante à afficher
        int random = newPic();
        // remplace l'ancienne image par la nouvelle
        imageView.setImageResource(random);

        //récupère les images pour les boutons
        love = (ImageButton) findViewById(R.id.love);
        remove = (ImageButton) findViewById(R.id.remove);
        toGallery = (ImageButton) findViewById(R.id.toGallery);

        // prise en charge des intéractions humaine
        //algo pour le bouton like
        love.setOnClickListener(new View.OnClickListener() {
          @Override

          public void onClick(View view) {
              // Aucun wallpaper ou tout les wallpaper sont déjà apparu
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
                  // test si l'image est déjà dans la liste des images like
                  if(l.contains(idImage)){
                      Toast.makeText(MainActivity.this, "Already Liked", Toast.LENGTH_SHORT).show();
                  }
                  //ajout de l'image aux favoris en cas de like'
                  else {
                      l.add(idImage);
                      AppData.getInstance().setList(l);
                      l2.add("Appuyer pour l'appliquer");
                      AppData.getInstance().setList2(l2);
                      Toast.makeText(MainActivity.this, "Image Liked", Toast.LENGTH_SHORT).show();
                  }
                  // charge le nouveau wallpaper
                  if(!allWallpaper.isEmpty()) {
                      int random = newPic();
                      imageView.setImageResource(random);
                  }
                  //si toutes les images sont apparues
                  else{
                      imageView.setImageResource(R.drawable.see_you);
                      return;
                  }
              }
          }
        });

        //algo pour le bouton dislike
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //si toutes les images  sont apparues
                if(allWallpaper.isEmpty()){
                    Toast.makeText(MainActivity.this, "No Image Available", Toast.LENGTH_SHORT).show();
                    return;
                }
                //chargement du nouveau wallpaper
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
        //si le bouton permettant d'aller à la liste de favori est appuyé
        toGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            //basculement vers une nouvelle activité
            public void onClick(View view) {
                startActivity(intentGallery);
            }
        });
    }

    //liste des wallpaper
    private ArrayList<Integer> initTabWp(){
        ArrayList<Integer> value = new ArrayList<Integer>();
        value.add(R.drawable.tokyowallpaper);
        value.add(R.drawable.crop);
        value.add(R.drawable.allee);
        value.add(R.drawable.automne);
        value.add(R.drawable.bmw);
        value.add(R.drawable.bougie);
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
        value.add(R.drawable.tigre);
        return value;
    }

    //fonction permettant de choisir aléatoirement dans la liste le prochain wallpaper
    private int newPic(){
        Random random = new Random();
        idImage = allWallpaper.get(random.nextInt(allWallpaper.size()));
        return idImage;
    }
}