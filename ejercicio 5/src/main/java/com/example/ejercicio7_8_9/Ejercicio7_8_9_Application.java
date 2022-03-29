package com.example.ejercicio7_8_9;

import com.example.ejercicio7_8_9.entities.Laptop;
import com.example.ejercicio7_8_9.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ejercicio7_8_9_Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Ejercicio7_8_9_Application.class, args);

		Laptop laptop1 = new Laptop(null,"Dell","Inspiron","Intel");
		Laptop laptop2 = new Laptop(null,"HP","See","amd");

		LaptopRepository repository = context.getBean(LaptopRepository.class);

		repository.save(laptop1);
		repository.save(laptop2);

		System.out.println(("Los ordenadores que existen actualmente son: "));
		System.out.println("");
		System.out.println(repository.findAll());
	}

}
