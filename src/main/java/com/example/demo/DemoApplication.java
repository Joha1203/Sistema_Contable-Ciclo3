package com.example.demo;

import com.example.demo.modelos.Empleado;
import com.example.demo.modelos.MovimientoDinero;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);
		var lista = Arrays.asList("monto del movimiento","concepto","remitente");
		var datos = new ArrayList<String>(2);
		Scanner sc = new Scanner(System.in);

		for (String i:lista) {
			System.out.printf("Ingrese %s: ",i);
			String valor = sc.nextLine();
			datos.add(valor);
		}

		System.out.println(new MovimientoDinero(Double.valueOf(datos.get(0)),datos.get(1),datos.get(2)));

	}

}
