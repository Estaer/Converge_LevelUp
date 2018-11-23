package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.esthernamanda.converge_levelup.DeveloperDetails;
import com.example.esthernamanda.converge_levelup.R;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import model.GithubUsers;

public class DeveloperAdapter extends RecyclerView.Adapter<DeveloperAdapter.MyViewHolder> {

    private ArrayList<GithubUsers> itemList;
    private Context context;

    public static final class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTxt;
        private View root;
        private CircularImageView developerImg;

        private MyViewHolder(View view) {
            super(view);
            this.root =view;

            nameTxt = view.findViewById(R.id.name_txt);
            developerImg = view.findViewById(R.id.developer_img);
        }
    }

    public DeveloperAdapter(ArrayList<GithubUsers> itemList, Context context) {

        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public DeveloperAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                     int viewType) {
        View view =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_developer_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final GithubUsers githubUsers = itemList.get(position);
        holder.nameTxt.setText(githubUsers.getLogin());

        Picasso.with(context).
                load(githubUsers.getAvatar_url()).
                into(holder.developerImg);

        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DeveloperAdapter.this.context, DeveloperDetails.class);
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
