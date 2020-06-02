package com.films.search.advansed.diploma;

import com.films.search.advansed.diploma.controller.form.AdvancedSearchForm;
import com.films.search.advansed.diploma.search.entities.LocalDateInterval;
import java.time.LocalDate;
import java.time.Month;

public class LocalDateTimeUtils {

  public final static LocalDate FIRST_FILM_DATE = LocalDate.of(1895, 1, 1);
  private final static String NONE = "-";

  public static LocalDateInterval parseInterval(AdvancedSearchForm advancedSearchForm) {
    return new LocalDateInterval(getStartDate(advancedSearchForm), getEndDate(advancedSearchForm));
  }

  private static LocalDate getStartDate(AdvancedSearchForm advancedSearchForm) {
    LocalDate start;
    if ((advancedSearchForm.getReleaseDayStart().equals(NONE)
        || advancedSearchForm.getReleaseMonthStart().equals(NONE))
        && !advancedSearchForm.getReleaseYearStart().equals(NONE)) {
      start = LocalDate.of(Integer.parseInt(advancedSearchForm.getReleaseYearStart()), 1, 1);
    } else {
      start = parseDate(advancedSearchForm);
      if (start == null) {
        start = FIRST_FILM_DATE;
      }
    }
    return start;
  }

  private static LocalDate getEndDate(AdvancedSearchForm advancedSearchForm) {
    LocalDate end;
    if ((advancedSearchForm.getReleaseDayEnd().equals(NONE)
        || advancedSearchForm.getReleaseMonthEnd().equals(NONE))
        && !advancedSearchForm.getReleaseYearEnd().equals(NONE)) {
      end = LocalDate.of(Integer.parseInt(advancedSearchForm.getReleaseYearEnd()), 1, 1)
          .plusYears(1);
    } else {
      end = parseDate(advancedSearchForm);
      if (end == null) {
        end = LocalDate.now();
      }
    }
    return end;
  }

  private static LocalDate parseDate(AdvancedSearchForm advancedSearchForm) {
    LocalDate date;
    try {
      date = LocalDate.of(
          Integer.parseInt(advancedSearchForm.getReleaseYearStart()),
          Month.valueOf(advancedSearchForm.getReleaseMonthStart()),
          Integer.parseInt(advancedSearchForm.getReleaseDayStart()));
    } catch (Exception e) {
      date = null;
    }
    return date;
  }
}
