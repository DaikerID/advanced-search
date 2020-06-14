package com.films.search.advansed.diploma.database.service;

import static com.films.search.advansed.diploma.search.utils.MovieSearchSpecificationUtils.buildSpecification;
import static com.films.search.advansed.diploma.search.utils.MovieSearchSpecificationUtils.hasNameLike;

import com.films.search.advansed.diploma.database.model.common.Movie;
import com.films.search.advansed.diploma.database.repository.MovieRepository;
import com.films.search.advansed.diploma.search.entities.AdvancedSearchQuery;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MovieService {

  private MovieRepository movieRepository;

  public Optional<Movie> findById(Long movieId) {
    return movieRepository.findById(movieId);
  }

  public List<Movie> findAllByNameContains(String name) {
    return new ArrayList<>(movieRepository.findAll(Specification.where(hasNameLike(name))));
  }

  public Set<Movie> findAllByQuery(AdvancedSearchQuery advancedSearchQuery) {
    return new HashSet<>(movieRepository.findAll(buildSpecification(advancedSearchQuery)));
  }
}
