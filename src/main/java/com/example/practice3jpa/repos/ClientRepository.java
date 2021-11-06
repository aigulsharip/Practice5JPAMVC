package com.example.practice3jpa.repos;

import com.example.practice3jpa.entities.Client;
import com.example.practice3jpa.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("select a from Client a where a.clientName like %:name%")
    List<Client> findByClientName(@Param("name") String name);
    Client findClientById(Long id);



}
