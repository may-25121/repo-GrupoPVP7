package ar.edu.unju.fi.tp7.service;



import java.util.List;

import ar.edu.unju.fi.tp7.model.Compra;

public interface ICompraService {
public Compra getCompra();
	
	public void  agregarCompra(Compra compra);
  	
  	public List<Compra> obtenerCompras();

	

}
