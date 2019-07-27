package com.shahid.d28_restapipost.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shahid.d28_restapipost.R;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private Context context;
    private List<User> userList;

    public CustomAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_info,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        User user = userList.get(position);
        holder.userId.setText("user id : "+String.valueOf(user.getUserId()));
        holder.id.setText("ID : "+String.valueOf(user.getId()));
        holder.title.setText("Title : "+user.getTitle());
        holder.body.setText("Body : "+user.getBody());

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView userId,id,title,body;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userId = itemView.findViewById(R.id.userIdTV);
            id = itemView.findViewById(R.id.IdTV);
            title = itemView.findViewById(R.id.titleIdTV);
            body = itemView.findViewById(R.id.bodyIdTV);

        }
    }
}
