package ru.netology.repository;

import ru.netology.domain.Movie;

public class MovieRepository {

    private Movie[] movies = new Movie[0];

    public Movie[] findAll() {
        return movies;
    }

    public void save(Movie item) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        movies = tmp;
    }

    public Movie[] findById(int movieId){
        Movie[] result = new Movie[1];
        for (Movie item : movies) {
            if (item.getMovieId() == movieId) {
                result[0] = item;
            }
        }
        return result;
    }

    public void removeById(int id) {
        int length = movies.length - 1;
        Movie[] tmp = new Movie[length];
        int index = 0;
        for (Movie movie : movies) {
            if (movie.getMovieId() != id) {
                tmp[index] = movie;
                index++;
            }
        }
        movies = tmp;
    }

    public void removeAll() {
        Movie[] tmp = new Movie[0];
        movies = tmp;
    }
}
