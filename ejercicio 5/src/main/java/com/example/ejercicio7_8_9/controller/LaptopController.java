package com.example.ejercicio7_8_9.controller;

import com.example.ejercicio7_8_9.entities.Laptop;
import com.example.ejercicio7_8_9.repository.LaptopRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    private LaptopRepository repository;

    public LaptopController(LaptopRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/Listado")
    public List<Laptop> findAll(){
        return repository.findAll();
    }

    @GetMapping("/api/Laptop/{id}")
        public ResponseEntity<Laptop> findOneById(@PathVariable Long id){

        Optional<Laptop> LaptopOpt = repository.findById(id);

        if (LaptopOpt.isPresent()){
            return ResponseEntity.ok(LaptopOpt.get());
        } else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("api/Laptop")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop){

        if (laptop.getId() != null){
            return ResponseEntity.badRequest().build();
        }


        Laptop resultado = repository.save(laptop);
        return ResponseEntity.ok(resultado);
    }


    @PutMapping("api/Laptop")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){

        //Comprobamos que el id que nos pasan exista.
        if (laptop.getId() == null){
            return ResponseEntity.badRequest().build();
        }

        //Comprobamos que existe el id que queremos actualizar.
        if (!repository.existsById(laptop.getId())){
            return ResponseEntity.notFound().build();
        }
        Laptop resultado = repository.save(laptop);
        return ResponseEntity.ok(resultado);
    }

    @DeleteMapping("/api/Laptop/{id}")
    public ResponseEntity<Laptop> delete(@RequestBody @PathVariable Long id){


        //Comprobamos que exista.
        if (repository.existsById(id)){
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/api/Laptop")
    public ResponseEntity<Laptop> deleteAll(){
        repository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
