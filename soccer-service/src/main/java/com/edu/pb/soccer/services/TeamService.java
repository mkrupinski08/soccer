package com.edu.pb.soccer.services;

import com.edu.pb.soccer.dto.TeamDto;
import com.edu.pb.soccer.dto.TeamInputDto;
import com.edu.pb.soccer.dto.TeamPatchDto;

import java.util.List;

public interface TeamService {

    TeamDto add(TeamInputDto teamInputDto);

    List<TeamDto> getAll();

    List<TeamDto> patch(TeamPatchDto teamPatchDto);

}
