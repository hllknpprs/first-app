package de.learning.firstapp.repository;

import de.learning.firstapp.model.Position;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PositionRepository extends CrudRepository<Position, Integer> {
    public List<Position> findPositionsByEmployeeId(int employeeId);
    public List<Position> findPositionsByTeamId(int teamId);
    public List<Position> findAll();
}
