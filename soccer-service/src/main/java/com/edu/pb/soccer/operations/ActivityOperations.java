package com.edu.pb.soccer.operations;

import com.edu.pb.soccer.dto.ActivityDto;
import com.edu.pb.soccer.model.Activity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/activity")
public interface ActivityOperations {

    @PostMapping
    ActivityDto add(@RequestBody @Valid ActivityDto activityDto);

    @GetMapping
    List<ActivityDto> getAll();

}
