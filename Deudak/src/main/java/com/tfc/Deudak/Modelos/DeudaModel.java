package com.tfc.Deudak.Modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "deuda")
public class DeudaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 100)
	private String description;

	@Column(nullable = false)
	private double quantity;

	@Column(nullable = false)
	private boolean paid;

	// Usuario que debe el dinero
	@ManyToOne
	@JoinColumn(name = "deudor_id", nullable = false)
	private UserModel deudor;

	// Usuario al que se le debe el dinero
	@ManyToOne
	@JoinColumn(name = "acreedor_id", nullable = false)
	private UserModel acreedor;
}