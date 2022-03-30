package com.example.Ejercicio10_11_12;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hellocontroller {

    @Value("${app.message}")
    String message;

    @GetMapping("/Hola")
    public String Saludo(){
        return "Hola!!! Cómo estáis!!!" + message;

    }

}
