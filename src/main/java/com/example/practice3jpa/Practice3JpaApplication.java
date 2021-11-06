package com.example.practice3jpa;

import com.example.practice3jpa.config.JpaConfig;
import com.example.practice3jpa.entities.Client;
import com.example.practice3jpa.entities.Product;
import com.example.practice3jpa.service.ClientService;
import com.example.practice3jpa.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

@SpringBootApplication
public class Practice3JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Practice3JpaApplication.class, args);
        System.out.println("Everything is working");

        /*
        ConfigurableApplicationContext ctx = SpringApplication.run(Practice3JpaApplication.class, args);

        //This configuration is also working
        //GenericApplicationContext ctx = new AnnotationConfigApplicationContext(JpaConfig.class);

        // Checking all the ProductService methods
        ProductService productService = ctx.getBean(ProductService.class);

        // findAll() return the list of products
        productService.findAll().forEach(System.out::println);

        // findAllWithClient () return the list of products with clients
        productService.findAllWithClient().forEach(System.out::println);


        // findProductById(Long id) return product with specific id
        System.out.println(productService.findProductById(3L));

        // delete(Product product) removes specific product from Product table and from Client table if relevant
        // deleting the data from Product table affect on Client table as well
        // Product product1 = productService.findProductById(1L);
        // productService.delete(product1);
        // productService.findAll().forEach(System.out::println);

        // Checking all the ClientService methods
        ClientService clientService= ctx.getBean(ClientService.class);

        // findAllClients() return the list of clients
        clientService.findAllClients().forEach(System.out::println);

        //findByClientName (String name) returns the client with specific name
        clientService.findByClientName("Sara").forEach(System.out::println);


        // findClientById(Long id) return client with specific id
        System.out.println(clientService.findClientById(1L));

        // delete(Client client) removes specific client from Client table and from Product table if relevant
        // Client client1 = clientService.findClientById(1L);
        // clientService.delete(client1);
        // clientService.findAllClients().forEach(System.out::println);


        ctx.close();

         */





    }

}
