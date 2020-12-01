package com.example.finalproject.repository;

import com.example.finalproject.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    //@Query(nativeQuery = true, value = "SELECT id, name, price, category FROM Movie WHERE category = :category")
    //@Query(value = "SELECT NEW Movie(name, price, category) FROM Movie WHERE category = :category")
    //Tem que ter um construtor com os mesmos parâmetros
    //Collection<Movie> findAll(@Param("category") String category);

    //findByColumnName --> Usar este formato!
    Page<Movie> findByCategory(String category, Pageable pageable);

}
