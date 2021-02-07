package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Movie {
  private int movieId;
  private String movieName;
  private String movieGenre;
  private String movieUrl;
  private String moviePicUrl;
}
