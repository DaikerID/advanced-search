package com.films.search.advansed.diploma.search.entities;

import java.time.Duration;
import lombok.Data;

@Data
public class DurationInterval {

  private Duration min;
  private Duration max;
}
