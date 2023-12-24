package com.gamers.Entity;

import com.gamers.SequenceGenerators.GameIDSeqGenerator;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.Date;

@Entity
@Data
@Table(name = "TD_GAME_DETAILS")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gameIdGenerator")
    @GenericGenerator(
            name = "gameIdGenerator",
            strategy = "com.gamers.SequenceGenerators.GameIDSeqGenerator",
            parameters = {
            @Parameter(name = GameIDSeqGenerator.INCREMENT_PARAM,value = "1"),
            @Parameter(name = GameIDSeqGenerator.PREFIX_PARAM,value = "GAME_"),
            @Parameter(name = GameIDSeqGenerator.NUMBER_FORMAT_PARAM,value = "%05d")
    })
    @Column(name = "game_id", updatable = false , nullable = false)
    private String gameId;
    @Column(name = "game_name")
    private String gameName;
    @Column(name = "release_date")
    private Date gameReleaseDate;
    @Column(name = "price")
    private Double price;
    @Column(name = "discounted_price")
    private Double discountedPrice;
    @Column(name = "discount")
    private Double discount;
    @Column(name = "game_genre")
    private String genre;
    @Column(name = "image_path")
    private String imagePath;
    @Column(name = "game_type")
    private String gameType;
    @Column(name = "game_compatibility")
    private String gameCompatibility;
    @Column(name = "game_edition")
    private String edition;
    @Column(name = "game_rating")
    private Integer gameRating;
}
