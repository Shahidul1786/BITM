package com.nts.bitm.labtest1;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private List<Data> movieList;
    private Context context;

    public CustomAdapter(List<Data> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_details,viewGroup,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {

        final Data movies = movieList.get(i);
        viewHolder.imageView.setImageResource(movies.getImage());
        viewHolder.name.setText(movies.getMovieName());
        viewHolder.director.setText(movies.getDirectorName());

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,DetailsActivity.class);
                intent.putExtra("Image",movies.getImage());
                intent.putExtra("Movie",movies.getMovieName());
                intent.putExtra("Director",movies.getDirectorName());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView name,director;
        private CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.detailsImage);
            name = itemView.findViewById(R.id.detailsNameTV);
            director = itemView.findViewById(R.id.detailsDirectorTV);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
