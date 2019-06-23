package com.example.bitmd11RecyclerViewuserInputitemClick;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private List<User> userList;

    public CustomAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_userlist,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder viewHolder, int i) {

        User currentUser = userList.get(i);

        viewHolder.nameTV.setText(currentUser.getName());
        viewHolder.phoneTV.setText(currentUser.getPhoneNo());
        viewHolder.emailTV.setText(currentUser.getEmail());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTV,phoneTV,emailTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV =itemView.findViewById(R.id.nameTVID);
            phoneTV =itemView.findViewById(R.id.phoneTVID);
            emailTV =itemView.findViewById(R.id.emailTVID);
        }
    }
}
