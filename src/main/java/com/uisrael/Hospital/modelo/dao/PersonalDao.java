package com.uisrael.Hospital.modelo.dao;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.Hospital.modelo.entidades.Personal;

public interface PersonalDao {

	
	public void insertarPersonal(Personal nuevoPersonal);
	
	public void actualizarPersonal(Personal actualizarPersonal);
	
	public void eliminarPersonal(Personal eliminarPersonal);
	
	public List  <Personal> listarPersonalCB();
	
	public Personal Buscarpersonal(String nombreapellido);
	
	public List<Tuple>  leerNombreApellido();
	
	public List<Personal> listarPersonalTB();
	
	public List<Personal> listarPersonalTQ();
	
	public Personal burcarPersonalEmail(String email);
	
	public Personal LoginPersonal (String nombre, String cedula);
	}