package com.edu.pb.soccer.operations;

import com.edu.pb.soccer.dto.MatchDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/match")
public interface MatchOperations {

    @PostMapping
    MatchDto add(@RequestBody @Valid MatchDto matchDto);

    @GetMapping
    List<MatchDto> getAll();

}
