package com.example.pinder_project_e4;

import android.util.Log;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class RVItemTouchHelperCallback extends ItemTouchHelper.SimpleCallback { // for handling swipe and moves
    private RVAdapter rvAdapter;
    private final String TAG = "RVItemTouchHelperCallback";
    public RVItemTouchHelperCallback(RVAdapter rvAdapter) {
        super(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        this.rvAdapter = rvAdapter;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder draggedVH, RecyclerView.ViewHolder targetVH) {
        //ItemTouchHelper saw two moved/dragged' ViewHolders, invoke rvAdapter related action on data
        rvAdapter.swapItems(draggedVH.getAdapterPosition(), targetVH.getAdapterPosition());
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder swipedVH, int direction) {
        //ItemTouchHelper saw a 'swiped' ViewHolder, invoke rvAdapter related action on data
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