package com.uisrael.Hospital.modelo.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
 @Table(name="tb_compra")
public class Compra implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	
	@Column(name="cli_compra", length =80)
	
	private int idCompra;
	private String compraproductos;
	private String detallePedido; 
	private String productoPedido;
	private Date fechaPedido;
	private Date fechaEnvio;
	private int cantidadPedido;
	
	//relacion Personal
		@ManyToOne (cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)  
		@JoinColumn(name="fkPersonal")
		private Personal fkPersonal;


		//relacion  Detalle Pedidos

		@OneToMany(mappedBy = "fkCompra",cascade = CascadeType.REFRESH)
		private List<Pedido> lstPedido = new ArrayList<Pedido>();


		public int getIdCompra() {
			return idCompra;
		}


		public void setIdCompra(int idCompra) {
			this.idCompra = idCompra;
		}


		public String getCompraproductos() {
			return compraproductos;
		}


		public void setCompraproductos(String compraproductos) {
			this.compraproductos = compraproductos;
		}


		public String getDetallePedido() {
			return detallePedido;
		}


		public void setDetallePedido(String detallePedido) {
			this.detallePedido = detallePedido;
		}


		public String getProductoPedido() {
			return productoPedido;
		}


		public void setProductoPedido(String productoPedido) {
			this.productoPedido = productoPedido;
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


		public Personal getFkPersonal() {
			return fkPersonal;
		}


		public void setFkPersonal(Personal fkPersonal) {
			this.fkPersonal = fkPersonal;
		}


		public List<Pedido> getLstPedido() {
			return lstPedido;
		}


		public void setLstPedido(List<Pedido> lstPedido) {
			this.lstPedido = lstPedido;
		}


		@Override
		public String toString() {
			return "Compra [idCompra=" + idCompra + ", compraproductos=" + compraproductos + ", detallePedido="
					+ detallePedido + ", productoPedido=" + productoPedido + ", fechaPedido=" + fechaPedido
					+ ", fechaEnvio=" + fechaEnvio + ", cantidadPedido=" + cantidadPedido + ", fkPersonal=" + fkPersonal
					+ ", lstPedido=" + lstPedido + "]";
		}

}

	