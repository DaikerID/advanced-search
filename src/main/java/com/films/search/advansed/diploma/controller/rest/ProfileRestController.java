package com.films.search.advansed.diploma.controller.rest;

import static com.films.search.advansed.diploma.search.utils.ProfileSearchSpecificationUtils.*;

import com.films.search.advansed.diploma.controller.form.SearchForm;
import com.films.search.advansed.diploma.search.service.SearchService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProfileRestController {

  private final SearchService searchService;

  @RequestMapping(value = "/ajax-search", method = RequestMethod.POST)
  public String search(@RequestParam SearchForm searchForm) {

    searchService.findAllMoviesByName(searchForm.getSearchLine());
    searchService.findAllProfilesByName(searchForm.getSearchLine(), isAnyone());
    return "";
  }
}
