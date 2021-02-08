package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {

    private Movie[] movies = new Movie[0];
    private int countLastMovies = 10;

    public MovieManager() {
    }

    public MovieManager(int countLastMovies) {
        this.countLastMovies = countLastMovies;
    }

    public void add(Movie item) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];

        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        movies = tmp;
    }

    public Movie[] getLastMovies() {
        Movie[] result = new Movie[movies.length];

        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        if (result.length <= countLastMovies) {
            return result;
        } else {
            Movie[] result2 = new Movie[countLastMovies];
            System.arraycopy(result, 0, result2, 0, result2.length);
            return result2;
        }
    }
}
