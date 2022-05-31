package pe.com.pi.idiomasone.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.pi.idiomasone.model.Rol;
import pe.com.pi.idiomasone.repository.RolRepository;
import pe.com.pi.idiomasone.service.RolService;

@Service
public class RolServiceImpl implements RolService{
	
	@Autowired
    private RolRepository rolRep;

	@Override
	public List<Rol> listarRol() {
		return (List<Rol>)rolRep.findAll();
	}
	
	

}
