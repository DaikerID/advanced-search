package com.films.search.advansed.diploma.database.service;

import static com.films.search.advansed.diploma.search.handler.ProfileSpecificationHandler.*;

import com.films.search.advansed.diploma.database.model.Profile;
import com.films.search.advansed.diploma.database.repository.ProfileRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProfileService {

  private ProfileRepository profileRepository;

  public Optional<Profile> findById(Long profileId) {
    return profileRepository.findById(profileId);
  }

  public List<Profile> findAllProfilesByNameContains(String searchName) {
    if (searchName.contains(" ")) {
      String[] names = searchName.split(" ");

      if (names.length == 2) {
        Set<Profile> profileSet = findAllByNameAndSurname(names[0], names[1]);
        if (profileSet.size() == 0) {
          profileSet.addAll(findAllByNameOrSurname(names[0], names[1]));
        }
        if (profileSet.size() == 0) {
          profileSet.addAll(findByEachWord(names));
        }
        return new ArrayList<>(profileSet);

      } else {
        return new ArrayList<>(findByEachWord(names));
      }
    }
    return new ArrayList<>(findAllByNameOrSurname(searchName, searchName));
  }

  private Set<Profile> findAllByNameAndSurname(String name, String surname) {
    return new HashSet<>(profileRepository.findAll(Specification
        .where(hasNameLike(name)
            .and(hasSurnameLike(surname)))));
  }

  private Set<Profile> findAllByNameOrSurname(String name, String surname) {
    return new HashSet<>(profileRepository.findAll(Specification
        .where(hasNameLike(name)
            .or(hasSurnameLike(surname)))));
  }

  private Set<Profile> findByEachWord(String[] filters) {
    Set<Profile> profileHashSet = new HashSet<>();
    for (String currentName : filters) {
      profileHashSet.addAll(
          profileRepository.findAll(Specification
              .where(hasNameLike(currentName)
                  .or(hasSurnameLike(currentName)))));
    }
    return profileHashSet;
  }
}
