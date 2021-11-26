package com.nttdata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Cliente;
import com.nttdata.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	ClienteRepository clienteRepository;

	public List<Cliente> obtenerListaClientes() {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}

}
