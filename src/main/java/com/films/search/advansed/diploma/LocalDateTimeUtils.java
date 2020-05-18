package com.films.search.advansed.diploma;

import com.films.search.advansed.diploma.controller.form.AdvancedSearchForm;
import com.films.search.advansed.diploma.controller.form.entities.LocalDateInterval;
import java.time.LocalDate;
import java.time.Month;
import java.util.Objects;

public class LocalDateTimeUtils {

  private final static String NONE = "-";

  public static LocalDateInterval parseInterval(AdvancedSearchForm advancedSearchForm) {
    LocalDate start;
    try {
      start = LocalDate.of(
          Integer.parseInt(advancedSearchForm.getReleaseYearStart()),
          Month.valueOf(advancedSearchForm.getReleaseMonthStart()),
          Integer.parseInt(advancedSearchForm.getReleaseDayStart()));
    } catch (Exception e) {
      start = null;
    }
    if (advancedSearchForm.getReleaseDayStart().equals(NONE)
        && advancedSearchForm.getReleaseMonthStart().equals(NONE)
        && !advancedSearchForm.getReleaseYearStart().equals(NONE)
    ) {
      start = LocalDate.of(Integer.parseInt(advancedSearchForm.getReleaseYearStart()), 1, 1);
    }

    LocalDate end;
    try {
      end = LocalDate.of(
          Integer.parseInt(advancedSearchForm.getReleaseYearStart()),
          Month.valueOf(advancedSearchForm.getReleaseMonthStart()),
          Integer.parseInt(advancedSearchForm.getReleaseDayStart()));
    } catch (Exception e) {
      end = Objects.isNull(start) ? null : LocalDate.now();
    }

    if (advancedSearchForm.getReleaseDayEnd().equals(NONE)
        && advancedSearchForm.getReleaseMonthEnd().equals(NONE)
        && !advancedSearchForm.getReleaseYearStart().equals(NONE)
    ) {
      end = LocalDate.of(Integer.parseInt(advancedSearchForm.getReleaseYearEnd()), 1, 1);
    }

    return new LocalDateInterval(start, end);
  }
}
