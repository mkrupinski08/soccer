package com.edu.pb.soccer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MatchDto {

    private LocalDate gameDate;
    private String host;
    private String guest;
    private String result;

    private String name;

}
