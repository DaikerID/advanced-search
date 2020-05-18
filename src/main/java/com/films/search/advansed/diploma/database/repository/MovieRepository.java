package com.films.search.advansed.diploma.database.repository;

import com.films.search.advansed.diploma.database.model.Movie;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface MovieRepository extends JpaRepository<Movie, Long>,
    JpaSpecificationExecutor<Movie> {
  Set<Movie> findAllByNameContains(String name);
  List<Movie> findAll(Specification<Movie> specification);
}
