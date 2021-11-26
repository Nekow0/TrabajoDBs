package com.tiendaVirtual.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Proveedor;
import com.nttdata.repository.ProveedorRepository;

@Service
public class ProveedorService {
@Autowired
ProveedorRepository proveedorRepository;

public List<Proveedor> obtenerListaProveedor() {
	return proveedorRepository.findAll();
}

public void insertarProovedor(@Valid Proveedor proveedor) {
	// TODO Auto-generated method stub
	proveedorRepository.save(proveedor);
}
}
