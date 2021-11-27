package com.uisrael.Hospital.modelo.dao;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.Hospital.modelo.entidades.Compra;

public interface CompraDao {

	public void insertarCompra(Compra nuevoCompra);
	
	public void actualizarCompra(Compra actualizarCompra);
	
	public void eliminarCompra(Compra eliminarCompra);
	
	public List  <Compra> listarCompraCB();
	
	public Compra Buscarcompra(String productoPedido);

	public List<Tuple> leerproductoPedido();
	
	public List<Compra> listarCompraTB();
	
	public List<Compra> listarCompraTQ();
	
	public Compra burcarCompracantidadPedido(String cantidadPedido);
	
}
