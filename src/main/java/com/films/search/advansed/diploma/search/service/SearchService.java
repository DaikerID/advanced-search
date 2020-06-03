package com.films.search.advansed.diploma.search.service;

import com.films.search.advansed.diploma.controller.form.AdvancedSearchForm;
import com.films.search.advansed.diploma.search.entities.AdvancedSearchQuery;
import com.films.search.advansed.diploma.database.model.Movie;
import com.films.search.advansed.diploma.database.model.Profile;
import com.films.search.advansed.diploma.database.service.MovieService;
import com.films.search.advansed.diploma.database.service.ProfileService;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SearchService {

  MovieService movieService;
  ProfileService profileService;

  public List<Movie> findAllMoviesByAdvancedForm(AdvancedSearchForm searchForm) {
    return new ArrayList<>(movieService.findAllByQuery(AdvancedSearchQuery.build(searchForm)));
  }

  public List<Movie> findAllMoviesByName(String name){
    return movieService.findAllByNameContains(name.trim());
  }

  public List<Profile> findAllProfilesByName(String name, Specification<Profile> specification){
    return profileService.findAllProfilesByNameContains(name.trim(), specification);
  }

  ;
}
