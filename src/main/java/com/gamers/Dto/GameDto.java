package com.gamers.Dto;

import lombok.Data;

import java.util.Date;

@Data
public class GameDto {

    private String gameName;
    private Date gameReleaseDate;
    private Double price;
    private Double discountedPrice;
    private Double discount;
    private String genre;
    private String imagePath;
    private String gameType;
    private String gameCompatibility;
    private String edition;
    private Integer gameRating;

}
