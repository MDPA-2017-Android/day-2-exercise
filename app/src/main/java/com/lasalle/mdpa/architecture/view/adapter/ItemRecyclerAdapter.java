package com.lasalle.mdpa.architecture.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lasalle.mdpa.architecture.R;
import com.lasalle.mdpa.architecture.model.Item;

import java.util.List;

public class ItemRecyclerAdapter extends RecyclerView.Adapter<ItemRecyclerAdapter.ViewHolder> {

    private List<Item> itemList;
    private final Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView firstText;
        public TextView secondText;

        public ViewHolder(View itemView) {
            super(itemView);

            firstText = (TextView) itemView.findViewById(R.id.first_text);
            secondText = (TextView) itemView.findViewById(R.id.second_text);
        }
    }

    public ItemRecyclerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemView = inflater.inflate(R.layout.item, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = itemList.get(position);

        holder.firstText.setText(item.getFirstText());
        holder.secondText.setText(item.getSecondText());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
