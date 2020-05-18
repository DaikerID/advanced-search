package com.films.search.advansed.diploma.database.service;

import com.films.search.advansed.diploma.controller.form.AdvancedSearchForm;
import com.films.search.advansed.diploma.controller.form.AdvancedSearchQuery;
import com.films.search.advansed.diploma.database.model.Movie;
import com.films.search.advansed.diploma.database.model.Profile;
import com.films.search.advansed.diploma.database.repository.MovieRepository;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MovieService {

  private MovieRepository movieRepository;

  public Movie fillExampleEntity(AdvancedSearchForm advancedSearchForm) {
    //TODO transform
    LocalDate start;
    try {
      start = LocalDate.of(
          Integer.parseInt(advancedSearchForm.getReleaseYearStart()),
          Month.valueOf(advancedSearchForm.getReleaseMonthStart()),
          Integer.parseInt(advancedSearchForm.getReleaseDayStart()));
    } catch (NumberFormatException e) {
      start = null;
    }

    LocalDate end;
    try {
      end = LocalDate.of(
          Integer.parseInt(advancedSearchForm.getReleaseYearStart()),
          Month.valueOf(advancedSearchForm.getReleaseMonthStart()),
          Integer.parseInt(advancedSearchForm.getReleaseDayStart()));
    } catch (NumberFormatException e) {
      end = Objects.isNull(start) ? null : LocalDate.now();
    }

    return Movie.builder().build();
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
}
