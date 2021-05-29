package ar.edu.unju.fi.tp7.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp7.model.Cliente;
import ar.edu.unju.fi.tp7.model.Compra;
import ar.edu.unju.fi.tp7.service.IClienteService;
import ar.edu.unju.fi.tp7.service.ICompraService;
import ar.edu.unju.fi.tp7.service.IProductoService;

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
	
	@GetMapping("/cliente/Editar/{id}")
	public ModelAndView getEditarPage(@PathVariable(value = "id")Long id) {
		ModelAndView modelView = new ModelAndView("form-cliente");
		Optional<Cliente> cliente = clienteService.getClientePorId(id);
		modelView.addObject("cliente", cliente);
		return modelView;
		
		
	}
	
	@GetMapping("/cliente/Borrar/{id}")
	public ModelAndView getBorrarPage(@PathVariable(value = "id")Long id) {
		ModelAndView modelView = new ModelAndView("redirect:/cliente/listar");
		clienteService.borrarCliente(id);
		return modelView;
		
		
	
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
