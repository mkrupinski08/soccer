package com.edu.pb.soccer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivityDto {

    private int timestamp;
    private String activityType;
    private String player;
    private String match;

}
