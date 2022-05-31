package pe.com.pi.idiomasone.service;

import java.util.List;

import pe.com.pi.idiomasone.model.Usuarios;

public interface UsuariosService {
	
	public List<Usuarios>listarUsuario();

    public void guardar(Usuarios usuario);
    public void eliminar(Usuarios usuario);

    public Usuarios encontrarUsuario(Usuarios usuario);

}
