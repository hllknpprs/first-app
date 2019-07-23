package de.learning.firstapp.controller;

import de.learning.firstapp.model.Employee;
import de.learning.firstapp.model.Employer;
import de.learning.firstapp.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployerController {

    @Autowired
    private EmployerRepository repository;

    @GetMapping("Employer/{id}")
    public String getEmployer(@PathVariable("id") int id){
        Employer employer = repository.findById(id);
        return employer.toString();
    }
}
