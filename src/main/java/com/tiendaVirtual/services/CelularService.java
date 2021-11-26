package com.nttdata.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Celular;
import com.nttdata.repository.CelularRepository;

@Service
public class CelularService {
@Autowired
CelularRepository celularRepository;

public void insertarCelular(@Valid Celular celular) {
	// TODO Auto-generated method stub
	celularRepository.save(celular);
}
public List<Celular> obtenerListaCelular(){
	return celularRepository.findAll();
}
}
