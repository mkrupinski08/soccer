package com.edu.pb.soccer.controllers;

import com.edu.pb.soccer.dto.TeamDto;
import com.edu.pb.soccer.dto.TeamInputDto;
import com.edu.pb.soccer.dto.TeamPatchDto;
import com.edu.pb.soccer.operations.TeamOperations;
import com.edu.pb.soccer.services.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeamController implements TeamOperations {

    private final TeamService teamService;

    @Override
    public TeamDto add(TeamInputDto teamInputDto) {
        return teamService.add(teamInputDto);
    }

    @Override
    public List<TeamDto> getAll() {
        return teamService.getAll();
    }

    @Override
    public List<TeamDto> patch(TeamPatchDto teamPatchDto) {
        return teamService.patch(teamPatchDto);
    }

}
