package com.films.search.advansed.diploma.model.entity;

import java.util.List;
import java.util.Set;
import javax.persistence.*;
import lombok.*;
import java.time.LocalDate;

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
  private Integer length;

  @ElementCollection
  private List<Genre> genres;

  @ElementCollection
  private List<Tag> tags;

  @ManyToMany
  @JoinTable(name = "movie_directors",
      joinColumns = {@JoinColumn(name = "movie_id")},
      inverseJoinColumns = {@JoinColumn(name = "profile_id")} )
  private Set<Profile> directors;

  @ManyToMany
  @JoinTable(name = "movie_actors",
      joinColumns = {@JoinColumn(name = "movie_id")},
      inverseJoinColumns = {@JoinColumn(name = "profile_id")} )
  private Set<Profile> actors;

  @ManyToMany
  @JoinTable(name = "movie_producers",
      joinColumns = {@JoinColumn(name = "movie_id")},
      inverseJoinColumns = {@JoinColumn(name = "profile_id")} )
  private Set<Profile> producers;
}
