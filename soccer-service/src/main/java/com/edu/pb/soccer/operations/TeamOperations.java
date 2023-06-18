package com.edu.pb.soccer.operations;

import com.edu.pb.soccer.dto.TeamDto;
import com.edu.pb.soccer.dto.TeamInputDto;
import com.edu.pb.soccer.dto.TeamPatchDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/team")
public interface TeamOperations {

    @PostMapping
    TeamDto add(@RequestBody @Valid TeamInputDto teamInputDto);

    @GetMapping
    List<TeamDto> getAll();

    @PatchMapping
    List<TeamDto> patch(@RequestBody TeamPatchDto teamPatchDto);

}
