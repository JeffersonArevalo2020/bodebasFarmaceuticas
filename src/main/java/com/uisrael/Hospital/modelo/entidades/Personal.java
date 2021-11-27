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
@Table(name="tb_personal")
public class Personal  implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)

@Column(name="cli_personal", length =80)


	private int idPersonal; 
	private String nombre;
	private String apellido;
	private int edad;
	private String genero;
	private int telefono;
	private String cargo;
	private String correo;
	private String cedula;
	
	//llave de PedidoCompra//
		@OneToMany(mappedBy = "fkPersonal",cascade = CascadeType.REFRESH)
		private List<Compra> lstCompra = new ArrayList<Compra>();

		public int getIdPersonal() {
			return idPersonal;
		}

		public void setIdPersonal(int idPersonal) {
			this.idPersonal = idPersonal;
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

		public List<Compra> getLstCompra() {
			return lstCompra;
		}

		public void setLstCompra(List<Compra> lstCompra) {
			this.lstCompra = lstCompra;
		}

		@Override
		public String toString() {
			return "Personal [idPersonal=" + idPersonal + ", nombre=" + nombre + ", apellido=" + apellido + ", edad="
					+ edad + ", genero=" + genero + ", telefono=" + telefono + ", cargo=" + cargo + ", correo=" + correo
					+ ", cedula=" + cedula + ", lstCompra=" + lstCompra + "]";
		}

}