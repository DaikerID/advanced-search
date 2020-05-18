package com.films.search.advansed.diploma.frontend;

import com.films.search.advansed.diploma.database.model.Genre;
import com.films.search.advansed.diploma.database.model.Tag;
import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.persistence.Tuple;
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

  public Map<Genre, String> getGenresMap(Object... args) {
    Map<Genre, String> genreStringMap = new HashMap<>();
    for (Genre genre : Genre.values()) {
      genreStringMap
          .put(genre, messageSource.getMessage(genre.toString(), args, Locale.getDefault()));
    }
    return genreStringMap;
  }

  public Map<Tag, String> getTagsMap(Object... args) {
    Map<Tag, String> tagStringHashMap = new HashMap<>();
    for (Tag tag : Tag.values()) {
      tagStringHashMap
          .put(tag, messageSource.getMessage(tag.toString(), args, Locale.getDefault()));
    }
    return tagStringHashMap;
  }

  public Map<Month, String> getMonthsMap(Object... args) {
    Map<Month, String> monthStringHashMap = new HashMap<>();
    for (Month month : Month.values()) {
      monthStringHashMap
          .put(month, messageSource.getMessage(month.toString(), args, Locale.getDefault()));
    }
    return monthStringHashMap;
  }
}
