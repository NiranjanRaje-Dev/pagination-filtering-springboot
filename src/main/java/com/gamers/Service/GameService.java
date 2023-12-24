package com.gamers.Service;

import com.gamers.Dto.GameDto;

import java.util.List;


public interface GameService {

    public GameDto addGame(GameDto game);
    public List<GameDto> getGames(Integer limit, Integer offset);

}
