package ru.mahach.graphqlapp.service.graphql;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import ru.mahach.graphqlapp.repository.ShipRepository;
import ru.mahach.graphqlapp.service.graphql.datafetcher.AllShipsDataFetcher;
import ru.mahach.graphqlapp.service.graphql.datafetcher.ShipDataFetcher;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Service
public class GraphQLService {

    private GraphQL graphQL;

    @Value("classpath:ships.graphql")
    Resource resource;

    private final AllShipsDataFetcher allShipsDataFetcher;
    private final ShipDataFetcher shipDataFetcher;

    public GraphQLService(AllShipsDataFetcher allShipsDataFetcher, ShipDataFetcher shipDataFetcher) {
        this.allShipsDataFetcher = allShipsDataFetcher;
        this.shipDataFetcher = shipDataFetcher;
    }

    @PostConstruct
    public void loadSchema() throws IOException{
        File schemaFile = resource.getFile();
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("allShips", allShipsDataFetcher)
                        .dataFetcher("ship", shipDataFetcher))
                .build();
    }

    public GraphQL getGraphQL(){
        return graphQL;
    }
}
