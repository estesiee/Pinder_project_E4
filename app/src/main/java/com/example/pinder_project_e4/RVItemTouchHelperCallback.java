package com.example.pinder_project_e4;

import android.util.Log;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

//gère les intéractions humaine avancées avec la recycle view notamment le swipe
public class RVItemTouchHelperCallback extends ItemTouchHelper.SimpleCallback { // for handling swipe and moves
    private RVAdapter rvAdapter;
    //le tag sert au débuggage
    private final String TAG = "RVItemTouchHelperCallback";
    public RVItemTouchHelperCallback(RVAdapter rvAdapter) {
        super(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        this.rvAdapter = rvAdapter;
    }

    @Override
    //permet de déplacer un item dans la recycle view
    //détecte quel item est concerné par l'intéraction si il y en a un
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder draggedVH, RecyclerView.ViewHolder targetVH) {
        rvAdapter.swapItems(draggedVH.getAdapterPosition(), targetVH.getAdapterPosition());
        return false;
    }

    @Override
    //intéraction du swipe
    //ici seul le swipe gauche et droite sont utilisé et permettent tout deux de retirer l'item de la liste de favoris
    public void onSwiped(RecyclerView.ViewHolder swipedVH, int direction) {
        Integer pos = swipedVH.getAdapterPosition();
        switch (direction) {
            case ItemTouchHelper.LEFT:
                //Remove item
                rvAdapter.removeItem(pos);
                Log.d(TAG, "Swiped Left: " + pos.toString() );
                break;
            case ItemTouchHelper.RIGHT:
                rvAdapter.removeItem(pos);
                Log.d(TAG, "Swiped Right: " + pos.toString());
                break;
        }
    }
}