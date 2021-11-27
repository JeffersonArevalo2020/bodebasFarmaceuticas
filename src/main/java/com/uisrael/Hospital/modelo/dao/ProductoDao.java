package com.uisrael.Hospital.modelo.dao;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.Hospital.modelo.entidades.Producto;

public interface ProductoDao {
	
	public void insertarProducto(Producto nuevoProducto);
	
	public void actualizarProducto(Producto actualizarProducto);
	
	public void eliminarProducto(Producto eliminarProducto);
	
	public List  <Producto> listarProductoCB();
	
	public Producto Buscarproducto(String idProducto);
	
	public List<Tuple> leerNombrePrecio();
	
	public List<Producto> listarProductoTB();
	
	public List<Producto> listarProductoTQ();
	
	public Producto buscarProductoDescripcion(String descripcion);
	
}