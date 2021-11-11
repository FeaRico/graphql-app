package ru.mahach.graphqlapp.service;

import ru.mahach.graphqlapp.model.Ship;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ShipService {
    Ship createShip(String name, String status, String flag, int yearBuilt, String homePort);
    List<Ship> getAllShips(int count);
    Optional<Ship> getShip(Long id);
}
