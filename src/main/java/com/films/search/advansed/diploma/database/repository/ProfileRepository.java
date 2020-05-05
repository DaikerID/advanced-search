package com.films.search.advansed.diploma.database.repository;

import com.films.search.advansed.diploma.database.model.Profile;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

  Optional<Profile> findAllByNameContainsAndSurnameContains(String name, String surname);
}
