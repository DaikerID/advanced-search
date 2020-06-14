package com.films.search.advansed.diploma.search.utils;

import com.films.search.advansed.diploma.database.model.common.Movie;
import com.films.search.advansed.diploma.database.model.common.Profile;
import com.films.search.advansed.diploma.database.model.values.Genre;
import com.films.search.advansed.diploma.database.model.values.Tag;
import com.films.search.advansed.diploma.search.entities.AdvancedSearchQuery;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class MovieSearchSpecificationUtils {

  public static Specification<Movie> buildSpecification(AdvancedSearchQuery advancedSearchQuery) {
    return Specification.where(hasNameLike(advancedSearchQuery)
        .and(hasCountryLike(advancedSearchQuery)
            .and(hasPremierDateGreaterThan(advancedSearchQuery)
                .and(hasPremierDateLessThan(advancedSearchQuery)
                    .and(hasGenres(advancedSearchQuery)
                        .and(hasTags(advancedSearchQuery)
                            .and(hasActors(advancedSearchQuery)
                                .and(hasDirectors(advancedSearchQuery)
                                    .and(hasProducers(advancedSearchQuery)
                                    )))))))));
  }

  public static Specification<Movie> hasNameLike(String filter) {
    return (Specification<Movie>) (root, query, cb) -> {
      if (filter != null) {
        return cb.like(cb.upper(root.get("name")), "%" + filter.toUpperCase() + "%");
      }
      return cb.like(root.get("name"), "%");
    };
  }

  private static Specification<Movie> hasNameLike(AdvancedSearchQuery advancedSearchQuery) {
    return (Specification<Movie>) (root, query, cb) -> {
      if (advancedSearchQuery.getMovieName() != null) {
        return cb.like(cb.upper(root.get("name")),
            "%" + advancedSearchQuery.getMovieName().toUpperCase() + "%");
      }
      return cb.like(root.get("name"), "%");
    };
  }

  private static Specification<Movie> hasCountryLike(AdvancedSearchQuery advancedSearchQuery) {
    return (Specification<Movie>) (root, query, cb) -> {
      if (advancedSearchQuery.getCountries() != null) {
        return cb.like(cb.upper(root.get("country")),
            "%" + advancedSearchQuery.getCountries().toUpperCase() + "%");
      }
      return cb.like(root.get("country"), "%");
    };
  }

  private static Specification<Movie> hasPremierDateGreaterThan(
      AdvancedSearchQuery advancedSearchQuery) {
    return (Specification<Movie>) (root, query, cb) -> {
      if (advancedSearchQuery.getReleaseDateLocalDateInterval().getStart() != null) {
        return cb.greaterThanOrEqualTo(root.get("premierDate"),
            advancedSearchQuery.getReleaseDateLocalDateInterval().getStart());
      }
      return cb.greaterThanOrEqualTo(root.get("premierDate"), LocalDate.now().minusYears(200));

    };
  }

  private static Specification<Movie> hasPremierDateLessThan(
      AdvancedSearchQuery advancedSearchQuery) {
    return (Specification<Movie>) (root, query, cb) -> {
      if (advancedSearchQuery.getReleaseDateLocalDateInterval().getEnd() != null) {
        return cb.lessThanOrEqualTo(root.get("premierDate"),
            advancedSearchQuery.getReleaseDateLocalDateInterval().getEnd());
      }
      return cb.lessThan(root.get("premierDate"), LocalDate.now());

    };
  }

  private static Specification<Movie> hasGenres(AdvancedSearchQuery advancedSearchQuery) {
    return (Specification<Movie>) (root, query, cb) -> {
      Predicate predicate = null;
      for (Genre genre : advancedSearchQuery.getGenres()) {
        predicate = predicate == null ? cb.isMember(genre, root.get("genres")) :
            cb.and(predicate, cb.isMember(genre, root.get("genres")));
      }

      return predicate == null ? cb.like(root.get("name"), "%") : predicate;
    };
  }

  private static Specification<Movie> hasTags(AdvancedSearchQuery advancedSearchQuery) {
    return (Specification<Movie>) (root, query, cb) -> {
      Predicate predicate = null;
      for (Tag tag : advancedSearchQuery.getTags()) {
        predicate = predicate == null ? cb.isMember(tag, root.get("tags")) :
            cb.and(predicate, cb.isMember(tag, root.get("tags")));
      }
      return predicate == null ? cb.like(root.get("name"), "%") : predicate;
    };
  }

  private static Specification<Movie> hasActors(AdvancedSearchQuery advancedSearchQuery) {
    return (Specification<Movie>) (root, query, cb) ->
        hasProfiles(root, cb, "actors", advancedSearchQuery.getActors());
  }

  private static Specification<Movie> hasDirectors(AdvancedSearchQuery advancedSearchQuery) {
    return (Specification<Movie>) (root, query, cb) ->
        hasProfiles(root, cb, "directors", advancedSearchQuery.getDirectors());

  }

  private static Specification<Movie> hasProducers(AdvancedSearchQuery advancedSearchQuery) {
    return (Specification<Movie>) (root, query, cb) ->
        hasProfiles(root, cb, "producers", advancedSearchQuery.getProducers());
  }

  private static Predicate hasProfiles(Root<Movie> root, CriteriaBuilder cb,
      String joinName, Set<String> filters) {
    Predicate predicateForProfiles = null;
    for (String filter : filters) {
      predicateForProfiles = Objects.isNull(predicateForProfiles)
          ? hasProfile(root, cb, joinName, filter)
          : cb.and(predicateForProfiles, hasProfile(root, cb, joinName, filter));
    }
    return Objects.isNull(predicateForProfiles) ? cb.like(root.get("name"), "%")
        : predicateForProfiles;
  }

  private static Predicate hasProfile(Root<Movie> root, CriteriaBuilder cb, String joinName,
      String queryFilter) {
    final Join<Movie, Profile> profileJoin = root.join(joinName);
    if (queryFilter.contains(" ")) {
      String[] names = queryFilter.split(" ");
      if (names.length == 2) {
        return cb.and(nameProfileLike(cb, profileJoin, names[0]),
            surnameProfileLike(cb, profileJoin, names[1]));
      }
      Predicate anyLike = null;
      for (String filter : names) {
        anyLike = anyLike == null ? nameProfileLike(cb, profileJoin, filter)
            : cb.or(anyLike, nameProfileLike(cb, profileJoin, filter));

        anyLike = cb.or(anyLike, surnameProfileLike(cb, profileJoin, filter));
      }
      return anyLike;
    }
    return cb.or(nameProfileLike(cb, profileJoin, queryFilter),
        surnameProfileLike(cb, profileJoin, queryFilter));
  }

  private static Predicate nameProfileLike(CriteriaBuilder cb, Join<Movie, Profile> profileJoin,
      String filter) {
    return cb.like(cb.upper(profileJoin.get("name")),
        "%" + filter.toUpperCase() + "%");
  }

  private static Predicate surnameProfileLike(CriteriaBuilder cb, Join<Movie, Profile> profileJoin,
      String filter) {
    return cb.like(cb.upper(profileJoin.get("surname")),
        "%" + filter.toUpperCase() + "%");
  }
}