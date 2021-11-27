package com.uisrael.Hospital.vista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.SerializationUtils;

import com.uisrael.Hospital.controlador.ProveedorControlador;
import com.uisrael.Hospital.controlador.impl.ProveedorControladorImpl;
import com.uisrael.Hospital.modelo.entidades.Proveedor;


@ManagedBean
@ViewScoped


public class ProveedorVista implements  Serializable {
	/**
	 * 
	 */
	
private static final long serialVersionUID = 1L;
	private static final String SerializationUtils = null;
private String nombre;
private String apellido;
private String documentoIdentificacion;
private String email;
private String estado;
private int edad;
private String genero;
private String telefono;
private String institucion;

// producto aumentado de campo  y crear el gget and setters 

private Proveedor selectedProveedor;

private Proveedor nuevoProveedor;
private List<Proveedor> listaProveedor;
private ProveedorControlador proveedorControlador;



public ProveedorVista() {
	
}

@PostConstruct
public void init() {
	proveedorControlador= new ProveedorControladorImpl();
	listaProveedor= new ArrayList<Proveedor>();
 listarProveedor();
}


public void insertarProveedor() {

try {
	nuevoProveedor = new Proveedor();

	nuevoProveedor.setNombre(nombre);
	nuevoProveedor.setApellido(apellido);
	nuevoProveedor.setEdad(edad);   
	nuevoProveedor.setGenero(genero);
	nuevoProveedor.setDocumentoIdentificacion(documentoIdentificacion);
	nuevoProveedor.setEmail(email);
	nuevoProveedor.setEstado(estado);
	nuevoProveedor.setTelefono(telefono);  
	nuevoProveedor.setInstitucion(institucion);

	proveedorControlador.insertarProveedor(nuevoProveedor);
	listaProveedor.clear();
	listaProveedor=proveedorControlador.listarProveedorTB();


	

	FacesContext.getCurrentInstance().addMessage( null,
			new FacesMessage(FacesMessage.SEVERITY_INFO,"Info","se ha guardado CORRECTAMENTE"));
	}
	catch(Exception e) {
		System.out.println("Error"+e.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","hubo un problema al guardar"));
	}	

}
public void listarProveedor() {

	listaProveedor=proveedorControlador.listarProveedorTB();

}
public void deleteProduct(int id) {
	
	System.out.print(id);
		nuevoProveedor = new Proveedor();
		nuevoProveedor.setIdproveedor(id);
		proveedorControlador.eliminarProveedor(nuevoProveedor);
		listaProveedor.clear();
		listaProveedor=proveedorControlador.listarProveedorTB();
	
		FacesContext.getCurrentInstance().addMessage( null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,"Info","se ha borrado con exito"));
}

public void actualizarProveedor() {

    try {
    	
    	proveedorControlador.actualizarProveedor(selectedProveedor);;
    	FacesContext.getCurrentInstance().addMessage(null,
		new FacesMessage(FacesMessage.SEVERITY_INFO , "Info", "Se actualizado correctamente"));
        
        
        
	} catch (Exception e)	{
		FacesContext.getCurrentInstance().addMessage(null,
		new FacesMessage(FacesMessage.SEVERITY_ERROR , "Error", "No se actualizo correctamente"));
	}	


}

public void setSelectedProveedor(List<Proveedor> selectedProveedor) {
    this.actualizarProveedor();
}


private void limpiar() {
	
	this.setNombre("");
	this.setApellido("");
	this.setDocumentoIdentificacion("");
	this.setEdad(0);
	this.setEmail("");
	this.setEstado("");
	this.setGenero("");
	this.setTelefono("");
	this.setInstitucion("");
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

public String getDocumentoIdentificacion() {
	return documentoIdentificacion;
}

public void setDocumentoIdentificacion(String documentoIdentificacion) {
	this.documentoIdentificacion = documentoIdentificacion;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getEstado() {
	return estado;
}

public void setEstado(String estado) {
	this.estado = estado;
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

public String getTelefono() {
	return telefono;
}

public void setTelefono(String telefono) {
	this.telefono = telefono;
}

public String getInstitucion() {
	return institucion;
}

public void setInstitucion(String institucion) {
	this.institucion = institucion;
}

public Proveedor getSelectedProveedor() {
	return selectedProveedor;
}

public void setSelectedProveedor(Proveedor selectedProveedor) {
	this.selectedProveedor = selectedProveedor;
}

public Proveedor getNuevoProveedor() {
	return nuevoProveedor;
}

public void setNuevoProveedor(Proveedor nuevoProveedor) {
	this.nuevoProveedor = nuevoProveedor;
}

public List<Proveedor> getListaProveedor() {
	return listaProveedor;
}

public void setListaProveedor(List<Proveedor> listaProveedor) {
	this.listaProveedor = listaProveedor;
}

public ProveedorControlador getProveedorControlador() {
	return proveedorControlador;
}

public void setProveedorControlador(ProveedorControlador proveedorControlador) {
	this.proveedorControlador = proveedorControlador;
}

}