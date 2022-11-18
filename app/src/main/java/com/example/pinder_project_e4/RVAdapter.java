package com.example.pinder_project_e4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ItemViewHolder> {

    List<String> dataList;

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView txt;

        public ItemViewHolder(View itemView) {
            super(itemView);
            txt = (TextView) itemView.findViewById(R.id.txt);
        }
    }

    public RVAdapter(List<String> dataList) {
        this.dataList = dataList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_list_item, parent,
                false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.txt.setText(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }



    public void removeItem(int position) {
        dataList.remove(position);
        notifyItemRemoved(position);
    }

    public void swapItems(int firstPosition, int secondPosition) {
        Collections.swap(dataList, firstPosition, secondPosition);
        notifyItemMoved(firstPosition, secondPosition);
    }
}
