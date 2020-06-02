package com.films.search.advansed.diploma.search.entities;

import static com.films.search.advansed.diploma.LocalDateTimeUtils.parseInterval;

import com.films.search.advansed.diploma.controller.form.AdvancedSearchForm;
import com.films.search.advansed.diploma.database.model.Genre;
import com.films.search.advansed.diploma.database.model.Tag;
import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdvancedSearchQuery {

  private static final String NONE = "-";

  private String movieName;
  private String actorsName;
  private String directorsName;
  private String producersName;
  private String countries;
  private Set<Tag> tags;
  private Set<Genre> genres;
  private LocalDateInterval releaseDateLocalDateInterval;
  private DurationInterval movieLengthDurationInterval;

  public static AdvancedSearchQuery build(AdvancedSearchForm advancedSearchForm) {
    //TODO transform with arrays for actors, producers, directors
    return AdvancedSearchQuery.builder()
        .movieName(advancedSearchForm.getMovieName().trim())
        .countries(advancedSearchForm.getCountries().trim())
        .actorsName(advancedSearchForm.getActorsName().trim())
        .directorsName(advancedSearchForm.getDirectorsName().trim())
        .producersName(advancedSearchForm.getProducersName().trim())
        .genres(getGenreSet(advancedSearchForm))
        .tags(getTagSet(advancedSearchForm))
        .releaseDateLocalDateInterval(parseInterval(advancedSearchForm))
        .build();
  }

  private static Set<Tag> getTagSet(AdvancedSearchForm advancedSearchForm) {
    Set<Tag> tags = new HashSet<>();
    for (String tagString : advancedSearchForm.getTags()) {
      if (!tagString.equals(NONE)) {
        tags.add(Tag.valueOf(tagString));
      }
    }
    return tags;
  }

  private static Set<Genre> getGenreSet(AdvancedSearchForm advancedSearchForm) {
    Set<Genre> genres = new HashSet<>();
    for (String genreString : advancedSearchForm.getGenres()) {
      if (!genreString.equals(NONE)) {
        genres.add(Genre.valueOf(genreString));
      }
    }
    return genres;
  }
}
