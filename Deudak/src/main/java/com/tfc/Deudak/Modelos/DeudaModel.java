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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public UserModel getDeudor() {
		return deudor;
	}

	public void setDeudor(UserModel deudor) {
		this.deudor = deudor;
	}

	public UserModel getAcreedor() {
		return acreedor;
	}

	public void setAcreedor(UserModel acreedor) {
		this.acreedor = acreedor;
	}

	// Usuario que debe el dinero
	@ManyToOne
	@JoinColumn(name = "deudor_id", nullable = false)
	private UserModel deudor;

	// Usuario al que se le debe el dinero
	@ManyToOne
	@JoinColumn(name = "acreedor_id", nullable = false)
	private UserModel acreedor;

	
	
	
}