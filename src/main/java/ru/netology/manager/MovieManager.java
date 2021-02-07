package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

public class MovieManager {

    private MovieRepository repository;
    private int countLastMovies = 10;

    public MovieManager() {
    }

    public MovieManager(int countLastMovies) {
        this.countLastMovies = countLastMovies;
    }

    public MovieManager(MovieRepository repository) {
        this.repository = repository;
    }

    public MovieManager(MovieRepository repository, int countLastMovies) {
        this.repository = repository;
        this.countLastMovies = countLastMovies;
    }

    public void add(Movie item) {
        repository.save(item);
    }

    public Movie[] getAll() {
        Movie[] items = repository.findAll();
        Movie[] result = new Movie[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public Movie[] findById(int id) {
        Movie[] result = repository.findById(id);
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public void removeAll() {
        repository.removeAll();
    }
}
