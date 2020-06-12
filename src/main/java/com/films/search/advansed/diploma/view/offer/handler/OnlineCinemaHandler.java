package com.films.search.advansed.diploma.view.offer.handler;

import com.films.search.advansed.diploma.view.offer.model.ViewOffer;

public abstract class OnlineCinemaHandler {

  protected static final String USER_AGENT = "Chrome/4.0.249.0 Safari/532.5";
  protected static final String REFERRER = "http://www.google.com";

  public abstract ViewOffer getViewOffer(String movieName);

}
