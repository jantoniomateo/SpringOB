package com.example.ejercicio7_8_9.controller;

import com.example.ejercicio7_8_9.entities.Laptop;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setup(){
        restTemplateBuilder = restTemplateBuilder.rootUri(("http://localhost:" + port));
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

@DisplayName("Añadir de laptop")
@Test
void create (){

    //preparamos las cabeceras
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

    //preparamos json
    String json = """
            {
              "marca": "Ordenador de Test",
              "modelo": "Investronica Test",
              "procesador": "Intel Test"
                }
            """;

    //preparamos el envio
    HttpEntity<String> request = new HttpEntity<>(json,headers);

    //ejecutamos la petición y recibimos la respuesta
    ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/Laptop",HttpMethod.POST,request,Laptop.class);

    Laptop resultado = response.getBody();

    assertEquals(1L,resultado.getId());
    }

@DisplayName("Encontrar todos")
    @Test
    void findAll() {
        ResponseEntity<Laptop[]> response = testRestTemplate.getForEntity(("/api/Listado"), Laptop[].class);
        assertEquals(HttpStatus.OK,response.getStatusCode());

        List<Laptop> laptops = Arrays.asList(response.getBody()); // con Arrays.asList convertirmos el Laptop[] en una Lista o ArrayList.
        System.out.println((laptops.size()));
    }

    @DisplayName("Encontar por Id")
    @Test
    void findOneById() {
        ResponseEntity<Laptop> response = testRestTemplate.getForEntity("/api/Laptop/1",Laptop.class);
        assertEquals(HttpStatus.OK,response.getStatusCode());
    }

@DisplayName("Actualizar existente")
    @Test
    void update() {
    }

    @DisplayName("Borrar uno")
    @Test
    void delete() {
        ResponseEntity<Laptop> response = testRestTemplate.getForEntity("/api/Laptop/1",Laptop.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @DisplayName("Borrar todos")
    @Test
    void deleteAll() {
        ResponseEntity<Laptop> response = testRestTemplate.getForEntity("/api/Laptop",Laptop.class);

    }
}