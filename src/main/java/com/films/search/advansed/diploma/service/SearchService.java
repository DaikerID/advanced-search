package com.films.search.advansed.diploma.service;

import com.films.search.advansed.diploma.controller.form.AdvancedSearchForm;
import com.films.search.advansed.diploma.controller.form.AdvancedSearchQuery;
import com.films.search.advansed.diploma.database.model.Movie;
import com.films.search.advansed.diploma.database.service.MovieService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SearchService {

  MovieService movieService;

  public List<Movie> search(AdvancedSearchForm searchForm) {
    return movieService.search(new AdvancedSearchQuery());
  }
}
