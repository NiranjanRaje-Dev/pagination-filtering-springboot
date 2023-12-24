package com.gamers.Service;

import com.gamers.Dto.GameDto;
import com.gamers.Entity.Game;
import com.gamers.Repository.GameRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService{

    @Autowired
    GameRepository gameRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public GameDto addGame(GameDto game) {
        Game savedGame = modelMapper.map(game,Game.class);
        Game createdGame = gameRepo.save(savedGame);
        return modelMapper.map(createdGame, GameDto.class);
    }

    @Override
    public List<GameDto> getGames(Integer limit, Integer offset) {
        Integer MAX_LIMIT = 50;
        if(limit > MAX_LIMIT) limit = MAX_LIMIT;
        Pageable pageable = PageRequest.of(offset,limit);
        Page<Game> page = gameRepo.findAll(pageable);
        List<Game> gameList = page.getContent();
        List<GameDto> gameList2 = page.getContent().stream().map((game)->modelMapper.map(game,GameDto.class)).collect(Collectors.toList());
        return gameList2;
    }

}
