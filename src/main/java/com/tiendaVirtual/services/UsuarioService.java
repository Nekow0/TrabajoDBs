package com.nttdata.services;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nttdata.models.Usuario;
import com.nttdata.repository.UsuarioRepository;



@Service
public class UsuarioService {
//coneccio con repository	
@Autowired
UsuarioRepository usuarioRepository;


public void insertarUsuario(@Valid Usuario usuario) {
	// TODO Auto-generated method stub
	usuarioRepository.save(usuario);
}


public List<Usuario> obtenerListaUsuarios() {
	// TODO Auto-generated method stub
	return usuarioRepository.findAll();
}


public void eliminarUsuario(@Valid Long id) {
	// TODO Auto-generated method stub
	usuarioRepository.deleteById(id);
}

public void eliminarUsuarioObjeto(Usuario usuario) {
	usuarioRepository.delete(usuario);
}

public Usuario buscarUsuarioId(Long id) {
	return usuarioRepository.findById(id).get();
	
}


public void modificarObjeto(Usuario usuario) {
	 usuarioRepository.save(usuario);
	
}
}
