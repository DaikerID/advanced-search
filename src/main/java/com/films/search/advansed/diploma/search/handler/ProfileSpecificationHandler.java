package com.films.search.advansed.diploma.search.handler;

import com.films.search.advansed.diploma.database.model.Profile;
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
}
