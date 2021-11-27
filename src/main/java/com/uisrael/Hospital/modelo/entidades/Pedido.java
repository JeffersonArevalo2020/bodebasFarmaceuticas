package com.uisrael.Hospital.modelo.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
 @Table(name="tb_pedido")

public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	
	private int idpedido;
	private String detallePedido; 
	private String nombrePedido;
	private Date fechaPedido;
	private Date fechaEnvio;
	private int cantidadPedido;
	private int ingresoPedido;
	private String reclamoPedido;

	//relaciones Compra
		@ManyToOne (cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)  
		@JoinColumn(name="fkCompra")
		private Compra fkCompra;
		
		//relaciones Producto
		@ManyToOne (cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)  
		@JoinColumn(name="fkProducto")
		private Producto fkProducto;

		public int getIdpedido() {
			return idpedido;
		}

		public void setIdpedido(int idpedido) {
			this.idpedido = idpedido;
		}

		public String getDetallePedido() {
			return detallePedido;
		}

		public void setDetallePedido(String detallePedido) {
			this.detallePedido = detallePedido;
		}

		public String getNombrePedido() {
			return nombrePedido;
		}

		public void setNombrePedido(String nombrePedido) {
			this.nombrePedido = nombrePedido;
		}

		public Date getFechaPedido() {
			return fechaPedido;
		}

		public void setFechaPedido(Date fechaPedido) {
			this.fechaPedido = fechaPedido;
		}

		public Date getFechaEnvio() {
			return fechaEnvio;
		}

		public void setFechaEnvio(Date fechaEnvio) {
			this.fechaEnvio = fechaEnvio;
		}

		public int getCantidadPedido() {
			return cantidadPedido;
		}

		public void setCantidadPedido(int cantidadPedido) {
			this.cantidadPedido = cantidadPedido;
		}

		public int getIngresoPedido() {
			return ingresoPedido;
		}

		public void setIngresoPedido(int ingresoPedido) {
			this.ingresoPedido = ingresoPedido;
		}

		public String getReclamoPedido() {
			return reclamoPedido;
		}

		public void setReclamoPedido(String reclamoPedido) {
			this.reclamoPedido = reclamoPedido;
		}

		public Compra getFkCompra() {
			return fkCompra;
		}

		public void setFkCompra(Compra fkCompra) {
			this.fkCompra = fkCompra;
		}

		public Producto getFkProducto() {
			return fkProducto;
		}

		public void setFkProducto(Producto fkProducto) {
			this.fkProducto = fkProducto;
		}

		public void setFechaEnvio(int i) {
			// TODO Auto-generated method stub
			
		}

		public void setFechaPedido(int i) {
			// TODO Auto-generated method stub
			
		}


}


