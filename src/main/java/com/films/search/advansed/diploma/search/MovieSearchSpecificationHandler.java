package com.films.search.advansed.diploma.search;

import com.films.search.advansed.diploma.controller.form.AdvancedSearchQuery;
import com.films.search.advansed.diploma.database.model.Movie;
import java.time.LocalDateTime;
import org.springframework.data.jpa.domain.Specification;

public class MovieSearchSpecificationHandler {

  public static Specification<Movie> hasNameLike(AdvancedSearchQuery advancedSearchQuery) {
    return (Specification<Movie>) (root, query, cb) -> {
      if (advancedSearchQuery.getMovieName() != null) {
        return cb.like(root.get("name"), "%" + advancedSearchQuery.getMovieName() + "%");
      } else {
        return cb.equal(root.get("dummy"), "%");
      }
    };
  }

  public static Specification<Movie> hasCountryLike(AdvancedSearchQuery advancedSearchQuery) {
    return (Specification<Movie>) (root, query, cb) -> {
      if (advancedSearchQuery.getCountries() != null) {
        return cb.like(root.get("country"), "%" + advancedSearchQuery.getCountries() + "%");
      } else {
        return cb.equal(root.get("country"), "%");
      }
    };
  }

  public static Specification<Movie> hasPremierDateGreaterThan(
      AdvancedSearchQuery advancedSearchQuery) {
    return (Specification<Movie>) (root, query, cb) -> {
      if (advancedSearchQuery.getReleaseDateLocalDateInterval().getStart() != null) {
        return cb.greaterThan(root.get("premierDate"),
            advancedSearchQuery.getReleaseDateLocalDateInterval().getStart());
      } else {
        return cb.equal(root.get("country"), LocalDateTime.now().minusYears(200));
      }
    };
  }

  public static Specification<Movie> hasPremierDateLessThan(
      AdvancedSearchQuery advancedSearchQuery) {
    return (Specification<Movie>) (root, query, cb) -> cb.greaterThan(root.get("premierDate"),
        advancedSearchQuery.getReleaseDateLocalDateInterval().getStart());
  }


}