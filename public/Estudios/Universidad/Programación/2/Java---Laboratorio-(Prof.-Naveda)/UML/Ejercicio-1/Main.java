public class Main {
    public static void main(String[] args) {
        // Crear instancias de las figuras
        // y lados para probar la jerarquía de clases

        // Crear lados para las figuras
        Lado lado1 = new Lado(1.0, 2.0);
        Lado lado2 = new Lado(3.0, 4.0);
        Lado lado3 = new Lado(5.0, 6.0);
        Lado lado4 = new Lado(7.0, 8.0);

        // Crear un arreglo de lados para el rectángulo y el cuadrado
        // y un arreglo de lados para el triángulo
        Lado[] lados4 = { lado1, lado2, lado3, lado4 };
        Lado[] lados3 = { lado1, lado2, lado3 };

        // Crear instancias de las figuras
        Circulo circulo = new Circulo();
        Rectangulo rectangulo = new Rectangulo(lados4);
        Cuadrado cuadrado = new Cuadrado(lados4);
        Triangulo triangulo = new Triangulo(lados3);

        // Imprimir el número de lados de cada figura
        System.out.println("Rectangulo: " + rectangulo.getNumLados());
        System.out.println("Cuadrado: " + cuadrado.getNumLados());
        System.out.println("Triangulo: " + triangulo.getNumLados());
    }
}