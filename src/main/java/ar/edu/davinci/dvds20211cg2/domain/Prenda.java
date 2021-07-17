package ar.edu.davinci.dvds20211cg2.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Parte de la configuración de JPA
@Entity
@Table(name="prendas")

// Configuración de lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Prenda {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "prd_id")
	private Long id;
	
	@Column(name = "prd_descripcion")
	private String descripcion;

	@Column(name = "prd_tipo_prenda")
	@Enumerated(EnumType.STRING)
	private TipoPrenda tipo;
	
	@Column(name = "prd_precio_base")
	private BigDecimal precioBase;
	
}

