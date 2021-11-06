package com.example.practice3jpa.service;

import com.example.practice3jpa.entities.Client;
import com.example.practice3jpa.entities.Product;

import java.util.List;

public interface ClientService {

    List<Client> findAllClients();
    List<Client> findByClientName(String name);
    Client findClientById(Long id);
    void delete(Client client);




}
