package com.example.finalproject.service;

import com.example.finalproject.model.Movie;
import com.example.finalproject.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }
}
