package com.quind.calculadora;
import com.quind.calculadora.controlador.ControladorCalculadora;

import com.quind.calculadora.modelo.Resultados;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CalculadoraApplicationTests {

	Resultados resultadoOperacion = new Resultados();
	ControladorCalculadora controlador = new ControladorCalculadora();


	@Test
	void testSuma() {
		Resultados localResult = controlador.suma("20","80");

		//Comparacion
		resultadoOperacion.setResultados(100);
		resultadoOperacion.setEstado("OK");

		assertEquals(resultadoOperacion.getEstado(),localResult.getEstado());
		assertEquals(resultadoOperacion.getResultados(),localResult.getResultados());
	}


	@Test
	void testResta() {
		Resultados localResult = controlador.resta("60","20");

		//Comparacion
		resultadoOperacion.setResultados(40);
		resultadoOperacion.setEstado("OK");

		assertEquals(resultadoOperacion.getEstado(),localResult.getEstado());
		assertEquals(resultadoOperacion.getResultados(),localResult.getResultados());
	}


	@Test
	void testMultiplicacion() {
		Resultados localResult = controlador.multiplicacion("60","20");

		//Comparacion
		resultadoOperacion.setResultados(1200);
		resultadoOperacion.setEstado("OK");

		assertEquals(resultadoOperacion.getEstado(),localResult.getEstado());
		assertEquals(resultadoOperacion.getResultados(),localResult.getResultados());
	}




	@Test
	void testDivision() {
		Resultados localResult = controlador.division("60","20");

		//Comparacion
		resultadoOperacion.setResultados(3);
		resultadoOperacion.setEstado("OK");

		assertEquals(resultadoOperacion.getEstado(),localResult.getEstado());
		assertEquals(resultadoOperacion.getResultados(),localResult.getResultados());
	}


	@Test
	void testDivisionCero() {
		Resultados localResult = controlador.division("60","0");

		//Comparacion

		resultadoOperacion.setEstado("Error: La división por cero no permitida");

		assertEquals(resultadoOperacion.getEstado(),localResult.getEstado());

	}
}
