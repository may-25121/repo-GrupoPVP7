package ar.edu.unju.fi.tp7.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp7.model.Cuenta;
import ar.edu.unju.fi.tp7.repository.ICuentaDAO;
import ar.edu.unju.fi.tp7.service.ICuentaService;

@Service("cuentaServiceMysql")
public class CuentaServiceImpMysql implements ICuentaService {
	
	@Autowired
	ICuentaDAO cuentaDAO;
	
	@Autowired
	private Cuenta cuenta;

	@Override
	public Cuenta getCuenta() {
		return this.cuenta;
	}

	@Override
	public void addCuenta(Cuenta cuenta) {
		cuentaDAO.save(cuenta);
	}

	@Override
	public List<Cuenta> getCuentas() {
		List<Cuenta> cuentas = (List<Cuenta>) cuentaDAO.findAll();
		return cuentas;
	}
	

}
