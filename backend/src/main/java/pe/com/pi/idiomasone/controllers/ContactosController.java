package pe.com.pi.idiomasone.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.com.pi.idiomasone.model.Contactos;
import pe.com.pi.idiomasone.repository.ContactosRepository;

@Controller
@RequestMapping("")
public class ContactosController {

    @Autowired
    private ContactosRepository contactosRepository;

    @GetMapping("/listaC")
    public String verPaginaDeInicio(Model modelo) {
        List<Contactos> contactos = contactosRepository.findAll();
        modelo.addAttribute("contactos", contactos);
        return "index";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeRegistrarContacto(Model modelo) {
        modelo.addAttribute("contacto", new Contactos());
        return "nuevo";
    }

    @PostMapping("/nuevo")
    public String guardarContacto(@Validated Contactos contacto, BindingResult bindingResult, RedirectAttributes redirect, Model modelo) {
//        if (bindingResult.hasErrors()) {
//            modelo.addAttribute("contacto", contacto);
//            return "nuevo";
//        }

        contactosRepository.save(contacto);
        redirect.addFlashAttribute("msgExito", "El contacto ha sido agregado con exito");
        return "redirect:/listaC";
    }

    @GetMapping("/{id}/editar")
    public String mostrarFormularioDeEditarContacto(@PathVariable Long id, Model modelo) {
        Contactos contacto = contactosRepository.getById(id);
        modelo.addAttribute("contacto", contacto);
        return "actualizar";
    }

    @PostMapping("/{id}/editar")
    public String actualizarContacto(@PathVariable Long id, @Validated Contactos contacto, BindingResult bindingResult, RedirectAttributes redirect, Model modelo) {
        Contactos contactoDB = contactosRepository.getById(id);
        if (bindingResult.hasErrors()) {
            modelo.addAttribute("contacto", contacto);
            return "actualizar";
        }

        contactoDB.setNombre(contacto.getNombre());
        contactoDB.setCelular(contacto.getCelular());
        contactoDB.setEmail(contacto.getEmail());
        contactoDB.setFechaClase(contacto.getFechaClase());

        contactosRepository.save(contactoDB);
        redirect.addFlashAttribute("msgExito", "El contacto ha sido actualizado correctamente");
        return "redirect:/listaC";
    }

    @PostMapping("/{id}/eliminar")
    public String eliminarContacto(@PathVariable Long id, RedirectAttributes redirect) {
        Contactos contacto = contactosRepository.getById(id);
        contactosRepository.delete(contacto);
        redirect.addFlashAttribute("msgExito", "El contacto ha sido eliminado correctamente");
        return "redirect:/listaC";
    }
    
}
