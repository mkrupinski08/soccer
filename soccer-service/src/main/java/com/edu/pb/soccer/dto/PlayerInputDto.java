package com.edu.pb.soccer.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerInputDto {

    @NotBlank
    private String name;
    @NotBlank
    private String surname;

    private String position;
    @Min(1)
    @Max(99)
    private int num;
    @NotNull
    private LocalDate birthDate;
    @Min(154)
    @Max(210)
    private int height;
    @Min(76)
    @Max(110)
    private int weight;

    private String team;

}
