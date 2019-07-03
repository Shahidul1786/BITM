package com.example.Recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private Context context;
    private List<Movie> movieList;

    public CustomAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_details,parent,false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Movie movie = movieList.get(position);

        holder.name.setText(movie.getMovieName());
        holder.director.setText(movie.getDirector());
        holder.image.setImageResource(movie.getImage());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,DetailsActivity.class);
                intent.putExtra("Image",movie.getImage());
                intent.putExtra("Movie",movie.getMovieName());
                intent.putExtra("Director",movie.getDirector());
                context.startActivity(intent);



            }
        });


    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name,director;
        private ImageView image;
        private CardView cardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.movienameTVID);
            director = itemView.findViewById(R.id.directornameTVID);
            image = itemView.findViewById(R.id.imageviewID);

            cardView = itemView.findViewById(R.id.cardviewID);


        }
    }
}
