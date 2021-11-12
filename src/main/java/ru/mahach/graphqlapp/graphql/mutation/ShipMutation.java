package ru.mahach.graphqlapp.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import ru.mahach.graphqlapp.model.Ship;
import ru.mahach.graphqlapp.service.ShipService;

/**
 * Распознаватель мутаций GraphQL для {@link Ship}
 * @author Makhach Abdulazizov
 * @version 1.0
 */

@Component
public class ShipMutation implements GraphQLMutationResolver {

    private final ShipService shipService;

    public ShipMutation(ShipService shipService) {
        this.shipService = shipService;
    }

    public Ship createShip(String name, String status, String flag, int yearBuilt, String homePort){
        return this.shipService.createShip(name, status, flag, yearBuilt, homePort);
    }
}
