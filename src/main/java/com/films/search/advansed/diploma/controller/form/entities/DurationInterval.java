package com.films.search.advansed.diploma.controller.form.entities;

import java.time.Duration;
import lombok.Data;

@Data
public class DurationInterval {

  private Duration min;
  private Duration max;
}
