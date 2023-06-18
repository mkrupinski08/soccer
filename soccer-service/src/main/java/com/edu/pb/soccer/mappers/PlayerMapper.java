package com.edu.pb.soccer.mappers;

import com.edu.pb.soccer.dto.PlayerDto;
import com.edu.pb.soccer.dto.PlayerInputDto;
import com.edu.pb.soccer.enums.Position;
import com.edu.pb.soccer.model.Player;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlayerMapper {

    public PlayerDto mapPlayerToPlayerDto(Player player) {
        PlayerDto playerDto = PlayerDto.builder()
                .name(player.getName())
                .surname(player.getSurname())
                .position(player.getPosition().getName())
                .num(player.getNum())
                .birthDate(player.getBirthDate())
                .age(player.getAge())
                .height(player.getHeight())
                .weight(player.getWeight())
                .build();
        if (player.getTeam() != null) {
            if (player.getTeam().getName() != null && player.getTeam().getName().length() > 0) {
                playerDto.setTeam(player.getTeam().getName());
            }
        }
        return playerDto;
    }

    public Player mapPlayerInputDtoToPlayer(PlayerInputDto playerInputDto) {
        Player player = Player.builder()
                .name(playerInputDto.getName())
                .surname(playerInputDto.getSurname())
                .position(Position.fromName(playerInputDto.getPosition()))
                .num(playerInputDto.getNum())
                .birthDate(playerInputDto.getBirthDate())
                .height(playerInputDto.getHeight())
                .weight(playerInputDto.getWeight())
                .build();
        player.setAge();
        return player;
    }

    public List<PlayerDto> mapPlayerListToPlayerDtoList(List<Player> playerList) {
        return playerList.stream()
                .map(this::mapPlayerToPlayerDto)
                .toList();
    }

}
