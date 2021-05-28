package ar.edu.unju.fi.tp7.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp7.model.Cuenta;
import ar.edu.unju.fi.tp7.service.ICuentaService;

@Service("cuentaImp")
public class CuentaServiceImp implements ICuentaService {
	
	@Autowired
	private Cuenta cuenta;
	
	List<Cuenta> cuentas = new ArrayList<Cuenta>();

	@Override
	public Cuenta getCuenta() {
		return this.cuenta;
	}

	@Override
	public void addCuenta(Cuenta cuenta) {
		this.cuentas.add(cuenta);
		
	}

	@Override
	public List<Cuenta> getCuentas() {
		return this.cuentas;
	}

}
