package com.films.search.advansed.diploma.model.controller;

import com.films.search.advansed.diploma.model.controller.form.SearchForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController {

  @GetMapping(value = "/hello")
  public ModelAndView printHello() {
    ModelAndView model = new ModelAndView("hello");
    model.addObject("message", "Advanced search home page!");
    return model;
  }

  @GetMapping("/search")
  public ModelAndView searchUser(SearchForm searchForm) {
    ModelAndView model = new ModelAndView("hello");
    model.addObject("search", searchForm.getSearchLine());
    return model;
  }
}
