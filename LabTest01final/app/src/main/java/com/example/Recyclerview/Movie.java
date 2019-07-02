package com.example.Recyclerview;

public class Movie {

    String movieName;
    String director;
    int image;

    public Movie() {
    }

    public Movie(String movieName, String director, int image) {
        this.movieName = movieName;
        this.director = director;
        this.image = image;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getDirector() {
        return director;
    }

    public int getImage() {
        return image;
    }
}
