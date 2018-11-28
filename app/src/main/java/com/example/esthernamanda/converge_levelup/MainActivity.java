package com.example.esthernamanda.converge_levelup;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.os.PersistableBundle;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;
import adapter.GithubUsersAdapter;
import model.GithubUsers;
import presenter.GithubPresenter;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<GithubUsers> data;
    private GithubUsersAdapter adapter;
    public final static String LIST_STATE_KEY = "recycler_list_state";
    RecyclerView.LayoutManager layoutManager;
    Parcelable listState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.my_recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        initViews();
    }

    private void initViews() {


        GithubPresenter githubPresenter = new GithubPresenter(MainActivity.this,this);
        githubPresenter.loadJSON();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        listState = layoutManager.onSaveInstanceState();
        outState.putParcelable(LIST_STATE_KEY,listState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState!=null)
            listState = savedInstanceState.getParcelable(LIST_STATE_KEY);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(listState != null){
            layoutManager.onRestoreInstanceState(listState);
        }
    }
}
