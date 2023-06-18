package com.edu.pb.soccer.services;

import com.edu.pb.soccer.dto.MatchDto;
import com.edu.pb.soccer.model.Match;
import com.edu.pb.soccer.repositories.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchServiceImpl implements MatchService {

    private final MatchRepository matchRepository;

    @Override
    public MatchDto add(MatchDto matchDto) {
        Match match = Match.builder()
                .guest(matchDto.getGuest())
                .host(matchDto.getHost())
                .gameDate(matchDto.getGameDate())
                .result(matchDto.getResult())
                .name(matchDto.getName())
                .build();
        matchRepository.save(match);
        return matchDto;
    }

    @Override
    public List<MatchDto> getAll() {
        List<Match> matches = matchRepository.findAll();
        List<MatchDto> matchDtos = new ArrayList<>();
        for (Match match : matches) {
            matchDtos.add(MatchDto.builder()
                    .guest(match.getGuest())
                    .host(match.getHost())
                    .gameDate(match.getGameDate())
                    .result(match.getResult())
                    .name(match.getName())
                    .build());
        }
        return matchDtos;
    }

}
