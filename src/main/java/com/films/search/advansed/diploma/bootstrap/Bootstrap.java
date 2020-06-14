package com.films.search.advansed.diploma.bootstrap;

import com.films.search.advansed.diploma.database.model.common.Movie;
import com.films.search.advansed.diploma.database.model.common.Profile;
import com.films.search.advansed.diploma.database.model.values.Genre;
import com.films.search.advansed.diploma.database.model.values.Tag;
import com.films.search.advansed.diploma.database.repository.MovieRepository;
import com.films.search.advansed.diploma.database.repository.ProfileRepository;
import java.time.LocalDate;
import java.util.Set;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {

  private final ProfileRepository profileRepository;
  private final MovieRepository movieRepository;
  private static Long id = 0L;

  Profile robertDauniJR = Profile.builder().id(getNextId()).birthDate(LocalDate.now())
      .name("Роберт").surname("Дауни Младший").build();
  Profile crisHamsfort = Profile.builder().id(getNextId()).birthDate(LocalDate.now())
      .name("Крис").surname("Хемсворт").build();
  Profile crisEvans = Profile.builder().id(getNextId()).birthDate(LocalDate.now())
      .name("Крис").surname("Эванс").build();
  Profile jonatanRusso = Profile.builder().id(getNextId()).birthDate(LocalDate.now())
      .name("Джонатан").surname("Руссо").build();
  Profile saimonPegg = Profile.builder().id(getNextId()).birthDate(LocalDate.now())
      .name("Cаймон").surname("Пегг").build();
  Profile edgarWright = Profile.builder().id(getNextId()).birthDate(LocalDate.now())
      .name("Эдгар").surname("Райт").build();
  Profile nickFrost = Profile.builder().id(getNextId()).birthDate(LocalDate.now())
      .name("Ник").surname("Фрост").build();

  Movie ironMan = Movie.builder()
      .id(getNextId())
      .actors(Set.of(robertDauniJR))
      .directors(Set.of(jonatanRusso))
      .producers(Set.of(jonatanRusso))
      .name("Железный человек")
      .premierDate(LocalDate.of(2008, 5, 5))
      .lengthInMinutes(130)
      .country("США")
      .genres(Set.of(Genre.ACTION, Genre.COMEDY))
      .tags(Set.of(Tag.MARVEL_UNIVERSE, Tag.IRON_MAN))
      .build();

  Movie thor = Movie.builder()
      .id(getNextId())
      .actors(Set.of(crisHamsfort))
      .directors(Set.of(jonatanRusso))
      .producers(Set.of(jonatanRusso))
      .name("Тор")
      .premierDate(LocalDate.of(2010, 5, 5))
      .lengthInMinutes(130)
      .country("США")
      .genres(Set.of(Genre.ACTION, Genre.COMEDY))
      .tags(Set.of(Tag.MARVEL_UNIVERSE))
      .build();

  Movie firstAvenger = Movie.builder()
      .id(getNextId())
      .actors(Set.of(crisEvans))
      .directors(Set.of(jonatanRusso))
      .producers(Set.of(jonatanRusso))
      .name("Первый мститель")
      .premierDate(LocalDate.of(2011, 5, 5))
      .lengthInMinutes(130)
      .country("США")
      .genres(Set.of(Genre.ACTION, Genre.COMEDY))
      .tags(Set.of(Tag.MARVEL_UNIVERSE))
      .build();

  Movie avengers = Movie.builder()
      .id(getNextId())
      .actors(Set.of(robertDauniJR, crisHamsfort, crisEvans))
      .directors(Set.of(jonatanRusso))
      .producers(Set.of(jonatanRusso))
      .name("Мстители")
      .premierDate(LocalDate.of(2012, 5, 5))
      .lengthInMinutes(130)
      .country("США")
      .genres(Set.of(Genre.ACTION, Genre.COMEDY))
      .tags(Set.of(Tag.MARVEL_UNIVERSE, Tag.IRON_MAN))
      .build();

  Movie avengers2 = Movie.builder()
      .id(getNextId())
      .actors(Set.of(robertDauniJR, crisHamsfort, crisEvans))
      .directors(Set.of(jonatanRusso))
      .producers(Set.of(jonatanRusso))
      .name("Мстители 2: Эра Альтрона")
      .premierDate(LocalDate.of(2014, 5, 5))
      .lengthInMinutes(130)
      .country("США")
      .genres(Set.of(Genre.ACTION, Genre.COMEDY))
      .tags(Set.of(Tag.MARVEL_UNIVERSE, Tag.IRON_MAN))
      .build();

  Movie worldsEnd = Movie.builder()
      .id(getNextId())
      .actors(Set.of(saimonPegg, nickFrost))
      .directors(Set.of(edgarWright))
      .producers(Set.of(edgarWright))
      .name("Армагеддец")
      .premierDate(LocalDate.of(2014, 5, 5))
      .lengthInMinutes(130)
      .country("Великобритания")
      .genres(Set.of(Genre.ACTION, Genre.COMEDY))
      .tags(Set.of(Tag.TRIOLOGY_OF_CORNETTO))
      .build();
  Movie coolPolicemans = Movie.builder()
      .id(getNextId())
      .actors(Set.of(saimonPegg, nickFrost, robertDauniJR))
      .directors(Set.of(edgarWright))
      .producers(Set.of(edgarWright))
      .name("Типа крутые легавые")
      .premierDate(LocalDate.of(2012, 5, 5))
      .lengthInMinutes(130)
      .country("Великобритания")
      .genres(Set.of(Genre.ACTION, Genre.COMEDY))
      .tags(Set.of(Tag.TRIOLOGY_OF_CORNETTO))
      .build();
  Movie zombieShon = Movie.builder()
      .id(getNextId())
      .actors(Set.of(saimonPegg, nickFrost, crisEvans))
      .directors(Set.of(edgarWright))
      .producers(Set.of(edgarWright))
      .name("Зомби по имени Шон")
      .premierDate(LocalDate.of(2008, 5, 5))
      .lengthInMinutes(130)
      .country("Великобритания")
      .genres(Set.of(Genre.ACTION, Genre.COMEDY))
      .tags(Set.of(Tag.TRIOLOGY_OF_CORNETTO))
      .build();

  @Override
  @Transactional
  public void run(String... args) throws Exception {
    initProfiles();
    initMovies();
  }

  private void initProfiles() {
    robertDauniJR = profileRepository.save(robertDauniJR);
    crisHamsfort = profileRepository.save(crisHamsfort);
    crisEvans = profileRepository.save(crisEvans);
    jonatanRusso = profileRepository.save(jonatanRusso);
    saimonPegg = profileRepository.save(saimonPegg);
    edgarWright = profileRepository.save(edgarWright);
    nickFrost = profileRepository.save(nickFrost);
  }

  private void initMovies() {
    ironMan = movieRepository.save(ironMan);
    thor = movieRepository.save(thor);
    firstAvenger = movieRepository.save(firstAvenger);
    avengers = movieRepository.save(avengers);
    avengers2 =  movieRepository.save(avengers2);
    worldsEnd = movieRepository.save(worldsEnd);
    coolPolicemans = movieRepository.save(coolPolicemans);
    zombieShon = movieRepository.save(zombieShon);
  }


  private static Long getNextId() {
    id += 1;
    return id;
  }
}

