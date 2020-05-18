package com.films.search.advansed.diploma.database.service;

import static com.films.search.advansed.diploma.search.MovieSearchSpecificationHandler.*;

import com.films.search.advansed.diploma.controller.form.AdvancedSearchForm;
import com.films.search.advansed.diploma.controller.form.AdvancedSearchQuery;
import com.films.search.advansed.diploma.controller.form.entities.LocalDateInterval;
import com.films.search.advansed.diploma.database.model.Genre;
import com.films.search.advansed.diploma.database.model.Movie;
import com.films.search.advansed.diploma.database.model.Tag;
import com.films.search.advansed.diploma.database.repository.MovieRepository;
import com.films.search.advansed.diploma.search.MovieSearchSpecificationHandler;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

    //TODO transform
    AdvancedSearchQuery advancedSearchQuery = AdvancedSearchQuery.builder()
        .movieName(advancedSearchForm.getMovieName().trim())
        .countries(advancedSearchForm.getCountries().trim())
        .actorsName(advancedSearchForm.getActorsName().trim())
        .directorsName(advancedSearchForm.getDirectorsName().trim())
        .producersName(advancedSearchForm.getProducersName().trim())
        .genres(Genre.valueOf(advancedSearchForm.getGenres()))
        .tags(Tag.valueOf(advancedSearchForm.getTags()))
        .releaseDateLocalDateInterval(
            new LocalDateInterval(start, end))
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
      return movieRepository.findAll(Specification.where(hasNameLike(advancedSearchQuery)));
  }
}
