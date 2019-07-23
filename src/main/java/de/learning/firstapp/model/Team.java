package de.learning.firstapp.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@ToString(exclude = "positions")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(nullable=false)
    private String Name;

    @OneToMany(mappedBy = "team")
    private List<Position> positions;


}
