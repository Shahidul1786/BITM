package com.example.tourmate.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.tourmate.MomentImageActivity;
import com.example.tourmate.PojoClass.Moment;
import com.example.tourmate.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MomentAdapter extends RecyclerView.Adapter<MomentHolder> {
    private Context context;
    private List<Moment> momentList;

    public MomentAdapter(Context context, List<Moment> momentList) {
        this.context = context;
        this.momentList = momentList;
    }

    @NonNull
    @Override
    public MomentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MomentHolder(
                LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_moment_recycler,parent,false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull MomentHolder holder, int position) {
        final Moment moment = momentList.get(position);
        Picasso.get().load(moment.getMomentImg()).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MomentImageActivity.class);
                intent.putExtra("moment", moment);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return momentList.size();
    }
}
class MomentHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    public MomentHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.momentImg);
    }
}
