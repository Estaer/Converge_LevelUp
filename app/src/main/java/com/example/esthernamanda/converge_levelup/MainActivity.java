package com.example.esthernamanda.converge_levelup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import adapter.DeveloperAdapter;
import model.GithubUsers;
import presenter.GithubPresenter;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<GithubUsers> data;
    private DeveloperAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {


        GithubPresenter githubPresenter = new GithubPresenter(MainActivity.this,this);
        githubPresenter.loadJSON();
    }


}