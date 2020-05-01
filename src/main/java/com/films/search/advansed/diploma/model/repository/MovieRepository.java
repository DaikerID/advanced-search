package com.films.search.advansed.diploma.model.repository;

import com.films.search.advansed.diploma.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
