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

	@Column(nullable = true, unique = true, length = 9)
	private String phone;

	@OneToMany(mappedBy = "deudor")
	private List<DeudaModel> deudasPendientes;

	@OneToMany(mappedBy = "acreedor")
	private List<DeudaModel> deudasPorCobrar;
}