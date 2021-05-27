package ar.edu.unju.fi.tp7.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp7.model.Compra;
import ar.edu.unju.fi.tp7.repository.ICompraDAO;
import ar.edu.unju.fi.tp7.service.ICompraService;

@Service("compraServiceMysql")
public class CompraServiceImpMysql implements ICompraService{
	
	@Autowired
	ICompraDAO compraDAO;

	@Override
	public Compra getCompra() {
		
		return null;
	}

	@Override
	public void agregarCompra(Compra compra) {
		compraDAO.save(compra);
		
	}

	@Override
	public List<Compra> obtenerCompras() {
		List<Compra> compras = (List<Compra>) compraDAO.findAll();
		return compras;
	}

}
