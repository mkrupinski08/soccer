package com.edu.pb.soccer.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Match {

    @Id
    @UuidGenerator
    private String id;
    private LocalDate gameDate;
    private String host;
    private String guest;
    private String result;
    private String name;
    @OneToMany(mappedBy = "match", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Activity> activities;

}
