package ru.mahach.graphqlapp.controller;

import graphql.ExecutionResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mahach.graphqlapp.service.graphql.GraphQLService;

@RestController
@RequestMapping("api/v1/ships/")
public class ShipController {

    private final GraphQLService graphQLService;

    public ShipController(GraphQLService graphQLService) {
        this.graphQLService = graphQLService;
    }

    @PostMapping
    public ResponseEntity<Object> getAllShips(@RequestBody String query){
        ExecutionResult execute = graphQLService.getGraphQL().execute(query);

        return new ResponseEntity<>(execute, HttpStatus.OK);
    }

}
