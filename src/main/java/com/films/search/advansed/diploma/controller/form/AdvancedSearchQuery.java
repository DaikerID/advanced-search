package com.films.search.advansed.diploma.controller.form;

import com.films.search.advansed.diploma.controller.form.entities.DurationInterval;
import com.films.search.advansed.diploma.database.model.Genre;
import com.films.search.advansed.diploma.controller.form.entities.LocalDateInterval;
import com.films.search.advansed.diploma.database.model.Tag;
import java.util.List;
import lombok.Data;

@Data
public class AdvancedSearchQuery {

  private String movieName;
  private List<String> actorsName;
  private List<String> directorsName;
  private List<String> producersName;
  private List<String> countries;//???
  private List<Tag> tags;
  private List<Genre> genres;
  private LocalDateInterval releaseDateLocalDateInterval;
  private DurationInterval movieLengthDurationInterval;
}
