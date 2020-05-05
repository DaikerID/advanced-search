package com.films.search.advansed.diploma.database.service;

import com.films.search.advansed.diploma.controller.form.AdvancedSearchQuery;
import com.films.search.advansed.diploma.database.model.Movie;
import com.films.search.advansed.diploma.database.repository.MovieRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MovieService {

  private MovieRepository movieRepository;

  public List<Movie> search(AdvancedSearchQuery searchQuery) {
    return List.of();
  }
}
