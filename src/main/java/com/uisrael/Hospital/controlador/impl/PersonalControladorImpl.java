package com.uisrael.Hospital.controlador.impl;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.Hospital.controlador.PersonalControlador;
import com.uisrael.Hospital.modelo.dao.impl.PersonalDaoImpl;
import com.uisrael.Hospital.modelo.entidades.Personal;

public class PersonalControladorImpl implements PersonalControlador{

	private PersonalDaoImpl personalDao;
	@Override
	public void insertarPersonal(Personal nuevoPersonal) {
		personalDao = new PersonalDaoImpl();
		personalDao.insertarPersonal(nuevoPersonal);
	}

	@Override
	public void actualizarPersonal(Personal actualizarPersonal) {
		personalDao = new PersonalDaoImpl();
		personalDao.actualizarPersonal(actualizarPersonal);
		
	}

	@Override
	public void eliminarPersonal(Personal eliminarPersonal) {
		personalDao = new PersonalDaoImpl();
		personalDao.eliminarPersonal(eliminarPersonal);
		
	}

	@Override
	public List<Personal> listarPersonalTQ() {
		personalDao= new PersonalDaoImpl();
		return personalDao.listarPersonalTQ();
	}


	@Override
	public List<Personal> listarPersonalCB() {
		personalDao= new PersonalDaoImpl();
		return personalDao.listarPersonalCB();
	}

	@Override
	public Personal Buscarpersonal(String nombreapellido) {
		personalDao = new PersonalDaoImpl();
		return personalDao.Buscarpersonal(nombreapellido);
	}

	@Override
	public Personal BuscarpersonalEmail(String email) {
		personalDao = new PersonalDaoImpl();
		return personalDao.Buscarpersonal(email);

}

	@Override
	public List<Tuple> leerNombreApellido() {
		personalDao = new PersonalDaoImpl();
		return personalDao.leerNombreApellido();
	}
	
	
	@Override
	public List<Personal> listarPersonalTB() {
		personalDao= new PersonalDaoImpl();
		return personalDao.listarPersonalTB();
	}

	@Override
	public List<Personal> listarpersonales() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Personal LoginPersonal(String cedula, String nombre) {
		// TODO Auto-generated method stub
				personalDao = new PersonalDaoImpl();
				return personalDao.LoginPersonal(cedula, nombre);

	}
}
