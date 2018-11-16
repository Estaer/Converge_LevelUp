package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.esthernamanda.converge_levelup.R;
import com.koushikdutta.ion.Ion;

import java.util.List;

import model.DeveloperModel;

public class DeveloperAdapter extends RecyclerView.Adapter<DeveloperAdapter.MyViewHolder> {

    private List<DeveloperModel> itemList;
    private Context context;

    public static final class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTxt;
        private ImageView developerImg;

        private MyViewHolder(View v) {
            super(v);

            nameTxt = v.findViewById(R.id.name_txt);
            developerImg = v.findViewById(R.id.developer_img);
        }
    }

    public DeveloperAdapter(List<DeveloperModel> itemList, Context context) {

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

        final DeveloperModel developerModel = itemList.get(position);
        holder.nameTxt.setText(developerModel.username);

        Ion.with(DeveloperAdapter.this.context)
                .load("http://i.imgur.com/DvpvklR.png")
                .intoImageView(holder.developerImg);

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
