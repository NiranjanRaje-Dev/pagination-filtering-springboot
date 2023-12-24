package com.gamers.Controller;

import com.gamers.Dto.GameDto;
import com.gamers.Entity.Game;
import com.gamers.Service.GameService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*", maxAge = 3600)
@RequestMapping("/api/v1")
public class GameController {

    @Autowired
    GameService gameService;

    @PostMapping("/game/addGame")
    public GameDto addGame(@RequestBody GameDto game){
        return gameService.addGame(game);
    }

    @GetMapping("/game")
    public List<GameDto> getGames(@RequestParam Integer limit, @RequestParam Integer offset){
        return gameService.getGames(limit,offset);
    }

}
