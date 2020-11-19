package com.example.finalproject.controller;

import com.example.finalproject.model.Movie;
import com.example.finalproject.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("movies")
    public ResponseEntity<Movie> create(@RequestBody Movie movie) {
        movieService.save(movie);
        System.out.println("Movie: " + movie.toString() + " created!");
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }
}
