package com.uisrael.Hospital.controlador;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.Hospital.modelo.entidades.Proveedor;

public interface ProveedorControlador {
	
	public void insertarProveedor(Proveedor nuevoProveedor);
	
	public void actualizarProveedor(Proveedor actualizarProveedor);
	
	public void eliminarProveedor(Proveedor eliminarProveedor);
	
	public List  <Proveedor> listarproveedores();
	
	public List<Proveedor> listarProveedorCB();
	
	public Proveedor Buscarproveedor(String nombreapellido); 
	
	public Proveedor BuscarproveedorEmail(String email); 
	
	public List<Tuple> leerNombreApellido();
	
	public List<Proveedor> listarProveedorTB();
	
	public List<Proveedor> listarProveedorTQ();

}

