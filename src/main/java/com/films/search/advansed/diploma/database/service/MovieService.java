package com.films.search.advansed.diploma.database.service;

import static com.films.search.advansed.diploma.LocalDateTimeUtils.parseInterval;
import static com.films.search.advansed.diploma.search.MovieSearchSpecificationHandler.hasCountryLike;
import static com.films.search.advansed.diploma.search.MovieSearchSpecificationHandler.hasNameLike;
import static com.films.search.advansed.diploma.search.MovieSearchSpecificationHandler.hasPremierDateGreaterThan;
import static com.films.search.advansed.diploma.search.MovieSearchSpecificationHandler.hasPremierDateLessThan;

import com.films.search.advansed.diploma.controller.form.AdvancedSearchForm;
import com.films.search.advansed.diploma.controller.form.AdvancedSearchQuery;
import com.films.search.advansed.diploma.database.model.Genre;
import com.films.search.advansed.diploma.database.model.Movie;
import com.films.search.advansed.diploma.database.model.Tag;
import com.films.search.advansed.diploma.database.repository.MovieRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MovieService {

  private MovieRepository movieRepository;

  public AdvancedSearchQuery fillExampleEntity(AdvancedSearchForm advancedSearchForm) {

    //TODO transform with arrays
    AdvancedSearchQuery advancedSearchQuery = AdvancedSearchQuery.builder()
        .movieName(advancedSearchForm.getMovieName().trim())
        .countries(advancedSearchForm.getCountries().trim())
        .actorsName(advancedSearchForm.getActorsName().trim())
        .directorsName(advancedSearchForm.getDirectorsName().trim())
        .producersName(advancedSearchForm.getProducersName().trim())
        .genres(Genre.valueOf(advancedSearchForm.getGenres()))
        .tags(Tag.valueOf(advancedSearchForm.getTags()))
        .releaseDateLocalDateInterval(parseInterval(advancedSearchForm))
        .build();
    return advancedSearchQuery;
  }

  public List<Movie> search(AdvancedSearchQuery searchQuery) {
    return List.of();
  }

  public List<Movie> findAll() {
    return movieRepository.findAll();
  }

  public List<Movie> findAllByExample(Example<Movie> example) {
    return movieRepository.findAll(example);
  }

  public Optional<Movie> findById(Long movieId) {
    return movieRepository.findById(movieId);
  }

  public List<Movie> findAllByNameContains(String name) {
    return new ArrayList<>(movieRepository.findAllByNameContains(name));
  }

  public List<Movie> findAllByQuery(AdvancedSearchQuery advancedSearchQuery) {
    return movieRepository.findAll(Specification
        .where(hasNameLike(advancedSearchQuery)
            .and(hasCountryLike(advancedSearchQuery)
            .and(hasPremierDateGreaterThan(advancedSearchQuery))
            .and(hasPremierDateLessThan(advancedSearchQuery)))));
  }
}
