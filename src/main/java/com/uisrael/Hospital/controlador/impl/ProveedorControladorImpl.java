package com.uisrael.Hospital.controlador.impl;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.Hospital.controlador.ProveedorControlador;
import com.uisrael.Hospital.modelo.dao.impl.ProveedorDaoImpl;
import com.uisrael.Hospital.modelo.entidades.Proveedor;

public class ProveedorControladorImpl implements ProveedorControlador {

	private ProveedorDaoImpl proveedorDao;
	
	@Override
	public void insertarProveedor(Proveedor nuevoProveedor) {
		proveedorDao = new ProveedorDaoImpl();
		proveedorDao.insertarProveedor(nuevoProveedor);
		
	}

	@Override
	public void actualizarProveedor(Proveedor actualizarProveedor) {
		proveedorDao = new ProveedorDaoImpl();
		proveedorDao.actualizarProveedor(actualizarProveedor);
		
	}

	@Override
	public void eliminarProveedor(Proveedor eliminarProveedor) {
		proveedorDao = new ProveedorDaoImpl();
		proveedorDao.eliminarProveedor(eliminarProveedor);
		
	}

	@Override
	public List<Proveedor> listarProveedorCB() {
		proveedorDao = new ProveedorDaoImpl();
		return proveedorDao.listarProveedorCB();
	}
	

	@Override
	public List<Tuple> leerNombreApellido() {
		proveedorDao = new ProveedorDaoImpl();
		return proveedorDao.leerNombreApellido();
}

	@Override
	public List<Proveedor> listarproveedores() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Proveedor> listarProveedorTB() {
		proveedorDao = new ProveedorDaoImpl();
		return proveedorDao.listarProveedorTB();
	
	}

	@Override
	public Proveedor Buscarproveedor(String nombreapellido) {
		proveedorDao = new ProveedorDaoImpl();
		return proveedorDao.Buscarproveedor(nombreapellido);
	}

	@Override
	public List<Proveedor> listarProveedorTQ() {
		proveedorDao = new ProveedorDaoImpl();
		return proveedorDao.listarProveedorTQ();

}

	@Override
	public Proveedor BuscarproveedorEmail(String email) {
		proveedorDao = new ProveedorDaoImpl();
		return proveedorDao.burcarProveedorEmailTQ(email);

	}
}
		
	