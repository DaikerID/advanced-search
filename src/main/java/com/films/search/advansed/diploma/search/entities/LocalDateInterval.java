package com.films.search.advansed.diploma.search.entities;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LocalDateInterval {

  private LocalDate start;
  private LocalDate end;
}
