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
public class PlayerDto {

    private String name;
    private String surname;
    private String team;
    private String position;
    private int num;
    private LocalDate birthDate;
    private int age;
    private int height;
    private int weight;

}
