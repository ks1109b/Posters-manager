package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MovieManagerTest {

    @Mock
    private MovieRepository repository;

    @InjectMocks
    private MovieManager manager;

    private Movie first = new Movie(1, "Name1", "first", "http1", "http11");
    private Movie second = new Movie(2, "Name2", "second", "http2", "http22");
    private Movie third = new Movie(3, "Name3", "third", "http3", "http33");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    public void shouldGetEmpty() {
        Movie[] returned = new Movie[0];
        doReturn(returned).when(repository).findAll();

        Movie[] expected = new Movie[0];
        Movie[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldRemoveById() {
        int idToRemove = 3;
        Movie[] returned = new Movie[]{first, second};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        manager.removeById(idToRemove);
        Movie[] expected = new Movie[]{second, first};
        Movie[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).removeById(idToRemove);
    }

    @Test
    public void shouldFindById() {
        int idToFind = 2;
        Movie[] returned = new Movie[]{second};
        doReturn(returned).when(repository).findById(idToFind);

        Movie[] expected = new Movie[]{second};
        Movie[] actual = manager.findById(idToFind);
        assertArrayEquals(expected, actual);

        verify(repository).findById(idToFind);
    }

    @Test
    public void shouldRemoveAll() {
        Movie[] returned = new Movie[0];
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeAll();

        manager.removeAll();
        Movie[] expected = new Movie[0];
        Movie[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).findAll();
        verify(repository).removeAll();
    }
}