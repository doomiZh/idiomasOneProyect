package pe.com.pi.idiomasone.service;

import java.util.List;

import pe.com.pi.idiomasone.model.Idiomas;


public interface IdiomasService {
	
	List<Idiomas> obtenerIdiomas();
	
	Idiomas registrar(Idiomas idiomas);
	
	void eliminar(Long id);
}
