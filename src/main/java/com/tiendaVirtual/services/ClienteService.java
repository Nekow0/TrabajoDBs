package com.tiendaVirtual.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendaVirtual.models.Cliente;
import com.tiendaVirtual.repositories.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	ClienteRepository clienteRepository;

	public List<Cliente> obtenerListaClientes() {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}

	public void insertarCliente(@Valid Cliente cliente) {
		clienteRepository.save(cliente);

	}

}
