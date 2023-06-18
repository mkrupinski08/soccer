package com.edu.pb.soccer.model;

import com.edu.pb.soccer.enums.Position;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    @Id
    @UuidGenerator
    private String id;
    private String name;
    private String surname;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team team;
    @Enumerated(value = EnumType.STRING)
    private Position position;
    @Min(14)
    @Max(56)
    private int age;
    private LocalDate birthDate;
    private int num;
    private int height;
    private int weight;

    public void setAge() {
        this.age = Period.between(this.birthDate, LocalDate.now()).getYears();
    }

}
