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
public class Team {

    @Id
    @UuidGenerator
    private String id;
    private String name;
    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Player> players;
    private LocalDate foundationDate;

    public void addPlayer(Player player) {
        players.add(player);
        player.setTeam(this);
    }

}
