package com.films.search.advansed.diploma.database.service;

import static com.films.search.advansed.diploma.search.utils.ProfileSearchSpecificationUtils.*;

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

  public List<Profile> findAllProfilesByNameContains(String searchName, Specification<Profile> specification) {
    if (searchName.contains(" ")) {
      String[] names = searchName.split(" ");

      if (names.length == 2) {
        Set<Profile> profileSet = findAllByNameAndSurname(names[0], names[1], specification);
        if (profileSet.size() == 0) {
          profileSet.addAll(findAllByNameOrSurname(names[0], names[1], specification));
        }
        if (profileSet.size() == 0) {
          profileSet.addAll(findAllByEachWord(names, specification));
        }
        return new ArrayList<>(profileSet);

      } else {
        return new ArrayList<>(findAllByEachWord(names, specification));
      }
    }
    return new ArrayList<>(findAllByNameOrSurname(searchName, searchName, specification));
  }

  private Set<Profile> findAllByNameAndSurname(String name, String surname, Specification<Profile> specification) {
    return new HashSet<>(profileRepository.findAll(Specification
        .where(hasNameLike(name)
            .and(hasSurnameLike(surname)))));
  }

  private List<Profile> findAllByNameOrSurname(String name, String surname, Specification<Profile> specification) {
    return profileRepository.findAll(Specification
        .where(hasNameLike(name)
            .or(hasSurnameLike(surname))));
  }

  private List<Profile> findAllByEachWord(String[] filters, Specification<Profile> specification) {
    return profileRepository.findAll(hasNameOrSurnameContains(filters));
  }
}
