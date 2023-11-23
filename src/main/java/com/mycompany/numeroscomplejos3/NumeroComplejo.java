package com.mycompany.numeroscomplejos3;

import java.util.Scanner;

public class NumeroComplejo {
    private int real;
    private int imag;

    public NumeroComplejo() {
        this.real = 0;
        this.imag = 0;
    }

    public void cargar(String numero) {
        // Separar la parte real y la parte imaginaria
        String[] partes = numero.split("\\s*\\+\\s*|\\s*\\-\\s*|\\s*i\\s*");
        
        if (partes.length == 2) {
            this.real = Integer.parseInt(partes[0]);
            this.imag = partes[1].equals("") ? 1 : Integer.parseInt(partes[1]);
        } else {
            System.out.println("Formato de número complejo no válido.");
        }
    }

    public String mostrar() {
        return this.real + (this.imag >= 0 ? " + " : " - ") + Math.abs(this.imag) + "i";
    }

    public NumeroComplejo suma(NumeroComplejo num) {
        NumeroComplejo resultado = new NumeroComplejo();
        resultado.real = this.real + num.real;
        resultado.imag = this.imag + num.imag;
        return resultado;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el primer número complejo (a + bi): ");
        String numero1 = scanner.nextLine();
        
        System.out.println("Ingrese el segundo número complejo (a + bi): ");
        String numero2 = scanner.nextLine();

        NumeroComplejo complejo1 = new NumeroComplejo();
        NumeroComplejo complejo2 = new NumeroComplejo();

        complejo1.cargar(numero1);
        complejo2.cargar(numero2);

        System.out.println("Número complejo 1: " + complejo1.mostrar());
        System.out.println("Número complejo 2: " + complejo2.mostrar());

        NumeroComplejo resultado = complejo1.suma(complejo2);

        System.out.println("Resultado de la suma: " + resultado.mostrar());
    }
}
