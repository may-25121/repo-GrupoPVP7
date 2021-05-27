package ar.edu.unju.fi.tp7.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tp7.model.Cliente;

public interface IClienteDAO extends CrudRepository<Cliente, Long> {
	
	

}
