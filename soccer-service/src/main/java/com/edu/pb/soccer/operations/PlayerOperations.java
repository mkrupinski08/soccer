package com.edu.pb.soccer.operations;

import com.edu.pb.soccer.dto.PlayerDto;
import com.edu.pb.soccer.dto.PlayerInputDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/player")
public interface PlayerOperations {

    @PostMapping
    PlayerDto add(@RequestBody @Valid PlayerInputDto playerInputDto);

    @GetMapping
    List<PlayerDto> getAll();

}
