package de.learning.firstapp.controller;

import de.learning.firstapp.model.Employee;
import de.learning.firstapp.model.Position;
import de.learning.firstapp.repository.EmployeeRepository;
import de.learning.firstapp.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PositionRepository positionRepository;

    @GetMapping("/ById/{id}")
    public String getEmployeeById(@PathVariable("id") int id){
        return employeeRepository.findById(id).toString() ;
    }

    @GetMapping("/ByEmployerId/{employerId}")
    public String getEmployeesByEmployerId(@PathVariable("employerId") int employerId){
        return employeeRepository.findAllByEmployer_Id(employerId).toString() ;
    }

    @GetMapping("/AllByCertainTeam/{teamId}")
    public String getEmployeesByTeamId(@PathVariable("teamId") int teamId){
        List<Position> positions = positionRepository.findPositionsByTeamId(teamId);
        List<Employee> employees = positions.stream().map(p -> p.getEmployee()).distinct().collect(Collectors.toList());
        return employees.toString();

    }

    @PostMapping()
    //Alternativ: DTO für Employee erstellen, der keine Property "Employer employer"
    // hat ,sondern nur die employerID beinhaltet und dann das passende Employer-Objekt
    // im Controller durch eine Abfrage ermitteln.

    //Aktuelle Implementierung des Models Employee --> Kombination aus Model und DTO

    //Wie würde man es ohne DTO machen? Man müsste ja das ganze Employer-Objekt direkt mitschicken.
    public Employee postEmployee(@RequestBody Employee newEmployee){
        System.out.println(newEmployee.toString());
        employeeRepository.save(newEmployee);
        return newEmployee;
    }
}
