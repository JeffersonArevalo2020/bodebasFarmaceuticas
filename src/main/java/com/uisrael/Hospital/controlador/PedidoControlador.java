package com.uisrael.Hospital.controlador;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.Hospital.modelo.entidades.Pedido;


public interface PedidoControlador {
	
	public void insertarPedido(Pedido nuevoPedido);
	
	public void actualizarPedido(Pedido actualizarPedido);
	
	public void eliminarPedido(Pedido eliminarPedido);
	
	public List  <Pedido> listarpedidos();
	
	public List<Pedido> listarPedidoCB();
	
	public Pedido Buscarpedido(String detallePedido); 
	
	public Pedido BuscarpedidodetallePedido(String detallePedido); 
	
	public List<Tuple> leerdetallePedido();
	
	public List<Pedido> listarPedidoTB();
	
	public List<Pedido> listarPedidoTQ();

}
