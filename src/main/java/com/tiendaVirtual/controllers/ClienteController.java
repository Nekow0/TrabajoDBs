package com.nttdata.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
 // rest coontroller responde a peticiones de la URL
@Controller
@RequestMapping("/clientes") 
// este request mapping es general
public class ClienteController {
	
	@RequestMapping("")
	//model instancia la clase, pasar info de back to front, al llegar a la pagina manda info del back para el front 
	//sesion se guardan temporalmente
	
	public String clientesinicio(Model model, HttpSession session) {
		model.addAttribute("nombre", "NttData");
		model.addAttribute("apellido", "lizama");
		session.setAttribute("mensaje", "error en el nombre session");
		model.addAttribute("wasabi", "no utiliza clases");
		return "cliente.jsp";
	}
	/*
	public String clientesinicio(Model model) {
		model.addAttribute("nombre", "NttData");
		model.addAttribute("apellido", "lizama");
		model.addAttribute("wasabi", "no utiliza clases");
		return "cliente.jsp";
	} */
	
	@RequestMapping("/pagos")
	//segundo o tercer request mapping se anidan
	public String clientespagos() {
		return "estamos en clientes pagos";
	}
	@RequestMapping("/compras")
	//segundo o tercer request mapping se anidan
	public String clientescompras() {
		return "estamos en clientes compras";
	}
	//recibir parametros por URL (@PathVarible(variable) tipoDato variable)
	//el entre corchetes es lo que se captura
	@RequestMapping("/m/{rut}/{dv}")
	public String rutCliente(@PathVariable("rut") Integer rut, @PathVariable("dv") String dv ) {
		return "el rut es: "+rut+" , de digito: "+dv;
	}
}
