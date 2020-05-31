package com.films.search.advansed.diploma.database.repository;

import com.films.search.advansed.diploma.database.model.Profile;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProfileRepository extends JpaRepository<Profile, Long>, JpaSpecificationExecutor<Profile> {

  List<Profile> findAll(Specification<Profile> specification);
}
