package de.learning.firstapp.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@ToString(exclude={"positions"})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable=false)
    private String firstName;

    @Column(nullable=false)
    private String lastName;

    @Column(nullable=false)
    private int employerId;

    @ManyToOne
    @JoinColumn(name = "employerId", insertable = false, updatable = false)
    private Employer employer;

    @OneToMany(mappedBy = "employee")
    private List<Position> positions;


}
