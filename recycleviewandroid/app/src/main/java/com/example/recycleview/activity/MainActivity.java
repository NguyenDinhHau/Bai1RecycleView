package com.example.recycleview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.recycleview.R;
import com.example.recycleview.SectionDataModel;
import com.example.recycleview.SingleItemModel;
import com.example.recycleview.adapter.AdapterRecycleViewMain;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    AdapterRecycleViewMain adapterRecycleViewMain;
    ArrayList<SectionDataModel> dataModels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_main);
        dataModels = new ArrayList<>();
        createData();
        adapterRecycleViewMain = new AdapterRecycleViewMain(dataModels,this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapterRecycleViewMain);
    }

    private void createData() {
        for (int i = 0; i<=5; i++){
            SectionDataModel sectionDataModel = new SectionDataModel();
            sectionDataModel.setHeadTitle("Header "+ i);
            ArrayList<SingleItemModel> itemModels = new ArrayList<>();
            for (int j = 0; j<= 10; j++) {
                SingleItemModel itemModel = new SingleItemModel("Sách " + j, "URL", j + "");
                itemModels.add(itemModel);
            }
            sectionDataModel.setAllItemInSection(itemModels);
            dataModels.add(sectionDataModel);
        }
    }


}
