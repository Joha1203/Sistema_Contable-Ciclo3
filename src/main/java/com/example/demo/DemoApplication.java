package com.example.demo;

import com.example.demo.modelos.Empleado;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);
		var lista = Arrays.asList("nombre","correo","empresa","rol del empleado(administrador, operativo)");
		var datos = new ArrayList<String>(3);
		Scanner sc = new Scanner(System.in);

		for (String i:lista) {
			System.out.print(String.format("Ingrese %s: ",i));
			String valor = sc.nextLine();
			datos.add(valor);
		}

		System.out.println(new Empleado(datos.get(0),datos.get(1),datos.get(2),datos.get(3)));

	}

}
