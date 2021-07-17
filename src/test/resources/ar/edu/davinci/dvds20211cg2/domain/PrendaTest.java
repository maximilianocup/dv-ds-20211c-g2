package ar.edu.davinci.dvds20211cg2.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class PrendaTest {

	@Test
	void testBuilder() {
		// Given
		Long id = 1L;
		String descripcion = "Camisa";
		TipoPrenda tipo = TipoPrenda.CAMISA;
		BigDecimal precioBase = new BigDecimal(10);
		
		
		// When
		Prenda prenda = Prenda.builder()
				.id(id)
				.descripcion(descripcion)
				.tipo(tipo)
				.precioBase(precioBase)
				.build();
				
		
		//Then
		assertNotNull(prenda);
		assertEquals(id, prenda.getId());
		assertEquals(descripcion, prenda.getDescripcion());
		assertEquals(tipo, prenda.getTipo());
		assertEquals(precioBase, prenda.getPrecioBase());
		
	}

}
