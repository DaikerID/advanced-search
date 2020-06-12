package com.films.search.advansed.diploma.controller;

import com.films.search.advansed.diploma.database.model.common.Profile;
import com.films.search.advansed.diploma.database.service.ProfileService;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class ProfileController {

  private final ProfileService profileService;

  @RequestMapping(value = "/profile/")
  public ModelAndView getProfile(@RequestParam Long profileId, HttpServletRequest request) {
    ModelAndView model = new ModelAndView("profile");
    Optional<Profile> profileOptional = profileService.findById(profileId);

    if (profileOptional.isPresent()) {
      model.addObject("profile", profileOptional.get());
      return model;
    }
    return new ModelAndView("error");
  }
}
