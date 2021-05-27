package ar.edu.unju.fi.tp7.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.fi.tp7.model.Producto;
import ar.edu.unju.fi.tp7.repository.IProductoDAO;
import ar.edu.unju.fi.tp7.service.IProductoService;

public class ProductoServiceImpMysql implements IProductoService{
	
	@Autowired
	IProductoDAO productoDAO;

	@Override
	public Producto getProducto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProducto(Producto producto) {
		productoDAO.save(producto);
		
	}

	@Override
	public Producto getUltimoProducto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> getAllProductos() {
		List<Producto> productos= (List<Producto>) productoDAO.findAll();
		return productos;
	}

	@Override
	public Producto searchProducto(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

}
