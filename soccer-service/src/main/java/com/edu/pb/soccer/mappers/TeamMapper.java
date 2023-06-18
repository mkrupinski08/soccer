package com.edu.pb.soccer.mappers;

import com.edu.pb.soccer.dto.TeamDto;
import com.edu.pb.soccer.model.Team;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeamMapper {

    public TeamDto mapTeamToTeamDto(Team team) {
        TeamDto teamDto = TeamDto.builder()
                .name(team.getName())
                .foundationDate(team.getFoundationDate())
                .build();
        if (team.getPlayers() != null && team.getPlayers().size() > 0) {
            teamDto.setPlayers(team.getPlayers().stream()
                    .map(player -> player.getName() + " " + player.getSurname())
                    .collect(Collectors.toSet()));
        }
        return teamDto;
    }

    public List<TeamDto> mapTeamListToTeamDtoList(List<Team> teamList) {
        return teamList.stream()
                .map(this::mapTeamToTeamDto)
                .toList();
    }

}
