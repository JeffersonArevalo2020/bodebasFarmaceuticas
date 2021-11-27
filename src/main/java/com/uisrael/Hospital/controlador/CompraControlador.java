package com.uisrael.Hospital.controlador;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.Hospital.modelo.entidades.Compra;


public interface CompraControlador {
	
	public void insertarCompra(Compra nuevoCompra);
	
	public void actualizarCompra(Compra actualizarCompra);
	
	public void eliminarCompra(Compra eliminarCompra);
	
public List  <Compra> listarCompradores();
	
	public List<Compra> listarCompraCB();
	
	public Compra Buscarcompra(String compraproductos); 
	
	public Compra Buscarcompracompraproductos(String compraproductos); 
	
	public List<Tuple> leerproductoPedido();
	
	public List<Compra> listarCompraTB();
	
	public List<Compra> listarCompraTQ();

}

