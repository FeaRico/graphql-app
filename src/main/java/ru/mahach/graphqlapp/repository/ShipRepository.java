package ru.mahach.graphqlapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mahach.graphqlapp.model.Ship;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {
}
