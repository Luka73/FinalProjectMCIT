package com.example.finalproject.controller;

import com.example.finalproject.model.Movie;
import com.example.finalproject.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@CrossOrigin(origins = "*") //libera o acesso do Angular
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

    @PutMapping("movies")
    public ResponseEntity<Movie> update(@RequestBody Movie movie) {
        Movie result = movieService.findById(movie.getId());
        if(result == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        movieService.update(movie);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

  /*  @GetMapping("movies")
    public ResponseEntity<Collection<Movie>> readAll() {
        Collection<Movie> movies = movieService.findAll();
        if(movies == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }*/

    @GetMapping("movie/{id}")
    public ResponseEntity<Movie> read(@PathVariable int id) {
        Movie movie = movieService.findById(id);
        if(movie == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @GetMapping("/movies")
    public ResponseEntity<Page<Movie>> readAll(@PageableDefault(page = 0, size = 10, sort = "id",
                                                    direction = Sort.Direction.ASC) Pageable pageable,
                                                   @RequestParam(required = false) String category){
        Page<Movie> moviePage = movieService.findAll(pageable, category);
        if(moviePage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(moviePage, HttpStatus.OK);
        }
    }

    /*@GetMapping("movies/{category}")
    public ResponseEntity<Collection<Movie>> readAll(@PathVariable String category) {
        Collection<Movie> movies = movieService.findAll(category);
        if(movies == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }*/

    @DeleteMapping("movie/{id}")
    public ResponseEntity<Movie> delete(@PathVariable int id) {
        Movie movie = movieService.findById(id);
        if(movie == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        movieService.delete(movie);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }
}
