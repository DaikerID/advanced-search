package com.films.search.advansed.diploma.service;

import com.films.search.advansed.diploma.controller.form.AdvancedSearchForm;
import com.films.search.advansed.diploma.search.entities.AdvancedSearchQuery;
import com.films.search.advansed.diploma.database.model.Movie;
import com.films.search.advansed.diploma.database.model.Profile;
import com.films.search.advansed.diploma.database.service.MovieService;
import com.films.search.advansed.diploma.database.service.ProfileService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SearchService {

  MovieService movieService;
  ProfileService profileService;

  public List<Movie> findAllMoviesByExample(AdvancedSearchForm searchForm) {
    return movieService.findAllByQuery(AdvancedSearchQuery.build(searchForm));
  }

  public List<Movie> findAllMoviesByName(String name){
    return movieService.findAllByNameContains(name.trim());
  }

  public List<Profile> findAllProfilesByName(String name){
    return profileService.findAllProfilesByNameContains(name.trim());
  }

  ;
}
