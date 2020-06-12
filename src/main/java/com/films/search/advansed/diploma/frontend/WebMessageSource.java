package com.films.search.advansed.diploma.frontend;

import com.films.search.advansed.diploma.database.model.values.Genre;
import com.films.search.advansed.diploma.database.model.values.Tag;
import java.time.Month;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class WebMessageSource {

  private MessageSource messageSource;

  public String getMessage(WebMessageCode code, Object... args) {
    return messageSource.getMessage(code.toString(), args, Locale.getDefault());
  }

  public String getMessage(Locale locale, WebMessageCode code, Object... args) {
    return messageSource.getMessage(code.toString(), args, locale);
  }

  public Map<Genre, String> getGenresMap(Locale locale, Object... args) {
    Map<Genre, String> genreStringMap = new HashMap<>();
    for (Genre genre : Genre.values()) {
      genreStringMap
          .put(genre, messageSource.getMessage(genre.toString(), args, locale));
    }
    return genreStringMap;
  }

  public Map<Tag, String> getTagsMap(Locale locale, Object... args) {
    Map<Tag, String> tagStringHashMap = new HashMap<>();
    for (Tag tag : Tag.values()) {
      tagStringHashMap
          .put(tag, messageSource.getMessage(tag.toString(), args, locale));
    }
    return tagStringHashMap;
  }

  public Map<Month, String> getMonthsMap(Locale locale, Object... args) {
    Map<Month, String> monthStringHashMap = new HashMap<>();
    for (Month month : Month.values()) {
      monthStringHashMap.put(month, messageSource.getMessage(month.toString(), args, locale));
    }
    return monthStringHashMap;
  }
}
