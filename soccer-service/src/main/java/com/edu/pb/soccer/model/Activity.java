package com.edu.pb.soccer.model;

import com.edu.pb.soccer.enums.ActivityType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Activity {

    @Id
    @UuidGenerator
    private String id;

    private int timestamp;
    @Enumerated(value = EnumType.STRING)
    private ActivityType activityType;
    private String player;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "match_id", referencedColumnName = "id")
    private Match match;

}
