package com.films.search.advansed.diploma.bootstrap;

import com.films.search.advansed.diploma.database.model.Genre;
import com.films.search.advansed.diploma.database.model.Movie;
import com.films.search.advansed.diploma.database.model.Profile;
import com.films.search.advansed.diploma.database.repository.MovieRepository;
import com.films.search.advansed.diploma.database.repository.ProfileRepository;
import java.time.LocalDate;
import java.util.Set;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Bootstrap implements CommandLineRunner {

  private ProfileRepository profileRepository;
  private MovieRepository movieRepository;

  @Override
  @Transactional
  public void run(String... args) throws Exception {
    initData();
  }

  private void initData() {

    Profile profile = Profile.builder()
        .id(1L)
        .birthDate(LocalDate.now())
        .name("Leonardo")
        .surname("Dicaprio")
        .build();

    profileRepository.save(profile);

    Movie survivorMovie = Movie.builder()
        .id(1L)
        .actors(Set.of(profile))
        .directors(Set.of(profile))
        .name("Survivor")
        .premierDate(LocalDate.now())
        .lengthInMinutes(130)
        .country("USA")
        .genres(Set.of(Genre.ADVENTURE, Genre.ACTION))
        .build();

    movieRepository.save(survivorMovie);
  }
}
