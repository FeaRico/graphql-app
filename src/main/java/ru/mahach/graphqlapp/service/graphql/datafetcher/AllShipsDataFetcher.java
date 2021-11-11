package ru.mahach.graphqlapp.service.graphql.datafetcher;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;
import ru.mahach.graphqlapp.model.Ship;
import ru.mahach.graphqlapp.repository.ShipRepository;

import java.util.List;

@Component
public class AllShipsDataFetcher implements DataFetcher<List<Ship>> {

    private final ShipRepository shipRepository;

    public AllShipsDataFetcher(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }


    @Override
    public List<Ship> get(DataFetchingEnvironment dataFetchingEnvironment) {
        return shipRepository.findAll();
    }
}
