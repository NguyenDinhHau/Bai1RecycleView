package com.example.recycleview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.recycleview.R;
import com.example.recycleview.SectionDataModel;
import com.example.recycleview.SingleItemModel;

import java.util.ArrayList;

public class AdapterRecycleViewMain extends RecyclerView.Adapter<AdapterRecycleViewMain.ViewHolder> {
    ArrayList<SectionDataModel> dataModels;
    Context context;
    ArrayList<SingleItemModel> itemModels = new ArrayList<>();
    SectionListDataAdapter adapter;

    public AdapterRecycleViewMain(ArrayList<SectionDataModel> dataModels, Context context) {
        this.dataModels = dataModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        viewGroup = (ViewGroup) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recyclerview,null);
        ViewHolder viewHolder = new ViewHolder(viewGroup);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
         SectionDataModel sectionDataModel = dataModels.get(i);
        viewHolder.txt_name.setText(sectionDataModel.getHeadTitle().toString());
        itemModels = sectionDataModel.getAllItemInSection();
        adapter = new SectionListDataAdapter(itemModels,context);
        viewHolder.recyclerView.setHasFixedSize(true);
        viewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        viewHolder.recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        viewHolder.btn_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt_name;
        Button btn_name;
        RecyclerView recyclerView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_name = itemView.findViewById(R.id.txt_name);
            btn_name = itemView.findViewById(R.id.btn_name);
            recyclerView = itemView.findViewById(R.id.recyclerview);
        }
    }
}
