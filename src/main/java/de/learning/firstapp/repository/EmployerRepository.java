package de.learning.firstapp.repository;

import de.learning.firstapp.model.Employer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployerRepository extends CrudRepository<Employer, Integer> {
    public Employer findById(int id);
}
