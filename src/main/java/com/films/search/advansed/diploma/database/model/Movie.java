package com.films.search.advansed.diploma.database.model;

import java.time.LocalDate;
import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Movie {

  @Id
  private Long id;
  private String name;
  private String country;
  private LocalDate premierDate;
  private Integer lengthInMinutes;

  @ElementCollection
  private Set<Genre> genres;

  @ElementCollection
  private Set<Tag> tags;

  @ManyToMany
  @JoinTable(name = "directors",
      joinColumns = {@JoinColumn(name = "movie_id")},
      inverseJoinColumns = {@JoinColumn(name = "profile_id")})
  private Set<Profile> directors;

  @ManyToMany
  @JoinTable(name = "actors",
      joinColumns = {@JoinColumn(name = "movie_id")},
      inverseJoinColumns = {@JoinColumn(name = "profile_id")})
  private Set<Profile> actors;

  @ManyToMany
  @JoinTable(name = "producers",
      joinColumns = {@JoinColumn(name = "movie_id")},
      inverseJoinColumns = {@JoinColumn(name = "profile_id")})
  private Set<Profile> producers;
}
