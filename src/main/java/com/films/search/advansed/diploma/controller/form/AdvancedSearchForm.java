package com.films.search.advansed.diploma.controller.form;

import lombok.Data;

@Data
public class AdvancedSearchForm {

  private String movieName;
  private String actorsName;
  private String directorsName;
  private String producersName;
  private String countries;
  private String tags;
  private String genres;
  private String releaseDayStart;
  private String releaseMonthStart;
  private String releaseYearStart;
  private String releaseDayEnd;
  private String releaseMonthEnd;
  private String releaseYearEnd;
}
