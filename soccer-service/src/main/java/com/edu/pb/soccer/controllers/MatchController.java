package com.edu.pb.soccer.controllers;

import com.edu.pb.soccer.dto.MatchDto;
import com.edu.pb.soccer.operations.MatchOperations;
import com.edu.pb.soccer.services.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MatchController implements MatchOperations {

    private final MatchService matchService;

    @Override
    public MatchDto add(MatchDto matchDto) {
        return matchService.add(matchDto);
    }

    @Override
    public List<MatchDto> getAll() {
        return matchService.getAll();
    }

}
