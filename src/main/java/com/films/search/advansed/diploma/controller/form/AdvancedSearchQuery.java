package com.films.search.advansed.diploma.controller.form;

import com.films.search.advansed.diploma.controller.form.entities.DurationInterval;
import com.films.search.advansed.diploma.database.model.Genre;
import com.films.search.advansed.diploma.controller.form.entities.LocalDateInterval;
import com.films.search.advansed.diploma.database.model.Tag;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdvancedSearchQuery {

  private String movieName;
  private String actorsName;
  private String directorsName;
  private String producersName;
  private String countries;
  private Tag tags;
  private Genre genres;
  private LocalDateInterval releaseDateLocalDateInterval;
  private DurationInterval movieLengthDurationInterval;
}
