package de.learning.firstapp.repository;

import de.learning.firstapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public Employee findById( int id);
    public List<Employee> findAllByEmployer_Id(int employerId);
    public List<Employee> findDistinctByPositions(int teamId);
}
