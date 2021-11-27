package com.uisrael.Hospital.modelo.dao;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.Hospital.modelo.entidades.Pedido;

public interface PedidoDao {
	
	public void insertarPedido(Pedido nuevoPedido);
	
	public void actualizarPedido(Pedido actualizarPedido);
	
	public void eliminarPedido(Pedido deletePedido);
	
	public List  <Pedido> listarPedidoCB();
	
	public Pedido Buscarpedido (String detallePedido);
	
	public List<Tuple> leerdetallePedido();
	
	public List<Pedido> listarPedidoTB();
	
	public List<Pedido> listarPedidoTQ();
	
	public Pedido burcarPedidonombrePedido(String detallePedido);
	
}
