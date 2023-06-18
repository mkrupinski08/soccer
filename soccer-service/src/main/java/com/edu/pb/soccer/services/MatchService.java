package com.edu.pb.soccer.services;

import com.edu.pb.soccer.dto.MatchDto;

import java.util.List;

public interface MatchService {

    MatchDto add(MatchDto matchDto);

    List<MatchDto> getAll();

}
