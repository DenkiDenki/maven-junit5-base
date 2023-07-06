package com.proyectosegg;
/* *
import org.junit.jupiter.api.Test;*/

//import static org.junit.jupiter.api.Assertions.assertTrue;
/* 
class ApplicationTest {

    @Test
    void shouldAnswerWithTrue() {
        assertTrue(true);
    }
}*/
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class EjercicioDeCalificacionTest {

  private InputStream standarIn = System.in;
  private final PrintStream standarout = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @BeforeEach
  void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @AfterEach
  public void tearDown() {
    System.setOut(standarout);
    System.setIn(standarIn);
  }

  @Test
  void testIngresarCalificacion() {
    ByteArrayInputStream in = new ByteArrayInputStream("2\n".getBytes());
    System.setIn(in);

    Integer calificacion = EjercicioDeCalificacion.ingresarCalificacion();
    Assertions.assertEquals(2, calificacion);
  }

  @ParameterizedTest
  @CsvSource({"1, Muy deficiente", "2, Deficiente", "3, Suficiente", "4, Notable", "5, Sobresaliente", "6, Opción inválida"})
  void testObtenerNota(Integer numero, String nota) {
    String notaPrueba = EjercicioDeCalificacion.obtenerNota(numero);
    Assertions.assertEquals(nota, notaPrueba);
  }

  @ParameterizedTest
  @CsvSource({"Muy deficiente", "Deficiente", "Suficiente", "Notable", "Sobresaliente", "Opción inválida"})
  void testImprimirNota(String nota) {
    EjercicioDeCalificacion.imprimirNota(nota);
    String salida = outputStreamCaptor.toString();
    Assertions.assertEquals("La nota es: " + nota + "\r\n", salida);
  }
}