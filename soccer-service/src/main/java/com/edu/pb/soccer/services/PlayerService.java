package com.edu.pb.soccer.services;

import com.edu.pb.soccer.dto.PlayerDto;
import com.edu.pb.soccer.dto.PlayerInputDto;

import java.util.List;

public interface PlayerService {

    PlayerDto add(PlayerInputDto playerInputDto);

    List<PlayerDto> getAll();

}
