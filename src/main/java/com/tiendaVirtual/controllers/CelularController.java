package com.nttdata.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.models.Celular;
import com.nttdata.services.CelularService;
import com.nttdata.services.UsuarioService;

@Controller	
@RequestMapping("/celular")
public class CelularController {
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	CelularService celularService;
	@RequestMapping("")
	public String index(Model model) {
		
		//pasar objetos al jsp y adicionalmente pasar la lista de usuarios, asi que va a buscar el usuariocontroller, ver donde
		//se esta pasando la lista
		model.addAttribute("celular", new Celular());   // con estos 2 model se le pasan al jsp el celular y la lista de usuarios
		model.addAttribute("listaUsuarios", usuarioService.obtenerListaUsuarios());
		model.addAttribute("listaCelular", celularService.obtenerListaCelular());
		return "/celular/celular.jsp";
	}
	@RequestMapping("/crear")
	public String crearcelular(@Valid @ModelAttribute("celular") Celular celular) {
		//recibir el objeto cecular desde el front con el modelattribute
		celularService.insertarCelular(celular);
		return "redirect:/celular";
	}
}
