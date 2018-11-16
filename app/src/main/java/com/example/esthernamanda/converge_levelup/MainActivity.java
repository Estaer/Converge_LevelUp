package com.example.esthernamanda.converge_levelup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import adapter.DeveloperAdapter;
import model.DeveloperModel;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private DeveloperAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<DeveloperModel> myDataset = new ArrayList<>();

        myDataset.add(new DeveloperModel("Esther",R.mipmap.ic_launcher,"http:github.com/Estaer"));
        myDataset.add(new DeveloperModel("Colline",R.mipmap.ic_launcher,"http:github.com/Colline"));
        myDataset.add(new DeveloperModel("Huxy",R.mipmap.ic_launcher,"http:github.com/Huxy"));
        myDataset.add(new DeveloperModel("Ronald",R.mipmap.ic_launcher,"http:github.com/Ronald"));
        myDataset.add(new DeveloperModel("Isaac",R.mipmap.ic_launcher,"http:github.com/Isaac"));

        mAdapter = new DeveloperAdapter(myDataset,MainActivity.this);
        mRecyclerView.setAdapter(mAdapter);
    }
}
