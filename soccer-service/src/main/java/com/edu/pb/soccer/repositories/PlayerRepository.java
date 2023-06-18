package com.edu.pb.soccer.repositories;

import com.edu.pb.soccer.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {

    Player findByNameAndSurname(String name, String surname);

}
