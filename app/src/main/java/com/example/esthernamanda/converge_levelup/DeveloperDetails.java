package com.example.esthernamanda.converge_levelup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import adapter.GithubUsersAdapter;

public class DeveloperDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_details);

        setData();

    }

    public void  setData (){
        Intent intent = getIntent();
        String username = intent.getStringExtra(GithubUsersAdapter.USERNAME);
        String avatar_url = intent.getStringExtra(GithubUsersAdapter.AVATAR_URL);
        String organisation_url = intent.getStringExtra(GithubUsersAdapter.ORGANISATION_URL);

        TextView username_txt = findViewById(R.id.username_details_txt);
        username_txt.setText(username);

        ImageView profile_img = findViewById(R.id.details_img);

        TextView organisation_txt  = findViewById(R.id.url_details_txt);
        organisation_txt.setText(organisation_url);

        Picasso.with(DeveloperDetails.this).
                load(avatar_url).
                into(profile_img);

    }
}
