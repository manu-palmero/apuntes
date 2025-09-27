package com.manuel_palmero;

class Rectangulo {
	public float base;
	protected float altura;
	private String color;

	public Rectangulo() {
	}

	public Rectangulo(float base, float altura, String color) {
		this.base = base;
		this.altura = altura;
		this.color = color;
	}

	public void mostrarTodos(){
		System.out.println("Base: " + base);
		System.out.println("Altura: " + altura);
		System.out.println("Color: " + color);
	}
}
