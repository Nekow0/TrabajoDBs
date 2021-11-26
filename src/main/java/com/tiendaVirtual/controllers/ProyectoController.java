package com.nttdata.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.models.Proyecto;
import com.nttdata.services.ProyectoService;
import com.nttdata.services.UsuarioService;

@Controller
@RequestMapping("/proyecto")
public class ProyectoController {

	@Autowired
	ProyectoService proyectoService;
	@Autowired
	UsuarioService usuarioService;
	@RequestMapping("")
	public String proyecto(Model model) {
		model.addAttribute("proyecto", new Proyecto());
		model.addAttribute("listaUsuarios", usuarioService.obtenerListaUsuarios());	
		return "/proyecto/proyecto.jsp";
	}
	@RequestMapping("/crearproyecto")
	public String crearproyecto(@Valid @ModelAttribute("proyecto") Proyecto proyecto) {
		proyectoService.insertarProyecto(proyecto);
		return "redirect:/proyecto";
		
	}





}
