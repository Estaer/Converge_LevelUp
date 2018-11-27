package com.example.esthernamanda.converge_levelup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import adapter.DeveloperAdapter;
import model.GithubUsers;
import model.GithubUsersResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import service.GithubApi;

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
        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();
    }

    private void loadJSON() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GithubApi request = retrofit.create(GithubApi.class);
        Call<GithubUsersResponse> call = request.getJSON();
        call.enqueue(new Callback<GithubUsersResponse>() {
            @Override
            public void onResponse(Call<GithubUsersResponse> call, Response<GithubUsersResponse> response) {
                GithubUsersResponse githubUsersResponse = response.body();
                data = new ArrayList<>(Arrays.asList(githubUsersResponse.getItems()));
                adapter = new DeveloperAdapter(data,MainActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<GithubUsersResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Failed to Load. Please Retry!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}