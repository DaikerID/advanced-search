package com.films.search.advansed.diploma.search;

import com.films.search.advansed.diploma.database.model.Genre;
import com.films.search.advansed.diploma.database.model.Movie;
import com.films.search.advansed.diploma.database.model.Tag;
import com.films.search.advansed.diploma.search.entities.AdvancedSearchQuery;
import java.time.LocalDate;
import java.util.Set;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class MovieSearchSpecificationHandler {

  public static Specification<Movie> hasNameLike(AdvancedSearchQuery advancedSearchQuery) {
    return (Specification<Movie>) (root, query, cb) -> {
      if (advancedSearchQuery.getMovieName() != null) {
        return cb.like(root.get("name"), "%" + advancedSearchQuery.getMovieName() + "%");
      }
      return cb.like(root.get("name"), "%");
    };
  }

  public static Specification<Movie> hasCountryLike(AdvancedSearchQuery advancedSearchQuery) {
    return (Specification<Movie>) (root, query, cb) -> {
      if (advancedSearchQuery.getCountries() != null) {
        return cb.like(root.get("country"), "%" + advancedSearchQuery.getCountries() + "%");
      }
      return cb.like(root.get("country"), "%");
    };
  }

  public static Specification<Movie> hasPremierDateGreaterThan(
      AdvancedSearchQuery advancedSearchQuery) {
    return (Specification<Movie>) (root, query, cb) -> {
      if (advancedSearchQuery.getReleaseDateLocalDateInterval().getStart() != null) {
        return cb.greaterThanOrEqualTo(root.get("premierDate"),
            advancedSearchQuery.getReleaseDateLocalDateInterval().getStart());
      }
      return cb.greaterThanOrEqualTo(root.get("premierDate"), LocalDate.now().minusYears(200));

    };
  }

  public static Specification<Movie> hasPremierDateLessThan(
      AdvancedSearchQuery advancedSearchQuery) {
    return (Specification<Movie>) (root, query, cb) -> {
      if (advancedSearchQuery.getReleaseDateLocalDateInterval().getEnd() != null) {
        return cb.lessThanOrEqualTo(root.get("premierDate"),
            advancedSearchQuery.getReleaseDateLocalDateInterval().getEnd());
      }
      return cb.lessThan(root.get("premierDate"), LocalDate.now());

    };
  }

  public static Specification<Movie> hasGenres(AdvancedSearchQuery advancedSearchQuery) {
    //TODO refactor this
    Set<Genre> genres = Set.of(advancedSearchQuery.getGenres());
    return (Specification<Movie>) (root, query, cb) -> {
      if (!advancedSearchQuery.getGenres().equals(Genre.NONE)) {
        Predicate predicate = null;
        for (Genre genre : genres) {
          predicate = predicate == null ? cb.isMember(genre, root.get("genres")) :
              cb.and(predicate, cb.isMember(genre, root.get("genres")));
        }
        return predicate;
      }
      return cb.like(root.get("name"), "%");
    };
  }

  public static Specification<Movie> hasTags(AdvancedSearchQuery advancedSearchQuery) {
    //TODO refactor this
    Set<Tag> tags = Set.of(advancedSearchQuery.getTags());
    return (Specification<Movie>) (root, query, cb) -> {
      if (!advancedSearchQuery.getTags().equals(Tag.NONE)) {
        Predicate predicate = null;
        for (Tag genre : tags) {
          predicate = predicate == null ? cb.isMember(genre, root.get("tags")) :
              cb.and(predicate, cb.isMember(genre, root.get("tags")));
        }
        return predicate;
      }
      return cb.like(root.get("name"), "%");
    };
  }
}