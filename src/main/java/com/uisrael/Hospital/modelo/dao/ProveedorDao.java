package com.uisrael.Hospital.modelo.dao;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.Hospital.modelo.entidades.Proveedor;

public interface ProveedorDao {
	
	public void insertarProveedor(Proveedor nuevoProveedor);
	
	public void actualizarProveedor(Proveedor actualizarProveedor);
	
	public void eliminarProveedor(Proveedor eliminarProveedor);
	
	public List  <Proveedor> listarProveedorCB();
	
	public Proveedor Buscarproveedor(String nombreapellido);
	
	public List<Tuple> leerNombreApellido();
	
	public List<Proveedor> listarProveedorTB();
	
	public List<Proveedor> listarProveedorTQ();
	
	public Proveedor burcarProveedorEmail(String email);
}