package com.edu.pb.soccer.services;

import com.edu.pb.soccer.dto.TeamDto;
import com.edu.pb.soccer.dto.TeamInputDto;
import com.edu.pb.soccer.dto.TeamPatchDto;
import com.edu.pb.soccer.mappers.TeamMapper;
import com.edu.pb.soccer.model.Player;
import com.edu.pb.soccer.model.Team;
import com.edu.pb.soccer.repositories.PlayerRepository;
import com.edu.pb.soccer.repositories.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;
    private final PlayerRepository playerRepository;

    @Override
    public TeamDto add(TeamInputDto teamInputDto) {
        Team team = Team.builder()
                .name(teamInputDto.getName())
                .foundationDate(teamInputDto.getFoundationDate())
                .build();
        return teamMapper.mapTeamToTeamDto(teamRepository.save(team));
    }

    @Override
    public List<TeamDto> getAll() {
        return teamMapper.mapTeamListToTeamDtoList(teamRepository.findAll());
    }

    @Override
    @Transactional
    public List<TeamDto> patch(TeamPatchDto teamPatchDto) {
        Team team = teamRepository.findByName(teamPatchDto.getName());
        Set<Player> players = new HashSet<>();
        teamPatchDto.getPlayers().forEach(p -> players.add(playerRepository.findByNameAndSurname(p.getName(), p.getSurname())));
        team.setPlayers(players);
        players.forEach(p -> p.setTeam(team));
        teamRepository.saveAndFlush(team);
        playerRepository.saveAllAndFlush(players);
        return getAll();
    }

}
