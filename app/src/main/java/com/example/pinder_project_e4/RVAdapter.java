package com.example.pinder_project_e4;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

//s'occupe de la mise en forme de la recycle view
//agit item par item, donc ligne par ligne
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ItemViewHolder> {

    List<String> dataNameList;
    List<Integer> dataIdList;

    //permet de donner les données et la place d'un item danas la recycle view
    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView txt;
        ImageView img;

        public ItemViewHolder(View itemView) {
            super(itemView);
            txt = (TextView) itemView.findViewById(R.id.txt);
            img = (ImageView) itemView.findViewById(R.id.wallpaper);
        }
    }
    public RVAdapter(List<String> dataNameList, List<Integer> dataIdList ) {
        this.dataNameList = dataNameList;
        this.dataIdList = dataIdList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //layout inflater permet d'instancier un layout dans une vue correspondante
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_list_item, parent,
                false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.txt.setText(dataNameList.get(position));
        holder.img.setImageResource(dataIdList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataNameList.size();
    }



    //permet de retirer une image like de la liste de favoris
    public void removeItem(int position) {
        dataNameList.remove(position);
        dataIdList.remove(position);
        notifyItemRemoved(position);
    }

    //permet de modifier la position d'un item dans la recycle view
    //plus exactement d'échanger la position entre l'élément suivant et le précedent
    public void swapItems(int firstPosition, int secondPosition) {
        Collections.swap(dataNameList, firstPosition, secondPosition);
        notifyItemMoved(firstPosition, secondPosition);
    }
}
