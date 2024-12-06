package com.learn.arraylist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MovieLibraryTest {
    private MovieLibrary movieLibrary;

    @BeforeEach
    void setUp() {
        movieLibrary = new MovieLibrary();
    }

    @Test
    void shouldAddMovieToLibrary() {
        var title = "Matrix";
        var genre = "Science Fiction";

        movieLibrary.addMovie(title, genre);
        var actualMovies = movieLibrary.findMovieByGenre(genre);

        assertEquals(1, actualMovies.size());
        movieLibrary.printAll();
    }

    @Test
    void shouldFindMovieByGenreFromLibrary() {
        var title = "Matrix";
        var title2 = "Three Body Problem";
        var title3 = "Johnny English";
        var title4 = "Notebook";
        var title5 = "Top Gun";

        var genreSF = "Science Fiction";
        var genreComedy = "Comedy";
        var genreRomance = "Romance";
        var genreAction = "Action";

        movieLibrary.addMovie(title, genreSF);
        movieLibrary.addMovie(title2, genreSF);
        movieLibrary.addMovie(title3, genreComedy);
        //movieLibrary.addMovie(title4, genreRomance);
        movieLibrary.addMovie(title5, genreAction);

        var sfMovies = movieLibrary.findMovieByGenre(genreSF);
        var romanceMovies = movieLibrary.findMovieByGenre(genreRomance);

        assertEquals(4, movieLibrary.movieList.size());
        assertEquals(2, sfMovies.size());
        assertEquals(0, romanceMovies.size());
    }
    @Test
    void shouldPrintAllMoviesFromLibrary() {
        var title = "Matrix";
        var title2 = "Three Body Problem";
        var title3 = "Johnny English";
        var title4 = "Notebook";
        var title5 = "Top Gun";

        var genreSF = "Science Fiction";
        var genreComedy = "Comedy";
        var genreRomance = "Romance";
        var genreAction = "Action";

        movieLibrary.addMovie(title, genreSF);
        movieLibrary.addMovie(title2, genreSF);
        movieLibrary.addMovie(title3, genreComedy);
        movieLibrary.addMovie(title4, genreRomance);
        movieLibrary.addMovie(title5, genreAction);
        movieLibrary.printAll();

        assertEquals(5, movieLibrary.movieList.size());

    }
    @Test
    void shouldRemoveMovieFromLibrary() {
        var title = "Matrix";
        var title2 = "Three Body Problem";
        var title3 = "Johnny English";
        var title4 = "Notebook";
        var title5 = "Top Gun";

        var genreSF = "Science Fiction";
        var genreComedy = "Comedy";
        var genreRomance = "Romance";
        var genreAction = "Action";
        var genreThriller = "Thriller";

        movieLibrary.addMovie(title, genreSF);
        movieLibrary.addMovie(title2, genreSF);
        movieLibrary.addMovie(title3, genreComedy);
        movieLibrary.addMovie(title4, genreRomance);
        movieLibrary.addMovie(title5, genreAction);
        movieLibrary.removeMovie(genreSF);
        //movieLibrary.removeMovie(genreThriller);

        assertEquals(3, movieLibrary.movieList.size());

    }
}