package com.learn.arraylist;

import static org.junit.jupiter.api.Assertions.*;

class MovieLibraryTest {
    private MovieLibrary movieLibrary;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        movieLibrary = new MovieLibrary();
    }

    @org.junit.jupiter.api.Test
    void shouldAddMovieToLibrary() {
        var title = "Matrix";
        var genre = "Science Fiction";

        movieLibrary.addMovie(title, genre);
        var actualMovies = movieLibrary.findMovieByGenre(genre);

        assertEquals(1, actualMovies.size());
        movieLibrary.printAll();
    }
}