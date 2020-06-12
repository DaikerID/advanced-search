package com.films.search.advansed.diploma.controller;

import com.films.search.advansed.diploma.database.model.common.Movie;
import com.films.search.advansed.diploma.database.service.MovieService;
import com.films.search.advansed.diploma.frontend.LocaleMapHandler;
import com.films.search.advansed.diploma.view.offer.service.ViewOfferService;
import java.util.Locale;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class MovieController {

  private final MovieService movieService;
  private final LocaleMapHandler localeMapHandler;
  private final ViewOfferService viewOfferService;

  @RequestMapping(value = "/movie/")
  public ModelAndView getMovie(@RequestParam Long movieId, Locale locale) {
    ModelAndView model = new ModelAndView("movie");
    Optional<Movie> movieOptional = movieService.findById(movieId);

    if (movieOptional.isPresent()) {
      Movie movie = movieOptional.get();
      model.addObject("movie", movie);
      model.addObject("localeMap", localeMapHandler.getMapForMoviePage(locale));
      model.addObject("viewOffers", viewOfferService.getOffersToWatch(movie.getName()));
      return model;
    }
    return new ModelAndView("error");
  }
}
