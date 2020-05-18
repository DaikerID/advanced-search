package com.films.search.advansed.diploma.controller;

import com.films.search.advansed.diploma.database.model.Movie;
import com.films.search.advansed.diploma.database.service.MovieService;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class MovieController {
  MovieService movieService;

  @RequestMapping(value = "/movie/")
  public ModelAndView getMovie(@RequestParam Long movieId) {
    ModelAndView model = new ModelAndView("movie");
    Optional<Movie> profileOptional = movieService.findById(movieId);

    if (profileOptional.isPresent()) {
      model.addObject("movie", profileOptional.get());
      return model;
    }
    return new ModelAndView("error");
  }
}
