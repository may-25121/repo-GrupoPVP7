package ar.edu.unju.fi.tp7.service;

import java.util.List;

import ar.edu.unju.fi.tp7.model.Cuenta;

public interface ICuentaService {
	
	public Cuenta getCuenta();
	
	public void addCuenta(Cuenta cuenta);
	
	public List<Cuenta> getCuentas();

}
