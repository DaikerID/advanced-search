package com.films.search.advansed.diploma.frontend;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LocaleMapHandler {

  private final WebMessageSource messageSource;

  public Map<WebMessageCode, String> getMapForHomePage(Locale locale) {
    Map<WebMessageCode, String> localeMap = new HashMap<>();
    prepareHeaderLabels(localeMap, locale);
    localeMap.put(WebMessageCode.ADVANCED_MOVIE_SEARCH,
        messageSource.getMessage(locale, WebMessageCode.ADVANCED_MOVIE_SEARCH));
    localeMap.put(WebMessageCode.FULL_NAME_OR_PART_OF_IT,
        messageSource.getMessage(locale, WebMessageCode.FULL_NAME_OR_PART_OF_IT));
    localeMap.put(WebMessageCode.BY_MOVIE_NAME,
        messageSource.getMessage(locale, WebMessageCode.BY_MOVIE_NAME));
    localeMap.put(WebMessageCode.BY_ACTOR,
        messageSource.getMessage(locale, WebMessageCode.BY_ACTOR));
    localeMap.put(WebMessageCode.BY_DIRECTOR,
        messageSource.getMessage(locale, WebMessageCode.BY_DIRECTOR));
    localeMap.put(WebMessageCode.BY_PRODUCER,
        messageSource.getMessage(locale, WebMessageCode.BY_PRODUCER));
    localeMap.put(WebMessageCode.ADD_ACTOR,
        messageSource.getMessage(locale, WebMessageCode.ADD_ACTOR));
    localeMap.put(WebMessageCode.ADD_DIRECTOR,
        messageSource.getMessage(locale, WebMessageCode.ADD_DIRECTOR));
    localeMap.put(WebMessageCode.ADD_PRODUCER,
        messageSource.getMessage(locale, WebMessageCode.ADD_PRODUCER));
    localeMap.put(WebMessageCode.BY_COUNTRY,
        messageSource.getMessage(locale, WebMessageCode.BY_COUNTRY));
    localeMap.put(WebMessageCode.CHOOSE_TAG,
        messageSource.getMessage(locale, WebMessageCode.CHOOSE_TAG));
    localeMap.put(WebMessageCode.CHOOSE_GENRE,
        messageSource.getMessage(locale, WebMessageCode.CHOOSE_GENRE));
    localeMap.put(WebMessageCode.BY_TAG,
        messageSource.getMessage(locale, WebMessageCode.BY_TAG));
    localeMap.put(WebMessageCode.BY_GENRE,
        messageSource.getMessage(locale, WebMessageCode.BY_GENRE));
    localeMap.put(WebMessageCode.START_DATE_INTERVAL,
        messageSource.getMessage(locale, WebMessageCode.START_DATE_INTERVAL));
    localeMap.put(WebMessageCode.END_DATE_INTERVAL,
        messageSource.getMessage(locale, WebMessageCode.END_DATE_INTERVAL));
    localeMap.put(WebMessageCode.AFTER_DAY,
        messageSource.getMessage(locale, WebMessageCode.AFTER_DAY));
    localeMap.put(WebMessageCode.AFTER_MONTH,
        messageSource.getMessage(locale, WebMessageCode.AFTER_MONTH));
    localeMap.put(WebMessageCode.AFTER_YEAR,
        messageSource.getMessage(locale, WebMessageCode.AFTER_YEAR));
    localeMap.put(WebMessageCode.BEFORE_DAY,
        messageSource.getMessage(locale, WebMessageCode.BEFORE_DAY));
    localeMap.put(WebMessageCode.BEFORE_MONTH,
        messageSource.getMessage(locale, WebMessageCode.BEFORE_MONTH));
    localeMap.put(WebMessageCode.BEFORE_YEAR,
        messageSource.getMessage(locale, WebMessageCode.BEFORE_YEAR));
    localeMap.put(WebMessageCode.SEARCH_MOVIE_BY_CRITERIA,
        messageSource.getMessage(locale, WebMessageCode.SEARCH_MOVIE_BY_CRITERIA));
    localeMap.put(WebMessageCode.MOVIES_SEARCH_RESULT_HEADER,
        messageSource.getMessage(locale, WebMessageCode.MOVIES_SEARCH_RESULT_HEADER));
    localeMap.put(WebMessageCode.PROFILES_SEARCH_RESULT_HEADER,
        messageSource.getMessage(locale, WebMessageCode.PROFILES_SEARCH_RESULT_HEADER));

    return localeMap;
  }

  public Map<WebMessageCode, String> getMapForProfilePage(Locale locale) {
    Map<WebMessageCode, String> localeMap = new HashMap<>();
    prepareHeaderLabels(localeMap, locale);
    localeMap.put(WebMessageCode.CAREER,
        messageSource.getMessage(locale, WebMessageCode.CAREER));
    localeMap.put(WebMessageCode.ACTOR,
        messageSource.getMessage(locale, WebMessageCode.ACTOR));
    localeMap.put(WebMessageCode.DIRECTOR,
        messageSource.getMessage(locale, WebMessageCode.DIRECTOR));
    localeMap.put(WebMessageCode.PRODUCER,
        messageSource.getMessage(locale, WebMessageCode.PRODUCER));
    localeMap.put(WebMessageCode.BIRTH_DATE,
        messageSource.getMessage(locale, WebMessageCode.BIRTH_DATE));
    localeMap.put(WebMessageCode.AS_ACTOR,
        messageSource.getMessage(locale, WebMessageCode.AS_ACTOR));
    localeMap.put(WebMessageCode.AS_DIRECTOR,
        messageSource.getMessage(locale, WebMessageCode.AS_DIRECTOR));
    localeMap.put(WebMessageCode.AS_PRODUCER,
        messageSource.getMessage(locale, WebMessageCode.AS_PRODUCER));

    return localeMap;
  }

  public Map<WebMessageCode, String> getMapForMoviePage(Locale locale) {
    Map<WebMessageCode, String> localeMap = new HashMap<>();
    localeMap.put(WebMessageCode.COUNTRY,
        messageSource.getMessage(locale, WebMessageCode.COUNTRY));
    localeMap.put(WebMessageCode.PREMIER_DATE,
        messageSource.getMessage(locale, WebMessageCode.PREMIER_DATE));
    localeMap.put(WebMessageCode.TIME,
        messageSource.getMessage(locale, WebMessageCode.TIME));
    localeMap.put(WebMessageCode.MINUTES,
        messageSource.getMessage(locale, WebMessageCode.MINUTES));
    localeMap.put(WebMessageCode.GENRE,
        messageSource.getMessage(locale, WebMessageCode.GENRE));
    localeMap.put(WebMessageCode.TAGS,
        messageSource.getMessage(locale, WebMessageCode.TAGS));
    localeMap.put(WebMessageCode.ACTORS,
        messageSource.getMessage(locale, WebMessageCode.ACTORS));
    localeMap.put(WebMessageCode.DIRECTORS,
        messageSource.getMessage(locale, WebMessageCode.DIRECTORS));
    localeMap.put(WebMessageCode.PRODUCERS,
        messageSource.getMessage(locale, WebMessageCode.PRODUCERS));
    prepareHeaderLabels(localeMap, locale);
    return localeMap;
  }

  private void prepareHeaderLabels(Map<WebMessageCode, String> localeMap, Locale locale) {
    localeMap.put(WebMessageCode.SEARCH,
        messageSource.getMessage(locale, WebMessageCode.SEARCH));
    localeMap.put(WebMessageCode.HEADER,
        messageSource.getMessage(locale, WebMessageCode.HEADER));
  }
}
