package com.films.search.advansed.diploma.search.entities;

import static com.films.search.advansed.diploma.search.utils.LocalDateUtils.parseInterval;

import com.films.search.advansed.diploma.controller.form.AdvancedSearchForm;
import com.films.search.advansed.diploma.database.model.values.Genre;
import com.films.search.advansed.diploma.database.model.values.Tag;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdvancedSearchQuery {

  private String movieName;
  private Set<String> actors;
  private Set<String> directors;
  private Set<String> producers;
  private String countries;
  private Set<Tag> tags;
  private Set<Genre> genres;
  private LocalDateInterval releaseDateLocalDateInterval;
  private DurationInterval movieLengthDurationInterval;

  public static AdvancedSearchQuery build(AdvancedSearchForm advancedSearchForm) {
    return AdvancedSearchQuery.builder()
        .movieName(advancedSearchForm.getMovieName().trim())
        .countries(advancedSearchForm.getCountries().trim())
        .actors(getNamesSet(advancedSearchForm.getActors()))
        .directors(getNamesSet(advancedSearchForm.getDirectors()))
        .producers(getNamesSet(advancedSearchForm.getProducers()))
        .genres(getGenreSet(advancedSearchForm))
        .tags(getTagSet(advancedSearchForm))
        .releaseDateLocalDateInterval(parseInterval(advancedSearchForm))
        .build();
  }

  private static Set<String> getNamesSet(String[] names) {
    Set<String> actors = new HashSet<>();
    if (names != null) {
      for (String actor : names) {
        if (!"".equals(actor)) {
          actors.add(actor.trim());
        }
      }
    }
    return actors;
  }

  private static Set<Tag> getTagSet(AdvancedSearchForm advancedSearchForm) {
    Set<Tag> tags = new HashSet<>();
    if (Objects.nonNull(advancedSearchForm.getTags())) {
      for (String tagString : advancedSearchForm.getTags()) {
        tags.add(Tag.valueOf(tagString));
      }
    }
    return tags;
  }

  private static Set<Genre> getGenreSet(AdvancedSearchForm advancedSearchForm) {
    Set<Genre> genres = new HashSet<>();
    if (Objects.nonNull(advancedSearchForm.getGenres())) {
      for (String genreString : advancedSearchForm.getGenres()) {
        genres.add(Genre.valueOf(genreString));
      }
    }
    return genres;
  }
}
