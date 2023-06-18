package com.edu.pb.soccer.repositories;

import com.edu.pb.soccer.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, String> {

    Team findByName(String name);

}
