package com.films.search.advansed.diploma.controller;

import com.films.search.advansed.diploma.controller.form.AdvancedSearchForm;
import com.films.search.advansed.diploma.controller.form.SearchForm;
import com.films.search.advansed.diploma.database.model.Movie;
import com.films.search.advansed.diploma.frontend.WebMessageCode;
import com.films.search.advansed.diploma.frontend.WebMessageSource;
import com.films.search.advansed.diploma.service.SearchService;
import java.util.List;
import lombok.AllArgsConstructor;
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
    prepareForAdvancedSearchForm(model);
    return model;
  }

  @GetMapping("/search")
  public ModelAndView searchUser(SearchForm searchForm) {
    ModelAndView model = new ModelAndView("index");
    prepareForAdvancedSearchForm(model);
    model.addObject("search", searchForm.getSearchLine());
    return model;
  }

  @GetMapping("/advanced-search")
  public ModelAndView searchUser(AdvancedSearchForm searchForm) {
    ModelAndView model = new ModelAndView();
    List<Movie> movieList = searchService.findAllByExample(searchForm);

    if (movieList.size() == 1) {
      model.setViewName("movie");
      model.addObject("movie", movieList.get(0));
    } else if (movieList.size() > 1) {
      model.setViewName("index");
      model.addObject("movies", movieList);
    } else {
      model.setViewName("index");
      model.addObject("NO_RESULTS", messageSource.getMessage(WebMessageCode.NO_RESULTS));
    }
    prepareForAdvancedSearchForm(model);
    return model;
  }

  private void prepareForAdvancedSearchForm(ModelAndView model){
    model.addObject("genresMap", messageSource.getGenresMap());
    model.addObject("tagsMap", messageSource.getTagsMap());
    model.addObject("monthsMap", messageSource.getMonthsMap());
  }
}
