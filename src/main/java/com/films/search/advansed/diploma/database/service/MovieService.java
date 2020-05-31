package com.films.search.advansed.diploma.database.service;

import static com.films.search.advansed.diploma.search.MovieSearchSpecificationHandler.*;

import com.films.search.advansed.diploma.search.entities.AdvancedSearchQuery;
import com.films.search.advansed.diploma.database.model.Movie;
import com.films.search.advansed.diploma.database.repository.MovieRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    return new ArrayList<>(movieRepository.findAllByNameContains(name));
  }

  public List<Movie> findAllByQuery(AdvancedSearchQuery advancedSearchQuery) {
    return movieRepository.findAll(Specification
        .where(hasNameLike(advancedSearchQuery))
        .and(hasCountryLike(advancedSearchQuery))
        .and(hasPremierDateGreaterThan(advancedSearchQuery))
        .and(hasPremierDateLessThan(advancedSearchQuery))
        .and(hasGenres2(advancedSearchQuery))
        .and(hasTags(advancedSearchQuery)));
  }
}
