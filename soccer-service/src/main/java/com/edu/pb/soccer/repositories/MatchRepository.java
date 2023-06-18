package com.edu.pb.soccer.repositories;

import com.edu.pb.soccer.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match, String> {

    Match findByName(String name);

}
