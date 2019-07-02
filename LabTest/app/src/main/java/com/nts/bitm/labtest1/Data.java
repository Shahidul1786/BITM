package com.nts.bitm.labtest1;

public class Data {

    private String movieName;
    private String directorName;
    private int image;

    public Data(String movieName, String directorName, int image) {
        this.movieName = movieName;
        this.directorName = directorName;
        this.image = image;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getDirectorName() {
        return directorName;
    }

    public int getImage() {
        return image;
    }
}
