package pe.com.pi.idiomasone.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.pi.idiomasone.model.Usuarios;
import pe.com.pi.idiomasone.service.RolService;
import pe.com.pi.idiomasone.service.UsuariosService;

@RequestMapping("/usuario")
@Controller
public class UsuariosController {

	@Autowired
	private RolService rolService;

	@Autowired
	private UsuariosService usuarioService;

	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("rol", rolService.listarRol());
		model.addAttribute("usuario", usuarioService.listarUsuario());
		return "listaUsuario";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("rol", rolService.listarRol());
		model.addAttribute("usuario", new Usuarios());
		return "saveUsuario";
	}

	@PostMapping("/save")
	public String save(@Valid Usuarios usuario, Model model, Errors errores) {
		if (errores.hasErrors()) {
			model.addAttribute("rol", rolService.listarRol());
			return "saveUsuario";
		} else {
			usuarioService.guardar(usuario);
			return "redirect:/usuario/listar";
		}
	}

	@GetMapping("/edit/{id_usuario}")
	public String edit(Usuarios usuarios, Model model) {
		usuarios = usuarioService.encontrarUsuario(usuarios);
		model.addAttribute("usuario", usuarios);
		model.addAttribute("rol", rolService.listarRol());
		return "editarUsuario";
	}

	@GetMapping("/delete/{id_usuario}")
	public String delete(Usuarios usuarios) {
		usuarioService.eliminar(usuarios);
		return "redirect:/usuario/listar";
	}

}
