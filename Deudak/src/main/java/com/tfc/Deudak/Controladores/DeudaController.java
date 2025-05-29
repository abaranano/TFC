package com.tfc.Deudak.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tfc.Deudak.Modelos.DeudaModel;
import com.tfc.Deudak.Modelos.UserModel;
import com.tfc.Deudak.Repositorios.DeudaRepository;
import com.tfc.Deudak.Repositorios.UserRepository;

@org.springframework.stereotype.Controller
@RequestMapping("/deudas")
public class DeudaController {

	@Autowired
	private DeudaRepository deudaRepository;

	@Autowired
	private UserRepository userRepository;

	// ACCEDER AL INDEX
	@GetMapping("/")
	public String index() {
		return "index";
	}

	// CREAR DEUDAS
	@GetMapping("/deudaNueva")
	public String mostrarFormularioDeuda(Model model) {
		model.addAttribute("deuda", new DeudaModel());
		model.addAttribute("usuarios", userRepository.findAll());
		return "deudas/deuda_form";
	}

	@PostMapping("/save")
	public String guardarDeuda(@RequestParam long deudorId, @RequestParam long acreedorId,
			@ModelAttribute DeudaModel deuda) {

		UserModel deudor = userRepository.findById(deudorId).orElseThrow();
		UserModel acreedor = userRepository.findById(acreedorId).orElseThrow();

		deuda.setDeudor(deudor);
		deuda.setAcreedor(acreedor);

		deudaRepository.save(deuda);
		return "redirect:/usuarios/userList";
	}

	// DAR DEUDA COMO PAGADA
	@PostMapping("/pagada/{id}")
	public String deudaPagada(@PathVariable("id") Long id) {
		DeudaModel deuda = deudaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("ID de deuda inválido: " + id));

		deuda.setPaid(true);
		deudaRepository.save(deuda);

		return "redirect:/usuarios/userList";
	}

	// ELIMINAR DEUDAS
	@GetMapping("/eliminar/{id}")
	public String eliminarDeuda(@PathVariable("id") Long id) {
		deudaRepository.deleteById(id);
		return "redirect:/usuarios/userList";
	}

}
