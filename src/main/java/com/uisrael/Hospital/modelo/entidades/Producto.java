package com.uisrael.Hospital.modelo.entidades;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
 @Table(name="tb_producto")

public class Producto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	
	private int idproducto; 
	private String nombreProducto;
	private String descripcion;
	private String stock;
	private Date fechaelaboracion;
	private Date fechacaducidad;
	private int precio;
	
	//llave de Pedido//
		@OneToMany(mappedBy = "fkProducto",cascade = CascadeType.REFRESH)
		private List<Pedido> lstPedido = new ArrayList<Pedido>();
		
		//relacion Proveedor
				@ManyToOne (cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)  
				@JoinColumn(name="fkProveedor")
				private Proveedor fkProveedor;

				public int getIdproducto() {
					return idproducto;
				}

				public void setIdproducto(int idproducto) {
					this.idproducto = idproducto;
				}

				public String getNombreProducto() {
					return nombreProducto;
				}

				public void setNombreProducto(String nombreProducto) {
					this.nombreProducto = nombreProducto;
				}

				public String getDescripcion() {
					return descripcion;
				}

				public void setDescripcion(String descripcion) {
					this.descripcion = descripcion;
				}

				public String getStock() {
					return stock;
				}

				public void setStock(String stock) {
					this.stock = stock;
				}

				public Date getFechaelaboracion() {
					return fechaelaboracion;
				}

				public void setFechaelaboracion(Date fechaelaboracion) {
					this.fechaelaboracion = fechaelaboracion;
				}

				public Date getFechacaducidad() {
					return fechacaducidad;
				}

				public void setFechacaducidad(Date fechacaducidad) {
					this.fechacaducidad = fechacaducidad;
				}

				public int getPrecio() {
					return precio;
				}

				public void setPrecio(int precio) {
					this.precio = precio;
				}

				public List<Pedido> getLstPedido() {
					return lstPedido;
				}

				public void setLstPedido(List<Pedido> lstPedido) {
					this.lstPedido = lstPedido;
				}

				public Proveedor getFkProveedor() {
					return fkProveedor;
				}

				public void setFkProveedor(Proveedor fkProveedor) {
					this.fkProveedor = fkProveedor;
				}

}

			