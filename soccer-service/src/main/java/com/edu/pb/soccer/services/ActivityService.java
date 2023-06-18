package com.edu.pb.soccer.services;

import com.edu.pb.soccer.dto.ActivityDto;

import java.util.List;

public interface ActivityService {

    ActivityDto add(ActivityDto activityDto);

    List<ActivityDto> getAll();

}
