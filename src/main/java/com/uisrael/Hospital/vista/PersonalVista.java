package com.uisrael.Hospital.vista;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import com.uisrael.Hospital.controlador.PersonalControlador;
import com.uisrael.Hospital.controlador.impl.PersonalControladorImpl;
import com.uisrael.Hospital.modelo.entidades.Personal;

@ManagedBean
@ViewScoped



public class PersonalVista implements Serializable {


	private static final long serialVersionUID = 1L;

	private String idPersonal;
	private String nombre;
	private String apellido;
	private int edad;
	private String genero;
	private int telefono;
	private String cargo;
	private String correo;
	private String cedula;
	private Personal inicioSesion;

	// producto aumentado de campo  y crear el gget and setters 
	
	private Personal selectedPersonal;

private Personal nuevoPersonal;
private List<Personal> listaPersonal;


private PersonalControlador personalControlador;

public PersonalVista() {
	
	
}

@PostConstruct
public void init() {
	personalControlador= new PersonalControladorImpl();
	listaPersonal= new ArrayList< Personal>();
	//insertarPersonal();

	
listarPersonal();

}	



 public void insertarPersonal () {

	 
	 try {
	 nuevoPersonal = new Personal();
	 nuevoPersonal.setIdPersonal(0);
nuevoPersonal.setNombre(nombre);
nuevoPersonal.setApellido(apellido);
nuevoPersonal.setEdad(edad);
nuevoPersonal.setGenero(genero);
nuevoPersonal.setTelefono(telefono);
nuevoPersonal.setCorreo(correo);
nuevoPersonal.setCargo(cargo);
nuevoPersonal.setCedula(cedula);
/*
Personal select= new Personal();*/

personalControlador.insertarPersonal(nuevoPersonal);
listaPersonal.clear();
listaPersonal=personalControlador.listarPersonalTB();



FacesContext.getCurrentInstance().addMessage( null,
		new FacesMessage(FacesMessage.SEVERITY_INFO,"Info","se ha REGISTRADO CORRECTAMENTE"));
}
catch(Exception e) {
	System.out.println("Error"+e.getMessage());
	FacesContext.getCurrentInstance().addMessage(null, 
			new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","hubo un problema al guardar"));
}	}

	    public void saveProduct() {
	        if (this.selectedPersonal.getNombre() == null) {
	            this.selectedPersonal.setNombre(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9));
	            this.selectedPersonal.setNombre(nombre);
	            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(""));
	        }
	    
}
 
 public void listarPersonal() {
		listaPersonal=personalControlador.listarPersonalTB();
   
 }
	public void deleteProduct(int id) {
		
		System.out.print(id);
			nuevoPersonal = new Personal();
			nuevoPersonal.setIdPersonal(id);
			personalControlador.eliminarPersonal(nuevoPersonal);
			listaPersonal.clear();
			listaPersonal=personalControlador.listarPersonalTB();
			
			FacesContext.getCurrentInstance().addMessage( null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,"Info","se ha eliminado con exito"));

	
			  PrimeFaces.current().ajax().update("form:messages", "frmpersonal:productDetail");
		        PrimeFaces.current().executeScript("PF(' dt-personal frmpersonal').clearFilters()");
		  
	
}

	
	
	public void actualizarPersonal(int id) {
		
	
	System.out.print(id);
		nuevoPersonal = new Personal();
		nuevoPersonal.setIdPersonal(edad);
		personalControlador.actualizarPersonal(selectedPersonal);
		listaPersonal.clear();
		listaPersonal=personalControlador.listarPersonalTB();
		
		FacesContext.getCurrentInstance().addMessage( null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,"Info","se ha eliminado con exito"));


		  PrimeFaces.current().ajax().update("form:messages", "frmpersonal:productDetail");
	        PrimeFaces.current().executeScript("PF(' dt-personal frmpersonal').clearFilters()");
		
		try {
			
			nuevoPersonal = new Personal();
			nuevoPersonal.setIdPersonal(id);
		nuevoPersonal.setCedula(cedula);
			nuevoPersonal.setCorreo(correo);
			nuevoPersonal.setEdad(edad);
			nuevoPersonal.setGenero(genero);
			nuevoPersonal.setNombre(nombre);
			nuevoPersonal.setTelefono(telefono);
			
			personalControlador = new PersonalControladorImpl();
			personalControlador.actualizarPersonal(selectedPersonal);
	
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO , "Info", " actualizado correctamente"));
				} catch (Exception e) {
					FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR , "Error", "No se actualizo"));
				}
		}
	
	public void listarpersonal() {
		listaPersonal = personalControlador.listarPersonalTB();
	}
	
	public String loginPersonal() { //5
		try {
			inicioSesion = personalControlador.LoginPersonal(nombre, cedula);
			if (inicioSesion != null) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Bienvenido - Ingreso Ok"));
				return "/Login.xhtml";
			} else {
				return null;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", "Error en Inicio de Sesión"));
			return "Login.xhtml";
		}
	}
	
	public String cerrarSesion() {//6
		return "login.xhtml";
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public Personal getNuevoPersonal() {
		return nuevoPersonal;
	}

	public void setNuevoPersonal(Personal nuevoPersonal) {
		this.nuevoPersonal = nuevoPersonal;
	}

	public List<Personal> getListaPersonal() {
		return listaPersonal;
	}

	public void setListaPersonal(List<Personal> listaPersonal) {
		this.listaPersonal = listaPersonal;
	}

	public PersonalControlador getPersonalControlador() {
		return personalControlador;
	}

	public void setPersonalControlador(PersonalControlador personalControlador) {
		this.personalControlador = personalControlador;
	}

	public Personal getSelectedPersonal() {
		return selectedPersonal;
	}

	public void setSelectedPersonal(Personal selectedPersonal) {
		this.selectedPersonal = selectedPersonal;
	}

	public String getIdPersonal() {
		return idPersonal;
	}

	public void setIdPersonal(String idPersonal) {
		this.idPersonal = idPersonal;
	}
	
}

	