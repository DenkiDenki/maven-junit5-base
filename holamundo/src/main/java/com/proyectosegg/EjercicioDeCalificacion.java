package com.proyectosegg;
import java.util.Scanner;

public class EjercicioDeCalificacion {

  public static Scanner scanner = new Scanner(System.in);
  public static void main(String[] args) throws Exception {
    int num = ingresarCalificacion();
    String nota = obtenerNota(num);
    imprimirNota(nota);
    scanner.close();
  }
  
    public static Integer ingresarCalificacion() {
      System.out.println("Ingrese una clasificación del 1 al 5: ");
      return scanner.nextInt();
    }

  public static String obtenerNota(int num) {
    String nota =
      switch (num) {
        case 1 -> "Muy deficiente";
        case 2 -> "Deficiente";
        case 3 -> "Suficiente";
        case 4 -> "Notable";
        case 5 -> "Sobresaliente";
        default -> "Opción inválida";
      };
    return nota;
  }

  public static void imprimirNota(String nota) {
    System.out.println("La nota es: " + nota);
  }
}

