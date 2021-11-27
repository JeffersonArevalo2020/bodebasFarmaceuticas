package com.uisrael.Hospital.controlador;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.Hospital.modelo.entidades.Producto;


public interface ProductoControlador {
	
public void insertarProducto(Producto nuevoProducto);
	
	public void actualizarProducto(Producto actualizarProducto);
	
	public void eliminarProducto(Producto eliminarProducto);
	
	public List  <Producto> listarproductos();
	
	public List<Producto> listarProductoCB();
	
	public List<Producto> Buscarproducto(String idProducto); 
	
	public Producto BuscarproductoDescripcion(String descripcion); 
	
	public List<Tuple> leerNombrePrecio();
	
	public List<Producto> listarProductoTB();
	
	public List<Producto> listarProductoTQ();

}
