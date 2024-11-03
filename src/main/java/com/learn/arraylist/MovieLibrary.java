package com.learn.arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieLibrary {
    /*
    Develop a program that manages a library of movies, allowing users to perform several
    operations. Each movie will have a title and a genre.
    Use an ArrayList to store the movies, represented by a Movie class.

Add a movie - Add a new movie to the list with its title and genre.
Find movies by genre - Filter and display all movies of a specified genre.
Display movie library - Print all movie titles along with their genres.
Remove movies by genre - Remove all movies of a specified genre from the lis/
     */
    List<Movie> movieList = new ArrayList<Movie>();

    public void addMovie(String title, String genre) {

        Movie myMovie = new Movie(title, genre);
        movieList.add(myMovie);
    }

    public List<Movie> findMovieByGenre(String genre) {
        return movieList.stream()
                .filter(movie -> movie.getGenre().equals(genre))
                .collect(Collectors.toList());
    }

    public void printAll() {
        for (Movie m : movieList) {
            System.out.println(m);
        }
    }
    public void removeMovie(String genre) {
        List<Movie> movieListToRemove = findMovieByGenre(genre);
        if (movieListToRemove == null || movieListToRemove.isEmpty()) {
            System.out.println("The movie list is either not initialized (null) or empty.");
        } else {
            System.out.println("Following movies will remove from the library:");
            for (Movie movie : movieListToRemove ) {
                System.out.println(movie);
            }
            movieList.removeAll(findMovieByGenre(genre));
        }
    }
}
