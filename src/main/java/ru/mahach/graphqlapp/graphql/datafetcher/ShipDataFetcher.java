package ru.mahach.graphqlapp.service.graphql.datafetcher;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;
import ru.mahach.graphqlapp.model.Ship;
import ru.mahach.graphqlapp.repository.ShipRepository;

@Component
public class ShipDataFetcher implements DataFetcher<Ship> {

    private final ShipRepository shipRepository;

    public ShipDataFetcher(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    @Override
    public Ship get(DataFetchingEnvironment dataFetchingEnvironment) {
        Long id = dataFetchingEnvironment.getArgument("id");
        return shipRepository.getById(id);
    }
}
