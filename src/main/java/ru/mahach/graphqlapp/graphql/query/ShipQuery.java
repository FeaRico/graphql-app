package ru.mahach.graphqlapp.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import ru.mahach.graphqlapp.model.Ship;
import ru.mahach.graphqlapp.service.ShipService;

import java.util.List;
import java.util.Optional;

/**
 * Распознаватель запросов GraphQL для {@link Ship}
 * @author Makhach Abdulazizov
 * @version 1.0
 */

@Component
public class ShipQuery implements GraphQLQueryResolver{

    private final ShipService shipService;

    public ShipQuery(ShipService shipService) {
        this.shipService = shipService;
    }

    public List<Ship> getShips(int count){
        return this.shipService.getAllShips(count);
    }

    public Optional<Ship> getShip(Long id){
        return this.shipService.getShip(id);
    }
}
