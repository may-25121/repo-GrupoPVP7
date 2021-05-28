package ar.edu.unju.fi.tp7.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp7.model.Producto;
import ar.edu.unju.fi.tp7.repository.IProductoDAO;
import ar.edu.unju.fi.tp7.service.IProductoService;

@Service("productoServiceMysql")
public class ProductoServiceImpMysql implements IProductoService{
	
	@Autowired
	IProductoDAO productoDAO;
	
	@Autowired
	private Producto producto;

	@Override
	public Producto getProducto() {
		return this.producto;
	}

	@Override
	public void addProducto(Producto producto) {
		productoDAO.save(producto);
	}

	@Override
	public Producto getUltimoProducto() {
		List<Producto> productos = (List<Producto>) productoDAO.findAll();
		Producto producto = productos.get(productos.size()-1);
		return producto;
	}

	@Override
	public List<Producto> getAllProductos() {
		List<Producto> productos= (List<Producto>) productoDAO.findAll();
		return productos;
	}

	@Override
	public Producto searchProducto(int codigo) {
		Producto producto = productoDAO.findByCodigo(codigo);
		return producto;
	}

}
