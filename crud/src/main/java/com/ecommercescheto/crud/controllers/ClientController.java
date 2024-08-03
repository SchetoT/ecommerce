package com.ecommercescheto.crud.controllers;

import com.ecommercescheto.crud.entities.Client;
import com.ecommercescheto.crud.sevices.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/clients")
@Tag(name = "Client controller", description = "Here you can add a new client, see all clients, edit a client or delete a client.")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/register")
    @Operation(summary = "Register a new client", description = "You need to enter the data to create a new client, in this case only name, last name and doc number will be used")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "201", description = "Client created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request. Invalid client data"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public Client registerClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get client by ID", description = "You need to enter the ID of a client")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Client found successfully"),
            @ApiResponse(responseCode = "404", description = "Client not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Optional<Client> client = clientService.findById(id);
        if (client.isPresent()) {
            return ResponseEntity.ok(client.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/me")
    @Operation(summary = "Update client profile", description = "You need to enter the ID of a client and their updated data, in this case only name, last name and doc number will be used")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Client data updated successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request. Invalid client data"),
            @ApiResponse(responseCode = "404", description = "Client not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public Client updateClientProfile(@RequestBody Client client) {
        return clientService.updateClient(client);
    }
    @GetMapping("/clients")
    @Operation(summary = "Get all clients", description = "You will be able to view all clients registered in the system")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Clients retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete client by ID", description = "You need to enter the ID of a client and they will be deleted from the system")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "204", description = "Client deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Client not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}