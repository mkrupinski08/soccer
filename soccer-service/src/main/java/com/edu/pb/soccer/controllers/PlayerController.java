package com.edu.pb.soccer.controllers;

import com.edu.pb.soccer.dto.PlayerDto;
import com.edu.pb.soccer.dto.PlayerInputDto;
import com.edu.pb.soccer.operations.PlayerOperations;
import com.edu.pb.soccer.services.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlayerController implements PlayerOperations {

    private final PlayerService playerService;

    @Override
    public PlayerDto add(PlayerInputDto playerInputDto) {
        return playerService.add(playerInputDto);
    }

    @Override
    public List<PlayerDto> getAll() {
        return playerService.getAll();
    }

}
