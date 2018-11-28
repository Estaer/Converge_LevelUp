package presenter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.esthernamanda.converge_levelup.R;

import java.util.ArrayList;
import java.util.Arrays;

import adapter.GithubUsersAdapter;
import model.GithubUsers;
import model.GithubUsersResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import service.GithubApi;

public class GithubPresenter {

    private RecyclerView recyclerView;
    private ArrayList<GithubUsers> data;
    private GithubUsersAdapter adapter;
    private Context context;
    private Activity activity;

    public GithubPresenter(Context context, Activity activity) {
        this.context = context;
        this.activity=activity;
    }

    public void loadJSON() {
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
                adapter = new GithubUsersAdapter(data,context);

                recyclerView = activity.findViewById(R.id.my_recycler_view);
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<GithubUsersResponse> call, Throwable t) {
                Toast.makeText(context,"Failed to Load. Please Retry!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
