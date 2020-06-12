package com.films.search.advansed.diploma.view.offer.model;

import com.films.search.advansed.diploma.database.model.common.OnlineCinema;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class ViewOffer {

  @ManyToOne
  OnlineCinema cinema;
  String linkToMovie;
  String price;
  PriceType priceType;
}
