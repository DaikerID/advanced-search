package com.films.search.advansed.diploma.search.handler;

import com.films.search.advansed.diploma.database.model.Profile;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class ProfileSpecificationHandler {

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
}
