package com.nttdata.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
//aca se realiza la coneccion con la base de datoss
import org.springframework.stereotype.Repository;

import com.nttdata.models.Usuario;

@Repository
//crudrepositvory(objeto, tipo de dato de la primary key)
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	List<Usuario> findAll();
}
