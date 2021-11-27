package com.uisrael.Hospital.controlador.impl;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.Hospital.controlador.ProductoControlador;
import com.uisrael.Hospital.modelo.dao.impl.ProductoDaoImpl;
import com.uisrael.Hospital.modelo.entidades.Producto;


public class ProductoControladorImpl implements ProductoControlador {
	
	private ProductoDaoImpl productoDao;
	
	@Override
	public void insertarProducto(Producto nuevoProducto) {
		productoDao = new ProductoDaoImpl();
	    productoDao.insertarProducto(nuevoProducto);

	
}
	@Override
	public void actualizarProducto(Producto actualizarProducto) {
		productoDao = new ProductoDaoImpl();
		productoDao.actualizarProducto(actualizarProducto);

	}
	

	@Override
	public void eliminarProducto(Producto eliminarProducto) {
		productoDao = new  ProductoDaoImpl();
		productoDao.eliminarProducto(eliminarProducto);
		
	
	}
	
	
	@Override
	public List<Producto> listarProductoCB() {
		productoDao = new ProductoDaoImpl();
		return productoDao.listarProductoCB();
	}
	
	
	@Override
	public List<Tuple> leerNombrePrecio() {
		productoDao = new ProductoDaoImpl();
		return productoDao.leerNombrePrecio();
}
	
	@Override
	public List<Producto> listarproductos() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Producto> listarProductoTB() {

		productoDao = new ProductoDaoImpl();
		return productoDao.listarProductoTB();
	}

	
	@Override
	public List<Producto> Buscarproducto(String idProducto) {
		productoDao = new ProductoDaoImpl();
		return productoDao.buscarproducto(idProducto);
	}
	
	@Override
	
	public List<Producto> listarProductoTQ() {
		productoDao = new ProductoDaoImpl();
		return productoDao.listarProductoTQ();
	}
	@Override
	public Producto BuscarproductoDescripcion(String descripcion) {
		productoDao = new ProductoDaoImpl();
		return productoDao.buscarProductoDescripcion(descripcion);

	}
	
	


	}

	

	
	
