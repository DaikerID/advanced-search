package com.films.search.advansed.diploma.controller;

import com.films.search.advansed.diploma.controller.form.SearchForm;
import com.films.search.advansed.diploma.frontend.WebMessageCode;
import com.films.search.advansed.diploma.frontend.WebMessageSource;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class HomePageController {

  WebMessageSource messageSource;

  @GetMapping(value = "/")
  public ModelAndView printHello() {
    ModelAndView model = new ModelAndView("hello");
    model.addObject("header_label", messageSource.getMessage(WebMessageCode.HEADER_LABEL));
    return model;
  }

  @GetMapping("/search")
  public ModelAndView searchUser(SearchForm searchForm) {
    ModelAndView model = new ModelAndView("hello");
    model.addObject("header_label", messageSource.getMessage(WebMessageCode.HEADER_LABEL));
    model.addObject("search", searchForm.getSearchLine());
    return model;
  }
}
