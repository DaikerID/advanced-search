package com.films.search.advansed.diploma.view.offer.service;

import com.films.search.advansed.diploma.view.offer.handler.OnlineCinemaHandler;
import com.films.search.advansed.diploma.view.offer.model.ViewOffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ViewOfferService {

  private final List<OnlineCinemaHandler> onlineCinemas;

  public List<ViewOffer> getOffersToWatch(String movieName) {
    List<ViewOffer> viewOffers = new ArrayList<>();
    onlineCinemas.forEach(onlineCinemaHandler -> {
      ViewOffer viewOffer = onlineCinemaHandler.getViewOffer(movieName);
      if (Objects.nonNull(viewOffer)){
        viewOffers.add(viewOffer);
      }
    });
    return viewOffers;
  }
}
