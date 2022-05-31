package pe.com.pi.idiomasone.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.pi.idiomasone.model.Usuarios;
import pe.com.pi.idiomasone.repository.UsuariosRepository;
import pe.com.pi.idiomasone.service.UsuariosService;

@Service
public class UsuariosServiceImpl implements UsuariosService{

	@Autowired
    private UsuariosRepository usuarioRep;

    @Override
    @Transactional(readOnly=true)
    public List<Usuarios> listarUsuario() {
        return (List<Usuarios>)usuarioRep.findAll();
    }

    @Override
    @Transactional
    public void guardar(Usuarios usuarios) {
    	usuarioRep.save(usuarios);
    }

    @Override
    @Transactional
    public void eliminar(Usuarios usuarios) {
    	usuarioRep.delete(usuarios);

    }

    @Override
    @Transactional(readOnly = true)
    public Usuarios encontrarUsuario(Usuarios usuarios) {
        return usuarioRep.findById(usuarios.getId_usuario()).orElse(null);
    }
	
	

}
