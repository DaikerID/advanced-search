package com.films.search.advansed.diploma.database.model.common;

import java.time.LocalDate;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
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
public class Profile {

  @Id
  private Long id;
  private String name;
  private String surname;
  private LocalDate birthDate;

  @ManyToMany(mappedBy = "directors")
  private Set<Movie> director;

  @ManyToMany(mappedBy = "actors")
  private Set<Movie> actor;

  @ManyToMany(mappedBy = "producers")
  private Set<Movie> producer;
}
