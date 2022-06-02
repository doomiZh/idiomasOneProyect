package pe.com.pi.idiomasone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.pi.idiomasone.model.Idiomas;
import pe.com.pi.idiomasone.service.IdiomasService;

@Controller
@RequestMapping("/idiomas")
public class IdiomasController {
	
	@Autowired
	private IdiomasService idiomasService;
	
	@GetMapping
	public String listIdioma(Model idio) {
		idio.addAttribute("listarIdioma", idiomasService.obtenerIdiomas());
		return "idiomas/listar";
	}
	
	@GetMapping("/nuevo")
	public String IdiomaNuevo(Model idio) {
		idio.addAttribute("idiomas", new Idiomas());
		idio.addAttribute("listarIdioma", idiomasService.obtenerIdiomas());
		return "idiomas/nuevo";
	}
	

}
