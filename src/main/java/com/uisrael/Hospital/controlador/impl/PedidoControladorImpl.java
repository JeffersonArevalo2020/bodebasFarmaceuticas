package com.uisrael.Hospital.controlador.impl;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.Hospital.controlador.PedidoControlador;
import com.uisrael.Hospital.modelo.dao.impl.PedidoDaoImpl;
import com.uisrael.Hospital.modelo.entidades.Pedido;


public class PedidoControladorImpl  implements PedidoControlador {

	private PedidoDaoImpl pedidoDao;

	@Override
	public void insertarPedido(Pedido nuevoPedido) {
		pedidoDao = new PedidoDaoImpl();
		pedidoDao.insertarPedido(nuevoPedido);

	}
	@Override
	public void actualizarPedido(Pedido actualizarPedido) {
		pedidoDao = new PedidoDaoImpl();
		pedidoDao.actualizarPedido(actualizarPedido);
		
	}
	@Override
	public void eliminarPedido(Pedido eliminarPedido) {
		pedidoDao = new PedidoDaoImpl();
		pedidoDao.eliminarPedido(eliminarPedido);
		
	}

	@Override
	public List<Pedido> listarPedidoCB() {
		pedidoDao = new PedidoDaoImpl();
		return pedidoDao.listarPedidoCB();
	}
	
	public List<Tuple> leerdetallePedido() {
		pedidoDao = new PedidoDaoImpl();
		return pedidoDao.leerdetallePedido();
}
	
	@Override
	public List<Pedido> listarpedidos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
@Override
public List<Pedido> listarPedidoTB() {
	pedidoDao = new PedidoDaoImpl();
	return pedidoDao.listarPedidoTB();
}

	
	@Override
	public Pedido Buscarpedido(String detallePedido) {
		pedidoDao = new PedidoDaoImpl();
		return pedidoDao.burcarPedidonombrePedido(detallePedido);
	}
	
	
	@Override
	public List<Pedido> listarPedidoTQ() {
		pedidoDao = new PedidoDaoImpl();
		return pedidoDao.listarPedidoTQ();
	}
	@Override
	public Pedido BuscarpedidodetallePedido(String detallePedido) {
		pedidoDao = new PedidoDaoImpl();
		return pedidoDao.burcarPedidonombrePedido(detallePedido);
	}
}
	
	

