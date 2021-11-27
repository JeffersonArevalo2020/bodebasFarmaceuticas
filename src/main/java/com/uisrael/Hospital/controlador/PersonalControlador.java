package com.uisrael.Hospital.controlador;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.Hospital.modelo.entidades.Personal;


public interface PersonalControlador {

		
		public void insertarPersonal(Personal nuevoPersonal);
			
		public void actualizarPersonal(Personal actualizarPersonal);
			
		public void eliminarPersonal(Personal eliminarPersonal);
			
		public List  <Personal> listarpersonales();
		
		public List<Personal> listarPersonalCB();
		
		public Personal Buscarpersonal(String nombreapellido); 
		
		public Personal BuscarpersonalEmail(String email); 
		
		public List<Tuple> leerNombreApellido();
		
		public List<Personal> listarPersonalTB();
		
		public List<Personal> listarPersonalTQ();
		
		public Personal LoginPersonal (String cedula, String nombre);

	}

