package com.nttdata.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.models.Proveedor;
import com.nttdata.services.ClienteService;
import com.nttdata.services.ProveedorService;

@Controller
@RequestMapping("/proveedor")
// recibir datos desde la vista
public class ProveedorController {
	@Autowired
	ProveedorService proveedorService;
	@Autowired
	ClienteService clienteService;
	@RequestMapping("")
	// lo primero es que cuando se llega a la pagina, llame al jsp para rellenar el formulario
	public String index(Model model) {
		model.addAttribute("proveedor", new Proveedor());
		model.addAttribute("listaClientes", clienteService.obtenerListaClientes());
		model.addAttribute("listaProveedor", proveedorService.obtenerListaProveedor());
		return "proveedor.jsp";
	}
	@RequestMapping("/crear")
	public String crearproveedor(@Valid @ModelAttribute("proveedor") Proveedor proveedor) {
		proveedorService.insertarProovedor(proveedor);
		return "redirect:/proveedor";
	}
	/*
	// captura de los datos a travez de un formulario, el nombre en el request param, apunta al name en el jsp no a la ID
	// cuando son muchos valores que se tiene que capturar es mejor pasar el objeto.
	public String insertar(@RequestParam("nombre") String nombre, @RequestParam("apellido") String apellido, 
			@RequestParam("email") String email, @RequestParam("edad") String edad) {
		System.out.println("el nombre es: "+nombre);
		System.out.println("el apellidoasd es: "+apellido);
		if(edad.isEmpty()) {
			System.out.println("No puede ser vacio");
		}
		//return "proveedor.jsp"; // este return llega a proveedor pero despues se va directamente a insertar por el mapping
		return "redirect:/proveedor";
	}
	*/

	
}
