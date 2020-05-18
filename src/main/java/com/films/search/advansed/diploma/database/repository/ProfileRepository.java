package com.films.search.advansed.diploma.database.repository;

import com.films.search.advansed.diploma.database.model.Profile;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

  Set<Profile> findAllByNameContainsAndSurnameContains(String name, String surname);

  Set<Profile> findAllByNameContainsOrSurnameContains(String name, String surname);
}
