package com.films.search.advansed.diploma.search.entities;

import static com.films.search.advansed.diploma.LocalDateTimeUtils.parseInterval;

import com.films.search.advansed.diploma.controller.form.AdvancedSearchForm;
import com.films.search.advansed.diploma.database.model.Genre;
import com.films.search.advansed.diploma.database.model.Tag;
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

  public static AdvancedSearchQuery build(AdvancedSearchForm advancedSearchForm) {

    //TODO transform with arrays
    return AdvancedSearchQuery.builder()
        .movieName(advancedSearchForm.getMovieName().trim())
        .countries(advancedSearchForm.getCountries().trim())
        .actorsName(advancedSearchForm.getActorsName().trim())
        .directorsName(advancedSearchForm.getDirectorsName().trim())
        .producersName(advancedSearchForm.getProducersName().trim())
        .genres(Genre.valueOf(advancedSearchForm.getGenres()))
        .tags(Tag.valueOf(advancedSearchForm.getTags()))
        .releaseDateLocalDateInterval(parseInterval(advancedSearchForm))
        .build();
  }
}
