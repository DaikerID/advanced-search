package com.films.search.advansed.diploma.search;

import com.films.search.advansed.diploma.database.model.Genre;
import com.films.search.advansed.diploma.database.model.Movie;
import com.films.search.advansed.diploma.database.model.Tag;
import com.films.search.advansed.diploma.search.entities.AdvancedSearchQuery;
import java.time.LocalDate;
import java.util.Set;
import org.springframework.data.jpa.domain.Specification;

public class MovieSearchSpecificationHandler {

  public static Specification<Movie> hasNameLike(AdvancedSearchQuery advancedSearchQuery) {
    return (Specification<Movie>) (root, query, cb) -> {
      if (advancedSearchQuery.getMovieName() != null) {
        return cb.like(root.get("name"), "%" + advancedSearchQuery.getMovieName() + "%");
      } else {
        return cb.like(root.get("name"), "%");
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
        return cb.greaterThanOrEqualTo(root.get("premierDate"), LocalDate.now().minusYears(200));
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
        return cb.lessThanOrEqualTo(root.get("premierDate"), LocalDate.now());
      }
    };
  }

  public static Specification<Movie> hasGenres(AdvancedSearchQuery advancedSearchQuery) {
    return (Specification<Movie>) (root, query, cb) -> {
      if (!advancedSearchQuery.getGenres().equals(Genre.NONE)) {
        return cb.isMember(advancedSearchQuery.getGenres(), root.get("genres"));
      } else {
        return cb.like(root.get("name"), "%");
      }
    };
  }

  public static Specification<Movie> hasTags(AdvancedSearchQuery advancedSearchQuery) {
    return (Specification<Movie>) (root, query, cb) -> {
      if (!advancedSearchQuery.getTags().equals(Tag.NONE)) {
        return cb.isMember(advancedSearchQuery.getTags(), root.get("tags"));
      } else {
        return cb.like(root.get("name"), "%");
      }
    };
  }

  public static Specification<Movie> hasGenres2(AdvancedSearchQuery advancedSearchQuery) {
    Set<Genre> genres = Set.of(advancedSearchQuery.getGenres(), Genre.ADVENTURE);
    return (Specification<Movie>) (root, query, cb) -> {
      if (!advancedSearchQuery.getGenres().equals(Genre.NONE)) {
        return cb.isMember(genres, root.get("genres"));
      } else {
        return cb.like(root.get("name"), "%");
      }
    };
  }

//  public static Specification<Movie> hasActor(AdvancedSearchQuery advancedSearchQuery) {
//    return (Specification<Movie>) (root, query, cb) -> {
//      if (!advancedSearchQuery.getGenres().equals(Genre.NONE)) {
//        cb.createQuery(Profile.class);
//        final Path<Genre> genres = root.<Genre> get("genres");
//        return genres.in(Set.of(advancedSearchQuery.getGenres(), Genre.ADVENTURE));
////        return cb.isMember(Set.of(advancedSearchQuery.getGenres(), Genre.ADVENTURE), root.get("genres"));
//      } else {
//        return cb.like(root.get("name"), "%");
//      }
//    };
}