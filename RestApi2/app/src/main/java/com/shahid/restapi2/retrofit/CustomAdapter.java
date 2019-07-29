package com.shahid.restapi2.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shahid.restapi2.R;

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

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_info,parent,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        User user = userList.get(position);
        holder.postId.setText("post id : "+String.valueOf(user.getPostId()));
        holder.id.setText("Id : "+String.valueOf(user.getId()));
        holder.name.setText("Name : "+user.getName());
        holder.email.setText("Email : "+user.getEmail());
        holder.body.setText("Body : "+user.getBody());

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView postId,id,name,email,body;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            postId = itemView.findViewById(R.id.postIdTV);
            id = itemView.findViewById(R.id.idTV);
            name = itemView.findViewById(R.id.nameTV);
            email = itemView.findViewById(R.id.emailTV);
            body = itemView.findViewById(R.id.bodyTV);
        }
    }
}
