package com.tfc.Deudak.Controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tfc.Deudak.Modelos.UserModel;
import com.tfc.Deudak.Repositorios.DeudaRepository;
import com.tfc.Deudak.Repositorios.UserRepository;

@org.springframework.stereotype.Controller
@RequestMapping("/usuarios")
public class Controller {

	@Autowired
	private DeudaRepository deudaRepository;

	@Autowired
	private UserRepository userRepository;

	// ACCEDER AL INDEX
	@GetMapping("/")
	public String index() {
		return "index";
	}

	// Metodos para Listar o ver Usuarios
	@GetMapping("/userList")
	public String listarUsuarios(Model model) {
		List<UserModel> usuarios = userRepository.findAll();
		model.addAttribute("usuarios", usuarios);
		return "usuarios/lista";
	}

	@GetMapping("/user/{id}")
	public String verUsuario(@PathVariable Long id, Model model) {
		Optional<UserModel> usuario = userRepository.findById(id);
		if (usuario.isPresent()) {
			model.addAttribute("usuario", usuario.get());
			return "usuarios/ver";
		} else {
			return "redirect:/usuarios";
		}
	}

	// Metodos para crear usuarios
	@GetMapping("/crear")
	public String mostrarFormularioCreacion(Model model) {
		model.addAttribute("usuario", new UserModel());
		return "usuarios/formulario";
	}

	@PostMapping("/guardar")
	public String guardarUsuario(@ModelAttribute UserModel usuario) {
		userRepository.save(usuario);
		return "redirect:/usuarios/";
	}

	// Metodos para eleminar usuarios
	@GetMapping("/eliminar/{id}")
	public String eliminarUsuario(@PathVariable Long id) {
		userRepository.deleteById(id);
		return "redirect:/usuarios/";
	}

}