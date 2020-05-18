package com.films.search.advansed.diploma.search;

import com.films.search.advansed.diploma.search.entities.AdvancedSearchQuery;
import com.films.search.advansed.diploma.database.model.Movie;
import java.time.LocalDate;
import org.springframework.data.jpa.domain.Specification;

public class MovieSearchSpecificationHandler {

  public static Specification<Movie> hasNameLike(AdvancedSearchQuery advancedSearchQuery) {
    return (Specification<Movie>) (root, query, cb) -> {
      if (advancedSearchQuery.getMovieName() != null) {
        return cb.like(root.get("name"), "%" + advancedSearchQuery.getMovieName() + "%");
      } else {
        return cb.like(root.get("dummy"), "%");
      }
    };
  }

  public static Specification<Movie> hasCountryLike(AdvancedSearchQuery advancedSearchQuery) {
    return (Specification<Movie>) (root, query, cb) -> {
      if (advancedSearchQuery.getCountries() != null) {
        return cb.like(root.get("country"), "%" + advancedSearchQuery.getCountries() + "%");
      } else {
        return cb.like(root.get("country"), "%");
      }
    };
  }

  public static Specification<Movie> hasPremierDateGreaterThan(
      AdvancedSearchQuery advancedSearchQuery) {
    return (Specification<Movie>) (root, query, cb) -> {
      if (advancedSearchQuery.getReleaseDateLocalDateInterval().getStart() != null) {
        return cb.greaterThanOrEqualTo(root.get("premierDate"),
            advancedSearchQuery.getReleaseDateLocalDateInterval().getStart());
      } else {
        return cb.greaterThanOrEqualTo(root.get("country"), LocalDate.now().minusYears(200));
      }
    };
  }

  public static Specification<Movie> hasPremierDateLessThan(
      AdvancedSearchQuery advancedSearchQuery) {
    return (Specification<Movie>) (root, query, cb) -> {
      if (advancedSearchQuery.getReleaseDateLocalDateInterval().getEnd() != null) {
        return cb.lessThanOrEqualTo(root.get("premierDate"),
            advancedSearchQuery.getReleaseDateLocalDateInterval().getEnd());
      } else {
        return cb.lessThanOrEqualTo(root.get("country"), LocalDate.now());
      }
    };
  }


}