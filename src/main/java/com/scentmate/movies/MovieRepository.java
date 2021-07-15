package com.scentmate.movies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAll();
}