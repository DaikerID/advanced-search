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

  private final ProfileRepository profileRepository;
  private final MovieRepository movieRepository;

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
    Profile profile1 = Profile.builder()
        .id(2L)
        .birthDate(LocalDate.now())
        .name("2222")
        .surname("Dicaprio")
        .build();
    Profile profile2 = Profile.builder()
        .id(3L)
        .birthDate(LocalDate.now())
        .name("33333")
        .surname("Dicaprio")
        .build();

    profileRepository.save(profile);
    profileRepository.save(profile1);
    profileRepository.save(profile2);

    Movie survivorMovie = Movie.builder()
        .id(1L)
        .actors(Set.of(profile,profile1,profile2))
        .directors(Set.of(profile))
        .producers(Set.of(profile))
        .name("Survivor")
        .premierDate(LocalDate.now().minusYears(10))
        .lengthInMinutes(130)
        .country("USA")
        .genres(Set.of(Genre.ADVENTURE, Genre.COMEDY))
        .build();
    movieRepository.save(survivorMovie);

    Movie survivor2Movie = Movie.builder()
        .id(2L)
        .actors(Set.of(profile,profile2))
        .directors(Set.of(profile))
        .producers(Set.of(profile1))
        .name("Survivor2")
        .premierDate(LocalDate.now().minusYears(5))
        .lengthInMinutes(130)
        .country("Russia")
        .genres(Set.of(Genre.ADVENTURE, Genre.HORROR))
        .build();
    movieRepository.save(survivor2Movie);

    Movie survivor3Movie = Movie.builder()
        .id(3L)
        .actors(Set.of(profile1,profile2))
        .directors(Set.of(profile))
        .producers(Set.of(profile1))
        .name("Survivor3")
        .premierDate(LocalDate.now().minusYears(1))
        .lengthInMinutes(130)
        .country("USA")
        .genres(Set.of(Genre.ADVENTURE, Genre.ACTION))
        .build();
    movieRepository.save(survivor3Movie);
  }
}
