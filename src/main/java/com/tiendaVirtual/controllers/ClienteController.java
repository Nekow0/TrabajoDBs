package com.nttdata.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.models.Cliente;
import com.nttdata.services.ClienteService;
import com.nttdata.services.ProveedorService;

@Controller
@RequestMapping("/clientes") 
public class ClienteController {
	@Autowired
	ClienteService clienteService;
	@Autowired
	ProveedorService proveedorService;
	@RequestMapping("")
	public String index(Model model) {
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("listaClientes", clienteService.obtenerListaClientes());
		model.addAttribute("listaProveedores", proveedorService.obtenerListaProveedor());
		return "cliente.jsp";
	}
	@RequestMapping("/crear")
	public String crearcliente(@Valid @ModelAttribute("cliente") Cliente cliente) {
		clienteService.insertarCliente(cliente);
		return "redirect:/cliente";
	}
	
	
	/*
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
	} 
	
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
	*/
}
