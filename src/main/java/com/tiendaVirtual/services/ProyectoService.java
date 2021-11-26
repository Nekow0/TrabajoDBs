package com.nttdata.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Proyecto;
import com.nttdata.repository.ProyectoRepository;
@Service
public class ProyectoService {
@Autowired
ProyectoRepository proyectoRepository;
	public void insertarProyecto(@Valid Proyecto proyecto) {
		// TODO Auto-generated method stub
		proyectoRepository.save(proyecto);
	}
public List<Proyecto> obtenerListaProyecto(){
	return proyectoRepository.findAll();
	}
}
