package com.edu.pb.soccer.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum ActivityType {

    YELLOW_CARD("yellow card"),
    RED_CARD("red card"),
    GOAL("goal"),
    FAUL("faul");

    private final String name;

    public static ActivityType fromName(String name) {
        return Arrays.stream(values())
                .filter(a -> a.name.equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow();
    }

}
