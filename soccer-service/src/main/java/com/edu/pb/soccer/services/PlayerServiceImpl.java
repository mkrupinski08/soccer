package com.edu.pb.soccer.services;

import com.edu.pb.soccer.dto.PlayerDto;
import com.edu.pb.soccer.dto.PlayerInputDto;
import com.edu.pb.soccer.mappers.PlayerMapper;
import com.edu.pb.soccer.model.Player;
import com.edu.pb.soccer.model.Team;
import com.edu.pb.soccer.repositories.PlayerRepository;
import com.edu.pb.soccer.repositories.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;
    private final TeamRepository teamRepository;

    @Override
    @Transactional
    public PlayerDto add(PlayerInputDto playerInputDto) {
        Player player = playerMapper.mapPlayerInputDtoToPlayer(playerInputDto);
        Team team = teamRepository.findByName(playerInputDto.getTeam());
        player.setTeam(team);
//        team.getPlayers().add(player);
//        teamRepository.saveAndFlush(team);
        return playerMapper.mapPlayerToPlayerDto(
                playerRepository.saveAndFlush(player));
    }

    @Override
    public List<PlayerDto> getAll() {
        return playerMapper.mapPlayerListToPlayerDtoList(playerRepository.findAll());
    }

}
