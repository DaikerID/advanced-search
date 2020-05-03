package com.films.search.advansed.diploma.model.entity;

import java.util.List;
import java.util.Set;
import javax.persistence.*;
import lombok.*;

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
  private String birthDate;
}
