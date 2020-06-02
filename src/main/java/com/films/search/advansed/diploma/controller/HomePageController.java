package com.films.search.advansed.diploma.controller;

import static com.films.search.advansed.diploma.search.handler.ProfileSpecificationHandler.*;

import com.films.search.advansed.diploma.controller.form.AdvancedSearchForm;
import com.films.search.advansed.diploma.controller.form.SearchForm;
import com.films.search.advansed.diploma.database.model.Movie;
import com.films.search.advansed.diploma.database.model.Profile;
import com.films.search.advansed.diploma.frontend.WebMessageCode;
import com.films.search.advansed.diploma.frontend.WebMessageSource;
import com.films.search.advansed.diploma.search.service.SearchService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class HomePageController {

  WebMessageSource messageSource;
  SearchService searchService;

  @GetMapping(value = "/")
  public ModelAndView printHello() {
    ModelAndView model = new ModelAndView("index");
    model.addObject("movies", List.of());
    model.addObject("profiles", List.of());
    prepareForAdvancedSearchForm(model);
    return model;
  }

  @GetMapping("/search")
  public ModelAndView searchUser(SearchForm searchForm) {
    ModelAndView model = new ModelAndView();
    prepareForAdvancedSearchForm(model);
    model.addObject("search", searchForm.getSearchLine());
    prepareModelForShowResults(model,
        searchService.findAllMoviesByName(searchForm.getSearchLine()),
        searchService.findAllProfilesByName(searchForm.getSearchLine(),
            Specification.where(isAnyone())));
    return model;
  }

  @GetMapping("/advanced-search")
  public ModelAndView searchUser(AdvancedSearchForm searchForm) {
    ModelAndView model = new ModelAndView();
    prepareForAdvancedSearchForm(model);
    prepareModelForShowResults(model, searchService.findAllMoviesByAdvancedForm(searchForm),
        List.of());
    return model;
  }

  private void prepareForAdvancedSearchForm(ModelAndView model) {
    model.addObject("genresMap", messageSource.getGenresMap());
    model.addObject("tagsMap", messageSource.getTagsMap());
    model.addObject("monthsMap", messageSource.getMonthsMap());
  }

  private void prepareModelForShowResults(ModelAndView model, List<Movie> movieList,
      List<Profile> profileList) {
    if (movieList.size() == 1 && profileList.size() == 0) {
      model.setViewName("movie");
      model.addObject("movie", movieList.get(0));
    } else if (profileList.size() == 1 && movieList.size() == 0) {
      model.setViewName("profile");
      model.addObject("profile", profileList.get(0));
    } else if (movieList.size() > 0 || profileList.size() > 0) {
      model.setViewName("index");
      model.addObject("movies", movieList);
      model.addObject("profiles", profileList);
    } else {
      model.setViewName("index");
      model.addObject("NO_RESULTS", messageSource.getMessage(WebMessageCode.NO_RESULTS));
    }
  }
}
