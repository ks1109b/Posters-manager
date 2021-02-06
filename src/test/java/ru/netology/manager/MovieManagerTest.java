package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {

    private MovieManager manager = new MovieManager();
    private Movie first = new Movie(1, "Name1", "first", "http1", "http11");
    private Movie second = new Movie(2, "Name2", "second", "http2", "http22");
    private Movie third = new Movie(3, "Name3", "third", "http3", "http33");
    private Movie fourth = new Movie(4, "Name4", "fourth", "http4", "http44");
    private Movie fifth = new Movie(5, "Name5", "fifth", "http5", "http55");
    private Movie sixth = new Movie(6, "Name6", "sixth", "http6", "http66");
    private Movie seventh = new Movie(7, "Name7", "seventh", "http7", "http77");
    private Movie eighth = new Movie(8, "Name8", "eighth", "http8", "http88");
    private Movie ninth = new Movie(9, "Name9", "ninth", "http9", "http99");
    private Movie tenth = new Movie(10, "Name10", "tenth", "http10", "http110");
    private Movie eleventh = new Movie(11, "Name11", "eleventh", "http11", "http111");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
    }

    @Test
    public void shouldGetLastsIfNotMovies() {
        manager = new MovieManager();

        Movie[] actual = manager.getLastMovies();
        Movie[] expected = new Movie[]{};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldGetLastsIfOneMovie() {
        manager = new MovieManager();

        manager.add(first);

        Movie[] actual = manager.getLastMovies();
        Movie[] expected = new Movie[]{first};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldGetLastsIfSomeMovies() {
        manager = new MovieManager();

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

        Movie[] actual = manager.getLastMovies();
        Movie[] expected = new Movie[]{fifth, fourth, third, second, first};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldGetLastsIfMoreMovies() {

        Movie[] actual = manager.getLastMovies();
        Movie[] expected = new Movie[]{eleventh, tenth, ninth, eighth, seventh, sixth,
                fifth, fourth, third, second};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldGetLastsIfCountNull() {
        manager = new MovieManager(0);

        manager.add(first);

        Movie[] actual = manager.getLastMovies();
        Movie[] expected = new Movie[]{};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldGetLastsIfCountOne() {
        manager = new MovieManager(1);

        manager.add(first);
        manager.add(second);

        Movie[] actual = manager.getLastMovies();
        Movie[] expected = new Movie[]{second};

        assertArrayEquals(actual, expected);
    }
}