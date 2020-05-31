package com.films.search.advansed.diploma.database.repository;

import com.films.search.advansed.diploma.database.model.Movie;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface MovieRepository extends JpaRepository<Movie, Long>,
    JpaSpecificationExecutor<Movie> {

  List<Movie> findAll(Specification<Movie> specification);
}
