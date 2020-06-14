package com.films.search.advansed.diploma.search.utils;

import com.films.search.advansed.diploma.database.model.common.Profile;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class ProfileSearchSpecificationUtils {

  public static Specification<Profile> hasNameLike(String filter) {
    return (Specification<Profile>) (root, query, cb) -> {
      if (filter != null) {
        return cb.like(cb.upper(root.get("name")), "%" + filter.toUpperCase() + "%");
      }
      return cb.like(root.get("name"), "%");
    };
  }

  public static Specification<Profile> hasSurnameLike(String filter) {
    return (Specification<Profile>) (root, query, cb) -> {
      if (filter != null) {
        return cb.like(cb.upper(root.get("surname")), "%" + filter.toUpperCase() + "%");
      }
      return cb.like(root.get("surname"), "%");
    };
  }

  public static Specification<Profile> hasNameOrSurnameContains(String[] filters) {

    return (Specification<Profile>) (root, query, cb) -> {
      if (filters != null && filters.length > 0) {
        Predicate predicate = null;
        for (String filter : filters) {
          predicate = predicate == null ?
              cb.like(cb.upper(root.get("name")), "%" + filter.toUpperCase() + "%") :
              cb.or(predicate,
                  cb.like(cb.upper(root.get("name")), "%" + filter.toUpperCase() + "%"));

          predicate = cb.or(predicate,
              cb.like(cb.upper(root.get("surname")), "%" + filter.toUpperCase() + "%"));
        }
        return predicate;
      }
      return cb.like(root.get("name"), "%");
    };
  }

  public static Specification<Profile> isAnyone() {
    return Specification.where(isActor()).or(isDirector().or(isProducer()));
  }

  public static Specification<Profile> isActor() {
    return (Specification<Profile>) (root, query, cb) -> cb.greaterThan(cb.size(root.get("actor")), 0);
  }

  public static Specification<Profile> isProducer() {
    return (Specification<Profile>) (root, query, cb) -> cb.greaterThan(cb.size(root.get("producer")), 0);
  }

  public static Specification<Profile> isDirector() {
    return (Specification<Profile>) (root, query, cb) -> cb.greaterThan(cb.size(root.get("director")), 0);
  }
}
