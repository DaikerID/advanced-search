package com.films.search.advansed.diploma.database.service;

import com.films.search.advansed.diploma.database.model.Profile;
import com.films.search.advansed.diploma.database.repository.ProfileRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProfileService {

  private ProfileRepository profileRepository;

  public Optional<Profile> findById(Long profileId){
    return profileRepository.findById(profileId);
  }

  public List<Profile> findAll(){
    return profileRepository.findAll();
  }
}
