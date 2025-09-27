package Ejercicios;

import java.time.LocalDate;

class MiExcepcion extends Exception {
    public MiExcepcion(String msg) {
        super(msg);
    }
}

class MatriculaVencidaExcepcion extends Exception {
    public MatriculaVencidaExcepcion(String msg) {
        super(msg);
    }
}

abstract class Vehiculo {
    double velocidad;

    public void acelerar(int velocidad) {
        try {
            if ((this.velocidad + velocidad) > 120) {
                throw new MiExcepcion(
                        "No se puede acelerar a más de 120 km/h"
                );
            } else {
                System.out.println("El " + this.getClass().getSimpleName() + " se ha acelerado " + velocidad + " km/h");
                this.velocidad += velocidad;
            }
        } catch (MiExcepcion e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Error producido por la clase " + this.getClass().getSimpleName()
            );
        }
    }

    public void frenar() {
    }
}

class Chofer {
    String nombre;
    Camion camion;
    Matricula matricula;

    public Chofer(String nombre, Matricula matricula) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.matricula.asignarChofer(this);
        try {
            if (this.comprobarMatriculaVencida(this.matricula)) {
                throw new MatriculaVencidaExcepcion("La matrícula " + this.matricula.numero + " está vencida.");
            }
        } catch (MatriculaVencidaExcepcion e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void asignarCamion(Camion camion) {
        this.camion = camion;
    }

    private boolean comprobarMatriculaVencida(Matricula matricula) {
        if (matricula.fechaVto.isBefore(LocalDate.now().minusYears(2))) {
            return true;
        } else {
            return false;
        }
    }
}

class Matricula {
    int numero;
    LocalDate fechaVto;
    Chofer chofer;

    Matricula(int numero, LocalDate fecha) {
        this.numero = numero;
        this.fechaVto = fecha;
    }

    public Matricula(int numero, LocalDate fecha, Chofer chofer) {
        this.numero = numero;
        this.fechaVto = fecha;
        this.chofer = chofer;
    }

    public void asignarChofer(Chofer chofer) {
        this.chofer = chofer;
    }
}

class Camion extends Vehiculo {
    Chofer chofer;

    public Camion(Chofer chofer) {
        this.chofer = chofer;
    }

    public void b1() {
    }
}

class Auto extends Vehiculo {
    public void c1() {
    }
}

public class ejercicioUML {
    public static void main(String[] args) {
        Auto a = new Auto();
        Matricula matricula1 = new Matricula(123, LocalDate.of(2020, 1, 1));
        Chofer chofer1 = new Chofer("Pepe", matricula1);
        Camion camion1 = new Camion(chofer1);
        chofer1.asignarCamion(camion1);
        camion1.acelerar(30);
        camion1.acelerar(100);

        Matricula matricula2 = new Matricula(236, LocalDate.of(2025, 1, 2));
        Chofer chofer2 = new Chofer("Pepe", matricula2);
        Camion camion2 = new Camion(chofer2);
        chofer2.asignarCamion(camion2);
        camion2.acelerar(100);
        camion2.acelerar(200);

        Auto auto1 = new Auto();
        auto1.acelerar(30);
        auto1.acelerar(30);
        auto1.acelerar(30);
        auto1.acelerar(30);
        auto1.acelerar(30);
    }
}
