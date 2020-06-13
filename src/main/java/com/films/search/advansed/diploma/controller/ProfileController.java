package com.films.search.advansed.diploma.controller;

import com.films.search.advansed.diploma.database.model.common.Profile;
import com.films.search.advansed.diploma.database.service.ProfileService;
import com.films.search.advansed.diploma.frontend.LocaleMapHandler;
import java.util.Locale;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class ProfileController {

  private final LocaleMapHandler localeMapHandler;
  private final ProfileService profileService;

  @RequestMapping(value = "/profile/")
  public ModelAndView getProfile(@RequestParam Long profileId, Locale locale) {
    ModelAndView model = new ModelAndView("profile");
    Optional<Profile> profileOptional = profileService.findById(profileId);

    if (profileOptional.isPresent()) {
      model.addObject("profile", profileOptional.get());
      model.addObject("localeMap", localeMapHandler.getMapForProfilePage(locale));
      return model;
    }
    return new ModelAndView("error");
  }
}
