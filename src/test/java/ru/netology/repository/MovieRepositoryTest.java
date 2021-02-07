package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryTest {

    private MovieRepository repository = new MovieRepository();

    private Movie first = new Movie(1, "Name1", "first", "http1", "http11");
    private Movie second = new Movie(2, "Name2", "second", "http2", "http22");
    private Movie third = new Movie(3, "Name3", "third", "http3", "http33");

    @BeforeEach
    void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
    }

    @Test
    void shouldSaveOne() {
        repository = new MovieRepository();
        repository.save(first);
        Movie[] expected = new Movie[]{first};
        Movie[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAll() {
        Movie[] expected = new Movie[]{first, second, third};
        Movie[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveAll() {
        repository.removeAll();
        Movie[] expected = new Movie[0];
        Movie[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        repository.removeById(2);
        Movie[] expected = new Movie[]{first, third};
        Movie[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindByFilmId() {
        Movie[] expected = new Movie[]{first};
        Movie[] actual = repository.findById(1);
        assertArrayEquals(expected, actual);
    }
}