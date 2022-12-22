package com.example.pinder_project_e4;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
//gère les intéractions humaine de base avec la recycle view notamment le click
public class RVItemTouchListener implements RecyclerView.OnItemTouchListener { // intercept touch events. call onItemTouch method when a touch happens
    private ItemTouchListener mListener;

    public interface ItemTouchListener {
        public void onItemTouch(View view, int position);
    }

    //class android permettant de gérer les intéractions tactile en utilisant motionEvents
    GestureDetector mGestureDetector;

    public RVItemTouchListener(Context context, ItemTouchListener listener) {
        //listener ou litérallement écouteur récupère la détection d'évènement
        mListener = listener;
        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) { // this SimpleOnGestureListener returns true
                return true;
            }
             @Override
            public boolean onSingleTapConfirmed(MotionEvent e) { // this SimpleOnGestureListener returns true
                return true;
            }
             @Override
            public boolean onDoubleTap(MotionEvent e) { // this SimpleOnGestureListener returns true
                 return true;
            }
        });
    }

    @Override
    //permet de récupérer si l'appui a bien été effectuer sur un élément de la recycle view
    // et d'effectuer l'intéraction sur le bon élément de la liste grâce à sa position
    public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
        View childView = view.findChildViewUnder(e.getX(), e.getY());
        if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
            mListener.onItemTouch(childView, view.getChildAdapterPosition(childView));
            return true;
        }
        return false;
    }

    //fonctions non utilisées pour notre application
    @Override
    public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) {
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }
}
