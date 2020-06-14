package com.films.search.advansed.diploma.controller;

import static com.films.search.advansed.diploma.search.utils.ProfileSearchSpecificationUtils.*;

import com.films.search.advansed.diploma.controller.form.AdvancedSearchForm;
import com.films.search.advansed.diploma.controller.form.SearchForm;
import com.films.search.advansed.diploma.database.model.common.Movie;
import com.films.search.advansed.diploma.database.model.common.Profile;
import com.films.search.advansed.diploma.frontend.LocaleMapHandler;
import com.films.search.advansed.diploma.frontend.WebMessageCode;
import com.films.search.advansed.diploma.frontend.WebMessageSource;
import com.films.search.advansed.diploma.search.service.SearchService;
import java.util.List;
import java.util.Locale;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class HomePageController {

  WebMessageSource messageSource;
  LocaleMapHandler localeMapHandler;
  SearchService searchService;

  @GetMapping(value = "/")
  public ModelAndView printHello(Locale locale) {
    ModelAndView model = new ModelAndView("index");
    model.addObject("movies", List.of());
    model.addObject("profiles", List.of());
    model.addObject("localeMap", localeMapHandler.getMapForHomePage(locale));
    prepareForAdvancedSearchForm(model, locale);
    return model;
  }

  @GetMapping("/search")
  public ModelAndView searchUser(SearchForm searchForm, Locale locale) {
    ModelAndView model = new ModelAndView();
    prepareForAdvancedSearchForm(model, locale);
    model.addObject("search", searchForm.getSearchLine());
    prepareModelForShowResults(model, locale,
        searchService.findAllMoviesByName(searchForm.getSearchLine()),
        searchService.findAllProfilesByName(searchForm.getSearchLine(),
            Specification.where(isAnyone())));
    return model;
  }

  @GetMapping("/advanced-search")
  public ModelAndView searchUser(AdvancedSearchForm searchForm, Locale locale) {
    ModelAndView model = new ModelAndView();
    prepareForAdvancedSearchForm(model, locale);
    prepareModelForShowResults(model, locale, searchService.findAllMoviesByAdvancedForm(searchForm),
        List.of());
    return model;
  }

  private void prepareForAdvancedSearchForm(ModelAndView model, Locale locale) {
    model.addObject("genresMap", messageSource.getGenresMap(locale));
    model.addObject("tagsMap", messageSource.getTagsMap(locale));
    model.addObject("monthsMap", messageSource.getMonthsMap(locale));
  }

  private void prepareModelForShowResults(ModelAndView model, Locale locale, List<Movie> movieList,
      List<Profile> profileList) {
    if (movieList.size() == 1 && profileList.size() == 0) {
      model.setViewName("movie");
      model.addObject("movie", movieList.get(0));
      model.addObject("localeMap", localeMapHandler.getMapForMoviePage(locale));
    } else if (profileList.size() == 1 && movieList.size() == 0) {
      model.setViewName("profile");
      model.addObject("profile", profileList.get(0));
      model.addObject("localeMap", localeMapHandler.getMapForProfilePage(locale));
    } else if (movieList.size() > 0 || profileList.size() > 0) {
      model.setViewName("index");
      model.addObject("movies", movieList);
      model.addObject("profiles", profileList);
      model.addObject("localeMap", localeMapHandler.getMapForHomePage(locale));
    } else {
      model.setViewName("index");
      model.addObject("NO_RESULTS",
          messageSource.getMessage(locale, WebMessageCode.NO_RESULTS));
      model.addObject("movies", List.of());
      model.addObject("profiles", List.of());
      model.addObject("localeMap", localeMapHandler.getMapForHomePage(locale));
    }
  }
}
