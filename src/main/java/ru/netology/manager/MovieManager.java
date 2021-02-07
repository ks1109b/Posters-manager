package ru.netology.manager;

import lombok.NoArgsConstructor;
import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

@NoArgsConstructor

public class MovieManager {

    private MovieRepository repository;

    public MovieManager(MovieRepository repository) {
        this.repository = repository;
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

    public Movie[] findByID(int id) {
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
