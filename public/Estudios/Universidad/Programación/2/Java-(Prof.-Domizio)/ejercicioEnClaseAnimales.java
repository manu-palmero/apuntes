class Animal {
	String raza;
	int edad;
	static int machos = 0;
	static int hembras = 0;
	boolean esMacho;
	
	public Animal() {}
	public Animal(String raza, int edad) {
		this.raza = raza;
		this.edad = edad;
	}
	public Animal(String raza, int edad, boolean esMacho) {
		this.raza = raza;
		this.edad = edad;
		this.esMacho = esMacho;
		if (esMacho) {
			Animal.machos ++;
		} else {
			Animal.hembras ++;
		}
	}
	
	public void aumentarMachos() {
		Animal.machos ++;
	}

	public void aumentarHembras() {
		Animal.hembras ++;
	}

	public void mostrarDatos() {
		System.out.println("Raza: " + raza);
		System.out.println("Edad: " + edad);
		System.out.println("Machos: " + machos);
		System.out.println("Hembras: " + hembras);
	}
	
}

public class Main {
	public static void main(String[] args) {
		Animal perro = new Animal("Pastor Aleman", 5, true);
		Animal gato = new Animal("Siames", 3, false);
		Animal loro = new Animal("Ara", 2, true);
		Animal gato2 = new Animal("Carey", 1, false);
		
		// perro.aumentarMachos();
		// gato.aumentarHembras();
		// loro.aumentarHembras();
		gato2.aumentarHembras();
		
		perro.mostrarDatos();
		gato.mostrarDatos();
		loro.mostrarDatos();
		gato2.mostrarDatos();
	}
}
