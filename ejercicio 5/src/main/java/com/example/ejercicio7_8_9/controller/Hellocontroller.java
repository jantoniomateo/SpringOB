package com.example.ejercicio7_8_9.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hellocontroller {

    @GetMapping("/Saludo")
    public String Saludo(){
        return "Hola!!! Cómo estáis!!!";

    }

}
