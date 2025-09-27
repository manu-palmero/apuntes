package com.manuel_palmero;

import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Rectangulo[] rectangulos = new Rectangulo[5];
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Primer rectángulo");
		System.out.print("Introduce la base del rectángulo: ");
		float base1 = sc.nextFloat();
		System.out.print("Introduce la altura del rectángulo: ");
		float altura1 = sc.nextFloat();
		System.out.print("Introduce el color del rectángulo: ");
		String color1 = sc.next();

		System.out.println("Segundo rectángulo");
		System.out.print("Introduce la base del rectángulo: ");
		float base2 = sc.nextFloat();
		System.out.print("Introduce la altura del rectángulo: ");
		float altura2 = sc.nextFloat();
		System.out.print("Introduce el color del rectángulo: ");
		String color2 = sc.next();

		sc.close();

		Rectangulo rectangulo1 = new Rectangulo(base1, altura1, color1);
		rectangulos[0] = rectangulo1;
		Rectangulo rectangulo2 = new Rectangulo(base2, altura2, color2);
		rectangulos[1] = rectangulo2;

		rectangulos[0].mostrarTodos();
		rectangulos[1].mostrarTodos();

	}

}
