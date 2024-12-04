package com.demo.APS.movie;

import java.util.List;

public class Movies {
    private List<Movie> movies;

    public Movies() {
    }

    public Movies(List<Movie> movies) {
        this.movies = movies;
    }

    // Getter and setter
    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
