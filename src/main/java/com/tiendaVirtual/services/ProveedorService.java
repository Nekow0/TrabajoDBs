package com.tiendaVirtual.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendaVirtual.models.Proveedor;
import com.tiendaVirtual.repositories.ProveedorRepository;

@Service
public class ProveedorService {
@Autowired
ProveedorRepository proveedorRepository;

public List<Proveedor> obtenerListaProveedor() {
	return proveedorRepository.findAll();
}

public void insertarProovedor(@Valid Proveedor proveedor) {
	
	proveedorRepository.save(proveedor);
}
}
