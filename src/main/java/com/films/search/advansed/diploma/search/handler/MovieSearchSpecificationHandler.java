package com.films.search.advansed.diploma.search.handler;

import com.films.search.advansed.diploma.database.model.Genre;
import com.films.search.advansed.diploma.database.model.Movie;
import com.films.search.advansed.diploma.database.model.Tag;
import com.films.search.advansed.diploma.search.entities.AdvancedSearchQuery;
import java.time.LocalDate;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class MovieSearchSpecificationHandler {

  public static Specification<Movie> hasNameLike(String filter) {
    return (Specification<Movie>) (root, query, cb) -> {
      if (filter != null) {
        return cb.like(cb.upper(root.get("name")), "%" + filter.toUpperCase() + "%");
      }
      return cb.like(root.get("name"), "%");
    };
  }

  public static Specification<Movie> hasNameLike(AdvancedSearchQuery advancedSearchQuery) {
    return (Specification<Movie>) (root, query, cb) -> {
      if (advancedSearchQuery.getMovieName() != null) {
        return cb.like(cb.upper(root.get("name")),
            "%" + advancedSearchQuery.getMovieName().toUpperCase() + "%");
      }
      return cb.like(root.get("name"), "%");
    };
  }

  public static Specification<Movie> hasCountryLike(AdvancedSearchQuery advancedSearchQuery) {
    return (Specification<Movie>) (root, query, cb) -> {
      if (advancedSearchQuery.getCountries() != null) {
        return cb.like(cb.upper(root.get("country")),
            "%" + advancedSearchQuery.getCountries().toUpperCase() + "%");
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
    return (Specification<Movie>) (root, query, cb) -> {
        Predicate predicate = null;
        for (Genre genre : advancedSearchQuery.getGenres()) {
          predicate = predicate == null ? cb.isMember(genre, root.get("genres")) :
              cb.and(predicate, cb.isMember(genre, root.get("genres")));
        }

      return predicate == null ? cb.like(root.get("name"), "%") : predicate;
    };
  }

  public static Specification<Movie> hasTags(AdvancedSearchQuery advancedSearchQuery) {
    return (Specification<Movie>) (root, query, cb) -> {
      Predicate predicate = null;
      for (Tag tag : advancedSearchQuery.getTags()) {
        predicate = predicate == null ? cb.isMember(tag, root.get("tags")) :
            cb.and(predicate, cb.isMember(tag, root.get("tags")));
      }
      return predicate == null ? cb.like(root.get("name"), "%") : predicate;
    };
  }
}