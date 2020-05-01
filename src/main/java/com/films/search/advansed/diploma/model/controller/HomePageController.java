package com.films.search.advansed.diploma.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController {
  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  public ModelAndView printHello() {
    ModelAndView model = new ModelAndView("hello");
    model.addObject("message", "Hello Spring MVC Framework!");
    return model;
  }
}
