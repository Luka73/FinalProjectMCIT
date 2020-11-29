package com.example.finalproject.service;

import com.example.finalproject.model.Movie;
import com.example.finalproject.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie update(Movie movie) {
        return movieRepository.save(movie);
    }

    public Collection<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Collection<Movie> findAll(String category) { return movieRepository.findAll(category); }

    public Movie findById(int id) {
        return movieRepository.findById(id).orElse(null);
    }

    public void delete(Movie movie) {
        movieRepository.delete(movie);
    }
}
