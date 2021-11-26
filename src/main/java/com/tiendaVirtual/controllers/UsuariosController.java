package com.nttdata.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nttdata.models.Usuario;
import com.nttdata.services.UsuarioService;


@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
	//conectar con services (inyeccion de dependencias) y services se conecta con repository

	//autowired conecta clases de dinstintos packages, por cada inyeccion se debe agregar un autowired, 2 autowired
	// para 2 inyecciones
	@Autowired
	UsuarioService usuarioService;

	@RequestMapping("")
	//inicialmente despliega en pantalla el jsp
	public String usuario(@ModelAttribute("usuario") Usuario usuario, Model model) {
		//lista de usuarios
		//segundo argumento, es el llamado
		
		//List<Usuario> listausuarios= usuarioService.obtenerListaUsuarios();
		model.addAttribute("listaUsuarios",usuarioService.obtenerListaUsuarios());
	//forma 2 de pasar la clase hacia el front	model.addAttribute("usuario", new Usuario());
		return "usuarios.jsp";
	}
	//capturar la info del jsp
	@RequestMapping("/login")
	/*public String login(@RequestParam("nombre") String nombre, @RequestParam("apellido") String apellido,
			@RequestParam("limite") String limite, @RequestParam("codigoPostal") String codigoPostal) */
		String login(@Valid @ModelAttribute("usuario") Usuario usuario, Model model)
	{
		System.out.println(usuario.getNombre()+" "+usuario.getApellido()+" "+usuario.getLimite()+" "+usuario.getCodigoPostal()); 
	
	////////////////////
	/*
	int i = Integer.parseInt(usuario.getLimite());
	if(i > 0) {
		System.out.println("es mayor que cero");
	}
	*/
	
		usuarioService.insertarUsuario(usuario);
		
		
		return "redirect:/usuarios";
		
		
	}
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("id") Long id) {
		Usuario usuario = usuarioService.buscarUsuarioId(id);
		if(usuario == null) {
			return "redirect:/usuarios";
		}
		//esto se cae si no se existe el usuario
		else {
		usuarioService.eliminarUsuarioObjeto(usuario);
		return "redirect:/usuarios";
		}
	}
/*	@RequestMapping("/modificar")
	public String modificar(@RequestParam("id") Long id, Model model) {
		Usuario usuario = usuarioService.buscarUsuarioId(id);
		if(usuario != null) {
			//primer atriburo apunta al jsp, el segundo el nombre del objeto
			model.addAttribute("usuarios", usuario);
			return "modusuarios.jsp";
		}
		return "redirect:/usuarios";
	}
	*/
}
