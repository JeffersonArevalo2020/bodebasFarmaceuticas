package com.uisrael.Hospital.modelo.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
 @Table(name="tb_proveedor")

public class Proveedor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)

@Column(name="cli_proveedor", length =80)

private int idproveedor;
private String nombre;
private String apellido;
private String documentoIdentificacion;
private String email;
private String estado;
private int edad;
private String genero;
private String telefono;
private String institucion;

	// //llave de Producto//
@OneToMany(mappedBy = "fkProveedor",cascade = CascadeType.REFRESH)
private List<Producto> lstProducto = new ArrayList<Producto>();

public int getIdproveedor() {
	return idproveedor;
}

public void setIdproveedor(int idproveedor) {
	this.idproveedor = idproveedor;
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

public List<Producto> getLstProducto() {
	return lstProducto;
}

public void setLstProducto(List<Producto> lstProducto) {
	this.lstProducto = lstProducto;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

@Override
public String toString() {
	return "Proveedor [idproveedor=" + idproveedor + ", nombre=" + nombre + ", apellido=" + apellido
			+ ", documentoIdentificacion=" + documentoIdentificacion + ", email=" + email + ", estado=" + estado
			+ ", edad=" + edad + ", genero=" + genero + ", telefono=" + telefono + ", institucion=" + institucion
			+ ", lstProducto=" + lstProducto + "]";
}
}
