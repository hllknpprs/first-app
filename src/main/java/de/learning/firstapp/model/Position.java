package de.learning.firstapp.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@ToString(exclude = {"employee","team","role"})
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"employeeId","teamId","roleId"})})
public class Position {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "employeeId", insertable = false, updatable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "teamId", insertable = false, updatable = false)
    private Team team;

    @ManyToOne
    @JoinColumn(name = "roleId", insertable = false, updatable = false)
    private Employee role;

    @Column(nullable = false)
    private int teamId;

    @Column(nullable = false)
    private int employeeId;

    @Column(nullable = false)
    private int roleId;

    @Column(nullable = false)
    private int anteil;

}
