package ar.edu.unju.fi.tp7.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp7.model.Cliente;
import ar.edu.unju.fi.tp7.repository.IClienteDAO;
import ar.edu.unju.fi.tp7.service.IClienteService;

@Service("clienteServiceMysql")
public class ClienteServiceImpMysql implements IClienteService{
	
	@Autowired
	IClienteDAO clienteDAO;
	
	@Autowired
	private Cliente cliente;

	@Override
	public void guardarCliente(Cliente cliente) {
		clienteDAO.save(cliente);
	}

	@Override
	public void addCliente(Cliente cliente) {
		clienteDAO.save(cliente);
	}

	@Override
	public List<Cliente> getClientes() {
		List<Cliente> clientes = (List<Cliente>) clienteDAO.findAll();
		return clientes;
	}

	@Override
	public void generarListaClientes() {
		// TODO Auto-generated method stub
		
	}

}
