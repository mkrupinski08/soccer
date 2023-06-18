package com.edu.pb.soccer.services;

import com.edu.pb.soccer.dto.ActivityDto;
import com.edu.pb.soccer.enums.ActivityType;
import com.edu.pb.soccer.model.Activity;
import com.edu.pb.soccer.model.Match;
import com.edu.pb.soccer.repositories.ActivityRepository;
import com.edu.pb.soccer.repositories.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;
    private final MatchRepository matchRepository;

    @Override
    public ActivityDto add(ActivityDto activityDto) {
        Match match = matchRepository.findByName(activityDto.getMatch());
        Activity activity = Activity.builder()
                .activityType(ActivityType.fromName(activityDto.getActivityType()))
                .timestamp(activityDto.getTimestamp())
                .player(activityDto.getPlayer())
                .match(match)
                .build();
        activityRepository.save(activity);
        return activityDto;
    }

    @Override
    public List<ActivityDto> getAll() {
        List<Activity> activities = activityRepository.findAll();
        List<ActivityDto> activityDtos = new ArrayList<>();
        for (Activity activity : activities) {
            activityDtos.add(ActivityDto.builder()
                    .activityType(activity.getActivityType().getName())
                    .match(activity.getMatch().getName())
                    .player(activity.getPlayer())
                    .timestamp(activity.getTimestamp())
                    .build());
        }
        return activityDtos;
    }

}
