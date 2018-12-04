package com.example.esthernamanda.converge_levelup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import adapter.GithubUsersAdapter;

public class DeveloperDetails extends AppCompatActivity {

    String username = "";
    String avatar_url = "";
    String organisation_url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_details);

        Intent intent = getIntent();
         username = intent.getStringExtra(GithubUsersAdapter.USERNAME);
         avatar_url = intent.getStringExtra(GithubUsersAdapter.AVATAR_URL);
         organisation_url = intent.getStringExtra(GithubUsersAdapter.ORGANISATION_URL);
        setData();

    }

    public void  setData (){


        TextView username_txt = findViewById(R.id.username_details_txt);
        username_txt.setText(username);

        ImageView profile_img = findViewById(R.id.details_img);

        TextView organisation_txt  = findViewById(R.id.url_details_txt);
        organisation_txt.setText(organisation_url);

        Picasso.with(DeveloperDetails.this).
                load(avatar_url).
                into(profile_img);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String message = String.format("Check out this awesome developer @%s, %s", username, organisation_url);
        int id = item.getItemId();
        if (id == R.id.mnShare){
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_TEXT, message);
            shareIntent.setType("text/plain");
            startActivity(shareIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}
