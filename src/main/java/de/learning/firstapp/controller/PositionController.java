package de.learning.firstapp.controller;

import de.learning.firstapp.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PositionController {

    @Autowired
    private PositionRepository repository;

    @GetMapping("/Positions")
    public String getPositions(){
        return repository.findAll().toString();
    }
}
