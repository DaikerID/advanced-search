package com.films.search.advansed.diploma.database.service;

import com.films.search.advansed.diploma.database.model.Profile;
import com.films.search.advansed.diploma.database.repository.ProfileRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lombok.AllArgsConstructor;
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
      String names[] = searchName.split(" ");
      if (names.length == 2) {
        return new ArrayList<>(
            profileRepository.findAllByNameContainsAndSurnameContains(names[0], names[1]));
      } else {
        Set<Profile> profileHashSet = new HashSet<>();
        for (String currentName : names) {
          profileHashSet.addAll(
              profileRepository.findAllByNameContainsOrSurnameContains(currentName, currentName));
        }
        return new ArrayList<>(profileHashSet);
      }
    }
    return new ArrayList<>(
        profileRepository.findAllByNameContainsOrSurnameContains(searchName, searchName));
  }
}
