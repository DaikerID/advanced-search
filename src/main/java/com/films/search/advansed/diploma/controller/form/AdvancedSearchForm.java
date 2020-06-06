package com.films.search.advansed.diploma.controller.form;

import lombok.Data;

@Data
public class AdvancedSearchForm {

  private String movieName;
  private String[] actors;
  private String[] directors;
  private String[] producers;
  private String countries;
  private String[] tags;
  private String[] genres;
  private String releaseDayStart;
  private String releaseMonthStart;
  private String releaseYearStart;
  private String releaseDayEnd;
  private String releaseMonthEnd;
  private String releaseYearEnd;
}
