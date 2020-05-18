package com.films.search.advansed.diploma.service;

import com.films.search.advansed.diploma.controller.form.AdvancedSearchForm;
import com.films.search.advansed.diploma.controller.form.AdvancedSearchQuery;
import com.films.search.advansed.diploma.database.model.Movie;
import com.films.search.advansed.diploma.database.model.Profile;
import com.films.search.advansed.diploma.database.service.MovieService;
import com.films.search.advansed.diploma.database.service.ProfileService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SearchService {

  MovieService movieService;
  ProfileService profileService;

  public List<Movie> findAllMoviesByExample(AdvancedSearchForm searchForm) {
    AdvancedSearchQuery advancedSearchQuery = movieService.fillExampleEntity(searchForm);
    //TODO matcher config
    ExampleMatcher matcher = ExampleMatcher.matchingAny().withIgnoreCase("name");
    //return movieService.findAllByExample(Example.of(movie, matcher));
    return movieService.findAllByQuery(advancedSearchQuery);
  }

  public List<Movie> findAllMoviesByName(String name){
    return movieService.findAllByNameContains(name.trim());
  }

  public List<Profile> findAllProfilesByName(String name){
    return profileService.findAllProfilesByNameContains(name.trim());
  }

  ;
}
