package com.edu.pb.soccer.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum Position {

    GOALKEEPER("Goalkeeper"),
    DEFENDER("Defender"),
    MIDFIELDER("Midfielder"),
    FORWARD("Forward");

    private final String name;

    public static Position fromName(String name) {
        return Arrays.stream(values())
                .filter(p -> p.name.equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow();
    }

}
