package com.tiendaVirtual.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tiendaVirtual.models.Proveedor;

@Repository
public interface ProveedorRepository extends CrudRepository<Proveedor,Long>{
	List<Proveedor> findAll();
}
