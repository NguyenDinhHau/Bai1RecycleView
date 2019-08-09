package com.example.recycleview.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recycleview.R;
import com.example.recycleview.SingleItemModel;
import com.example.recycleview.activity.TabLayoutViewPager;

import java.util.ArrayList;

public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.ViewHolder> {
    ArrayList<SingleItemModel> itemModels;
    Context context;

    public SectionListDataAdapter(ArrayList<SingleItemModel> itemModels, Context context) {
        this.itemModels = itemModels;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        viewGroup = (ViewGroup) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview,null);
        ViewHolder viewHolder = new ViewHolder(viewGroup);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        final SingleItemModel itemModel = itemModels.get(i);
        viewHolder.txt_sach.setText(itemModel.getName().toString());
        viewHolder.img_sach.setImageResource(R.drawable.hay);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TabLayoutViewPager.class);
                intent.putExtra("pos",i);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView card;
        TextView txt_sach;
        ImageView img_sach;
        public ViewHolder(View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.card);
            txt_sach = itemView.findViewById(R.id.txt_sach);
            img_sach = itemView.findViewById(R.id.img_sach);
        }
    }
}
