package com.tfc.Deudak.Modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user")
public class UserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = false, length = 50)
	private String name;

	@Column(nullable = false, unique = false, length = 50)
	private String lastName;

	@Column(nullable = false, unique = true, length = 100)
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<DeudaModel> getDeudasPendientes() {
		return deudasPendientes;
	}

	public void setDeudasPendientes(List<DeudaModel> deudasPendientes) {
		this.deudasPendientes = deudasPendientes;
	}

	public List<DeudaModel> getDeudasPorCobrar() {
		return deudasPorCobrar;
	}

	public void setDeudasPorCobrar(List<DeudaModel> deudasPorCobrar) {
		this.deudasPorCobrar = deudasPorCobrar;
	}

	@Column(nullable = true, unique = true, length = 9)
	private String phone;

	@OneToMany(mappedBy = "deudor")
	private List<DeudaModel> deudasPendientes;

	@OneToMany(mappedBy = "acreedor")
	private List<DeudaModel> deudasPorCobrar;
}