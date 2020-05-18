package com.films.search.advansed.diploma.service;

import com.films.search.advansed.diploma.controller.form.AdvancedSearchForm;
import com.films.search.advansed.diploma.database.model.Movie;
import com.films.search.advansed.diploma.database.service.MovieService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SearchService {

  MovieService movieService;

  public List<Movie> findAllByExample(AdvancedSearchForm searchForm) {
    Movie movie = movieService.fillExampleEntity(searchForm);
    //TODO matcher config
    ExampleMatcher matcher = ExampleMatcher.matchingAny().withIgnoreCase("name");
    return movieService.findAllByExample(Example.of(movie, matcher));
  }

  public List<Movie> findAllByName(String name){

    return List.of();
  }

  ;
}
