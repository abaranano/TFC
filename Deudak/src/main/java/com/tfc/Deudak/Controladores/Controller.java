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
    public String guardarDeuda(@RequestParam long deudorId, @RequestParam long acreedorId,
                               @ModelAttribute DeudaModel deuda) {
        UserModel deudor = userRepository.findById(deudorId).orElseThrow();
        UserModel acreedor = userRepository.findById(acreedorId).orElseThrow();

        deuda.setDeudor(deudor);
        deuda.setAcreedor(acreedor);

        deudaRepository.save(deuda);
        return "redirect:/deudas/lista";
    }

	
    @GetMapping("/lista")
    public String listarDeudas(Model model) {
        model.addAttribute("deudas", deudaRepository.findAll());
        return "deuda_lista";
    }
}