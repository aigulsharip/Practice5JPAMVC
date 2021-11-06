package com.example.practice3jpa.service;

import com.example.practice3jpa.config.JpaConfig;
import com.example.practice3jpa.entities.Client;
import com.example.practice3jpa.entities.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class ProductAndClientTest {

    private GenericApplicationContext ctx;
    private ProductService productService;
    private ClientService clientService;

    @Before
    public void setUp(){
        ctx = new AnnotationConfigApplicationContext(JpaConfig.class);
        productService = ctx.getBean(ProductService.class);
        clientService = ctx.getBean(ClientService.class);
        assertNotNull(productService);
        assertNotNull(clientService);
    }

    @Test
    public void testFindAll(){
        List<Product> products = productService.findAll();
        assertEquals(4, products.size());

    }


    @Test
    public void testFindAllWithClient(){
        List<Product> singers = productService.findAllWithClient();
        assertEquals(4, singers.size());

    }


    @Test
    public void testFindProductById(){
        Product product = productService.findProductById(1L);
        assertNotNull(product);
        assertEquals("MacBook Pro", product.getProductName());

    }

    @Test
    public void testDeleteProduct() {
        Product product = productService.findProductById(2l);
        assertNotNull(product);
        productService.delete(product);
    }

    @Test
    public void testFindAllClients(){
        List<Client> clients = clientService.findAllClients();
        assertTrue(clients.size() > 0);

    }

    @Test
    public void testFindByClientName(){
        List<Client> clients = clientService.findByClientName("Bob");
        assertTrue(clients.size() > 0);
        assertEquals(1, clients.size());

    }

    @Test
    public void  testFindClientById() {
        Client client = clientService.findClientById(1L);
        assertNotNull(client);
        assertEquals("Bob", client.getClientName());

    }


    @Test
    public void testDeleteClient() {
        Client client = clientService.findClientById(2l);
        assertNotNull(client);
        clientService.delete(client);
    }

    @After
    public void tearDown() {
        ctx.close();
    }

}
