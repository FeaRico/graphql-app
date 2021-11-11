package ru.mahach.graphqlapp.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mahach.graphqlapp.model.Ship;
import ru.mahach.graphqlapp.repository.ShipRepository;
import ru.mahach.graphqlapp.service.ShipService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShipServiceImpl implements ShipService {

    private final ShipRepository shipRepository;


    public ShipServiceImpl(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    @Override
    @Transactional
    public Ship createShip(String name, String status, String flag, int yearBuilt, String homePort) {
        Ship newShip = new Ship();
        newShip.setName(name);
        newShip.setStatus(status);
        newShip.setFlag(flag);
        newShip.setYearBuilt(yearBuilt);
        newShip.setHomePort(homePort);
        return this.shipRepository.save(newShip);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ship> getAllShips(int count) {
        return this.shipRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Ship> getShip(Long id) {
        return this.shipRepository.findById(id);
    }
}
