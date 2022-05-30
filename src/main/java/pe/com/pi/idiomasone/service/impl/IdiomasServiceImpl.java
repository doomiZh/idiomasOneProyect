package pe.com.pi.idiomasone.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.pi.idiomasone.model.Idiomas;
import pe.com.pi.idiomasone.repository.IdiomasRepository;
import pe.com.pi.idiomasone.service.IdiomasService;

@Service
public class IdiomasServiceImpl implements IdiomasService{

	@Autowired
	private IdiomasRepository idiomasRepository;
	
	@Override
	public List<Idiomas> obtenerIdiomas() {
		return (List<Idiomas>)idiomasRepository.findAll();
	}

	@Override
	public Idiomas registrar(Idiomas idiomas) {
		return idiomasRepository.save(idiomas);
	}

	@Override
	public void eliminar(Long id) {
		idiomasRepository.deleteById(id);
		
	}

}
