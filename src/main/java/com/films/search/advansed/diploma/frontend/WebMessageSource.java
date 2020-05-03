package com.films.search.advansed.diploma.frontend;

import java.util.Locale;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class WebMessageSource {
  private MessageSource messageSource;

  public String getMessage(WebMessageCode code, Object... args){
    return messageSource.getMessage(String.valueOf(code),args, Locale.getDefault());
  }
}
