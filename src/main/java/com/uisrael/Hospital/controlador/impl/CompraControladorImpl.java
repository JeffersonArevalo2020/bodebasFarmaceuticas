package com.uisrael.Hospital.controlador.impl;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.Hospital.controlador.CompraControlador;
import com.uisrael.Hospital.modelo.dao.impl.CompraDaoImpl;
import com.uisrael.Hospital.modelo.entidades.Compra;

public class CompraControladorImpl implements CompraControlador{

	private CompraDaoImpl compraDao;
	
	@Override
	public void insertarCompra(Compra nuevoCompra) {
		compraDao = new CompraDaoImpl();
		compraDao.insertarCompra(nuevoCompra);
		
	}

	@Override
	public void actualizarCompra(Compra actualizarCompra) {
		compraDao = new CompraDaoImpl();
		compraDao.actualizarCompra(actualizarCompra);
		
	}

	@Override
	public void eliminarCompra(Compra eliminarCompra) {
		compraDao = new CompraDaoImpl();
		compraDao.eliminarCompra(eliminarCompra);
	}



	
	@Override
	public List<Compra> listarCompraCB() {
		compraDao = new CompraDaoImpl();
		return compraDao.listarCompraCB();
	}
	
	
	@Override
	public List<Tuple> leerproductoPedido() {
		compraDao = new CompraDaoImpl();
		return compraDao.leerproductoPedido();
	}

	
	
	@Override
	public List<Compra> listarCompradores() {
		// TODO Auto-generated method stub
				return null;
	}
	
	
	@Override
	public List<Compra> listarCompraTB() {
		compraDao = new CompraDaoImpl();
		return compraDao.listarCompraTB();
	} 
	
	
	
	
	@Override
	public Compra Buscarcompra(String compraproductos) {
		compraDao = new CompraDaoImpl();
		return compraDao.Buscarcompra(compraproductos);
	}
	

	@Override
	public Compra Buscarcompracompraproductos(String compraproductos) {
		compraDao = new CompraDaoImpl();
		return compraDao.Buscarcompra(compraproductos);
	}



	@Override
	public List<Compra> listarCompraTQ() {
		compraDao = new CompraDaoImpl();
		return compraDao.listarCompraTQ();
	}
	
	
}
