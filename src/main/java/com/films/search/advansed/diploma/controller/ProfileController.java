package com.films.search.advansed.diploma.controller;

import com.films.search.advansed.diploma.database.model.Profile;
import com.films.search.advansed.diploma.database.service.ProfileService;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class ProfileController {

  private ProfileService profileService;

  @RequestMapping(value = "/profile/")
  public ModelAndView getUser(@RequestParam Long profileId, HttpServletRequest request) {
    ModelAndView model = new ModelAndView("profile");
    Optional<Profile> profileOptional = profileService.findById(profileId);

    if (profileOptional.isPresent()) {
      model.addObject("profile", profileOptional.get());
      return model;
    }
    return new ModelAndView("error");
  }
}
