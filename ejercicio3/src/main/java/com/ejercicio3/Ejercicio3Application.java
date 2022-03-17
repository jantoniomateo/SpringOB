package com.ejercicio3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ejercicio3Application {

	public static void main(String[] args) {

	ApplicationContext context = SpringApplication.run(Ejercicio3Application.class, args);

	//Creamos una variable se servicio para incluir datos en nuestra base de datos tipo H2.

	AsociadosService asociados = context.getBean(AsociadosService.class);

	Asociados asociado1 = new Asociados(null,"Antonio","Sánchez","Romero");
	Asociados asociado2 = new Asociados(null,"Alejandro","Martínez","Rodriguez");

	asociados.save(asociado1);
	asociados.save(asociado2);

		System.out.println("El número total de asociados son: " + asociados.count());
		System.out.println("----------------------------------------");
		System.out.println("Los asociados son: ");
		System.out.println(asociados.findAll());
	}

}
