package com.tfc.Deudak.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tfc.Deudak.Modelos.DeudaModel;
import com.tfc.Deudak.Repositorios.DeudaRepository;
import com.tfc.Deudak.Repositorios.UserRepository;

@org.springframework.stereotype.Controller
@RequestMapping("/deudas")
public class Controller {

	@Autowired
	private DeudaRepository deudaRepository;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		model.addAttribute("deuda", new DeudaModel());
		model.addAttribute("usuarios", userRepository.findAll());
		return "deuda_form.html";
	}

	@PostMapping("/save")
	public String guardarDeuda(@ModelAttribute DeudaModel deuda) {
		deudaRepository.save(deuda);
		return "redirect:/deudas/lista";
	}
}