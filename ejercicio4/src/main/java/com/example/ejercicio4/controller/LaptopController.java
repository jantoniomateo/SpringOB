package com.example.ejercicio4.controller;

import com.example.ejercicio4.entities.Laptop;
import com.example.ejercicio4.repository.LaptopRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LaptopController {

    private LaptopRepository repository;

    public LaptopController(LaptopRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/Listado")
    public List<Laptop> listar(){
        return repository.findAll();
    }

    @PostMapping("api/Añadir")
    public Laptop add(@RequestBody Laptop laptop){
        return repository.save(laptop);
    }

}
