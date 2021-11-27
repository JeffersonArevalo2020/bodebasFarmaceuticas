package com.uisrael.Hospital.vista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.uisrael.Hospital.controlador.CompraControlador;
import com.uisrael.Hospital.controlador.PersonalControlador;
import com.uisrael.Hospital.controlador.impl.CompraControladorImpl;
import com.uisrael.Hospital.controlador.impl.PersonalControladorImpl;
import com.uisrael.Hospital.modelo.entidades.	Compra;
import com.uisrael.Hospital.modelo.entidades.Personal;

@ManagedBean
@ViewScoped
public class CompraVista implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String compraproductos;
	private String detallePedido; 
	private String productoPedido;
	private Date fechaPedido;
	private Date fechaEnvio;
	private int cantidadPedido;
	
	
	// producto aumentado de campo  y crear el gget and setters 
	
	private Compra selectedCompra;

	
	
	private int personalSeleccionado;
	private Compra nuevoCompra;
	private List< Compra> listaCompra;
	private  CompraControlador compraControlador;
	private List< Personal> listaPersonal;
	private PersonalControlador personalControlador;
	
	public CompraVista() {

	}

@PostConstruct
	public void init() {
		compraControlador= new CompraControladorImpl();
		listaCompra= new ArrayList<Compra>();

		personalControlador= new PersonalControladorImpl();
		listaPersonal= new ArrayList<Personal>();

		
//	insertarCompra();	
  listarCompra();
  listarPersonal();
 
  
}

	public void insertarCompra(int id) {
		System.out.print(id);
		
try {
	nuevoCompra = new Compra();
	
	nuevoCompra.setCompraproductos(compraproductos);
	nuevoCompra.setDetallePedido(detallePedido);
	nuevoCompra.setFechaEnvio(fechaEnvio);
	nuevoCompra.setFechaPedido(fechaPedido);
	nuevoCompra.setProductoPedido(productoPedido);
	nuevoCompra.setCantidadPedido(cantidadPedido);

	
	Personal select= new Personal();
	select.setIdPersonal(personalSeleccionado);

	
	nuevoCompra.setFkPersonal(select);
	compraControlador.insertarCompra(nuevoCompra);
	listaCompra.clear();
	listaCompra=compraControlador.listarCompraTB();
	


	

	FacesContext.getCurrentInstance().addMessage( null,
			new FacesMessage(FacesMessage.SEVERITY_INFO,"Info","se ha guardado CORRECTAMENTE"));
	}
	catch(Exception e) {
		System.out.println("Error"+e.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","hubo un problema al guardar"));
	}	
			
}

	public void listarCompra() {
		listaCompra=compraControlador.listarCompraTB();
	}
		public void listarPersonal() {
		listaPersonal=personalControlador.listarPersonalTB();		
		
	}
		
		public void deleteProduct(int id) {
			
		System.out.print(id);
			nuevoCompra = new Compra();
			nuevoCompra.setIdCompra(id);
			compraControlador.eliminarCompra(nuevoCompra);
			listaCompra.clear();
			listaCompra=compraControlador.listarCompraTB();
			
			FacesContext.getCurrentInstance().addMessage( null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,"Info","se ha eliminado con exito"));
	}

		public void actualizarCompra(int id) {
			
			System.out.print(id);
			nuevoCompra = new Compra();
			nuevoCompra.setIdCompra(id);
			compraControlador.actualizarCompra(nuevoCompra);
			listaCompra.clear();
			listaCompra=compraControlador.listarCompraTB();
			
		    try {
		    	
		    	compraControlador.actualizarCompra(nuevoCompra);
		    	FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO , "Info", "Se actualizado correctamente"));
		        
		        
		        
			} catch (Exception e)	{
				FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR , "Error", "No se actualizo correctamente"));
			}	


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

		public int getPersonalSeleccionado() {
			return personalSeleccionado;
		}

		public void setPersonalSeleccionado(int personalSeleccionado) {
			this.personalSeleccionado = personalSeleccionado;
		}

		public Compra getNuevoCompra() {
			return nuevoCompra;
		}

		public void setNuevoCompra(Compra nuevoCompra) {
			this.nuevoCompra = nuevoCompra;
		}

		public List<Compra> getListaCompra() {
			return listaCompra;
		}

		public void setListaCompra(List<Compra> listaCompra) {
			this.listaCompra = listaCompra;
		}

		public CompraControlador getCompraControlador() {
			return compraControlador;
		}

		public void setCompraControlador(CompraControlador compraControlador) {
			this.compraControlador = compraControlador;
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

		public Compra getSelectedCompra() {
			return selectedCompra;
		}

		public void setSelectedCompra(Compra selectedCompra) {
			this.selectedCompra = selectedCompra;
		}
	
}
