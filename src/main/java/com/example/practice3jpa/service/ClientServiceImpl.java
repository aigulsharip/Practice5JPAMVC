package com.example.practice3jpa.service;

import com.example.practice3jpa.entities.Client;
import com.example.practice3jpa.entities.Product;
import com.example.practice3jpa.repos.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientServiceImpl  implements ClientService{

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly=true)
    @Override
    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public List<Client> findByClientName(String name) {
        return clientRepository.findByClientName(name);
    }

    public Client findClientById(Long id) {
        return clientRepository.findClientById(id);
    }

    public void delete(Client client) {
        clientRepository.delete(client);
    }
}
