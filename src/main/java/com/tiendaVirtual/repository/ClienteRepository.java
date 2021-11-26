package com.nttdata.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nttdata.models.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	List<Cliente> findAll();
}
