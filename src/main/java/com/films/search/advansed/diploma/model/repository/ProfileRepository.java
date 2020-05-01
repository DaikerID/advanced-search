package com.films.search.advansed.diploma.model.repository;

import com.films.search.advansed.diploma.model.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
