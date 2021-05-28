package ar.edu.unju.fi.tp7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp7.model.Cliente;
import ar.edu.unju.fi.tp7.service.IClienteService;

@Controller
public class ClienteController {
	
	@Autowired
	private Cliente cliente;
	
	@Autowired
	@Qualifier("clienteServiceMysql")
	private IClienteService clienteService;
	
	@GetMapping("/menu")
	public String getPrincipalPage() {
		return "index";
	}
	
	@GetMapping("/cliente/nuevo")
	public String getNuevoClientePage(Model model) {
		model.addAttribute("cliente",cliente);
		return "form-cliente";
	}
	
	@GetMapping("/cliente/modificar/{id}")
	public String modificar(@PathVariable Long id,Model model ) {
	/*	List<Cliente>cliente = clienteService.getClientes();
		model.addAttribute("clientes", cliente );*/
		return  "form-cliente";
	}
	
	@GetMapping("/cliente/borrar/{id}")
	public String borrar(@PathVariable Long id,Model model ) {
		
		return  "clientes";
	}
	
	@PostMapping("/cliente/guardar")
	public ModelAndView guardarCliente(@ModelAttribute("cliente")Cliente cliente) {
		ModelAndView model= new ModelAndView("clientes");
		clienteService.guardarCliente(cliente);
		model.addObject("clientes", clienteService.getClientes());
		return model;
	}
	
	@GetMapping("/cliente/listado")
	public ModelAndView getClienteListadoPage() {
		ModelAndView model = new ModelAndView("clientes");
		//if(clienteService.getClientes()==null) {
		//	clienteService.generarListaClientes();
	//	}
		model.addObject("clientes", clienteService.getClientes());
		return model;
	}
	

}
