package com.example.pinder_project_e4;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ItemViewHolder> {

    List<String> dataNameList;
    List<Integer> dataIdList;

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



    public void removeItem(int position) {
        dataNameList.remove(position);
        notifyItemRemoved(position);
    }

    public void swapItems(int firstPosition, int secondPosition) {
        Collections.swap(dataNameList, firstPosition, secondPosition);
        notifyItemMoved(firstPosition, secondPosition);
    }
}
