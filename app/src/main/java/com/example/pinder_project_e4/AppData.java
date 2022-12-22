package com.example.pinder_project_e4;

import java.util.ArrayList;

//class initialiser une fois qui permet la communication entre les différentes activités et class.
//elle se réinitialise quand l'application est fermé
public class AppData {
    // deux listes sont créées, une avec les ID et l'autre avec les noms des wallpapers
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private ArrayList<String> list2 = new ArrayList<String>();
    private static AppData instance;

    //fonctions permettant de modifier et d'accéder aux listes
    private AppData(){};
    public ArrayList getList() {
        return this.list;
    }
    public void setList(ArrayList list) {
        this.list = list;
    }
    public ArrayList getList2() {
        return this.list2;
    }
    public void setList2(ArrayList list2) {
        this.list2 = list2;
    }

    //vérifie à l'appel si il existe déjà, si ce n'est pas le cas une instance est créée sinon l'instance existante est retournéé
    //il ne peut y avoir qu'une instance, c'est une sorte de singleton
    public static AppData getInstance() {
        if (instance == null) {
            instance = new AppData();
        }
        return instance;
    }
}