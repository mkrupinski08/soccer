package com.edu.pb.soccer.controllers;

import com.edu.pb.soccer.dto.ActivityDto;
import com.edu.pb.soccer.model.Activity;
import com.edu.pb.soccer.operations.ActivityOperations;
import com.edu.pb.soccer.services.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ActivityController implements ActivityOperations {

    private final ActivityService activityService;

    @Override
    public ActivityDto add(ActivityDto activityDto) {
        return activityService.add(activityDto);
    }

    @Override
    public List<ActivityDto> getAll() {
        return activityService.getAll();
    }
}
