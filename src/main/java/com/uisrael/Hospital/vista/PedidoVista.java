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

import com.uisrael.Hospital.controlador.PedidoControlador;
import com.uisrael.Hospital.controlador.ProductoControlador;
import com.uisrael.Hospital.controlador.impl.PedidoControladorImpl;
import com.uisrael.Hospital.controlador.impl.ProductoControladorImpl;
import com.uisrael.Hospital.modelo.entidades.Pedido;
import com.uisrael.Hospital.modelo.entidades.Producto;

@ManagedBean
@ViewScoped

public class PedidoVista implements  Serializable {
	/**
	 * 
	 */
	
private static final long serialVersionUID = 1L;

private String detallePedido; 
private String nombrePedido;
private Date fechaPedido;
private Date fechaEnvio;
private int cantidadPedido;
private int ingresoPedido;
private String reclamoPedido;

private int idpedido;

// producto aumentado de campo  y crear el gget and setters 

private Pedido selectedPedido;

private int productoSeleccionado;
private Pedido nuevoPedido;
private Producto nuevoProducto;


private List<Pedido> listaPedido;
private List<Producto> listaProducto;

private PedidoControlador pedidoControlador;
private ProductoControlador productoControlador;


public PedidoVista() {
	
}
@PostConstruct
public void init() {
	pedidoControlador= new PedidoControladorImpl();
	listaPedido= new ArrayList<Pedido>();
	
	productoControlador= new ProductoControladorImpl();
	listaProducto= new ArrayList<Producto>();
	
	//insertarPedido();
	listarPedido();
	listarProducto();
}	


public void insertarPedido() {
	

	try {	
	 nuevoPedido = new Pedido();
	
	 nuevoPedido.setNombrePedido(nombrePedido);
	nuevoPedido.setDetallePedido(detallePedido);
	nuevoPedido.setIngresoPedido(ingresoPedido);
	nuevoPedido.setCantidadPedido(cantidadPedido);
	nuevoPedido.setFechaEnvio(fechaEnvio);
	nuevoPedido.setFechaPedido(fechaPedido);
	nuevoPedido.setReclamoPedido(reclamoPedido);
	nuevoPedido.setFkCompra(null);
	nuevoPedido.setFkProducto(nuevoProducto);

	
	Producto select =new Producto();
	select.setIdproducto(productoSeleccionado);
	nuevoPedido.setFkProducto(select);

	pedidoControlador.insertarPedido(nuevoPedido);
	listaPedido.clear();
	listaPedido=pedidoControlador.listarPedidoTB();
	
	
	
	FacesContext.getCurrentInstance().addMessage( null,
			new FacesMessage(FacesMessage.SEVERITY_INFO,"Info","se ha REGISTRADO CORRECTAMENTE"));
	}
	
	
	catch(Exception e) {
		System.out.println("Error"+e.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","hubo un problema al guardar"));
	}	

}
public void listarPedido() {
	listaPedido=pedidoControlador.listarPedidoTB();

}

public void deleteProduct(int id) {
	
System.out.print(id);
	nuevoPedido = new Pedido();
	nuevoPedido.setIdpedido(id);
	pedidoControlador.eliminarPedido(nuevoPedido);
	listaPedido.clear();
	listaPedido=pedidoControlador.listarPedidoTB();
	
	FacesContext.getCurrentInstance().addMessage( null,
			new FacesMessage(FacesMessage.SEVERITY_INFO,"Info","se ha eliminado con exito"));

}


public void actualizarPedido(int idpedido, String detallePedido, String nombrePedido, Date fechaPedido, Date fechaEnvio, int cantidadPedido, int ingresoPedido, String reclamoPedido) {
		
		System.out.print(idpedido);
		System.out.print(detallePedido);
		System.out.print(nombrePedido);
		System.out.print(fechaPedido);;
		System.out.print(fechaEnvio);
		System.out.print(detallePedido);
		System.out.print(cantidadPedido);
		System.out.print(ingresoPedido);
		System.out.print(reclamoPedido);
		
		
        try {
        	nuevoPedido.setNombrePedido(nombrePedido);
        	nuevoPedido.setIdpedido(idpedido);
        	nuevoPedido.setDetallePedido(detallePedido);
        	nuevoPedido.setCantidadPedido(cantidadPedido);
        	nuevoPedido.setFechaEnvio(fechaEnvio);
        	nuevoPedido.setFechaPedido(fechaPedido);
        	nuevoPedido.setIngresoPedido(ingresoPedido);
        	nuevoPedido.setReclamoPedido(reclamoPedido);
        	nuevoPedido.setFkCompra(null);
        	

        	pedidoControlador = new PedidoControladorImpl();
        	pedidoControlador.actualizarPedido(nuevoPedido);
        	productoControlador.actualizarProducto(nuevoProducto);
        	limpiar();
    		listarPedido();
        		listarProducto();
	       
        		
        		FacesContext.getCurrentInstance().addMessage(null,
			new FacesMessage(FacesMessage.SEVERITY_INFO , "Info", "Se actualizado correctamente"));
	        
	        
	        
		} catch (Exception e)	{
			FacesContext.getCurrentInstance().addMessage(null,
			new FacesMessage(FacesMessage.SEVERITY_ERROR , "Error", "No se actualizo correctamente"));
		}	


}


private void limpiar() {
	// TODO Auto-generated method stub
	
}
public void listarProducto() {
	listaProducto=productoControlador.listarProductoTB();
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
public int getIdpedido() {
	return idpedido;
}
public void setIdpedido(int idpedido) {
	this.idpedido = idpedido;
}
public Pedido getSelectedPedido() {
	return selectedPedido;
}
public void setSelectedPedido(Pedido selectedPedido) {
	this.selectedPedido = selectedPedido;
}
public int getProductoSeleccionado() {
	return productoSeleccionado;
}
public void setProductoSeleccionado(int productoSeleccionado) {
	this.productoSeleccionado = productoSeleccionado;
}
public Pedido getNuevoPedido() {
	return nuevoPedido;
}
public void setNuevoPedido(Pedido nuevoPedido) {
	this.nuevoPedido = nuevoPedido;
}
public Producto getNuevoProducto() {
	return nuevoProducto;
}
public void setNuevoProducto(Producto nuevoProducto) {
	this.nuevoProducto = nuevoProducto;
}
public List<Pedido> getListaPedido() {
	return listaPedido;
}
public void setListaPedido(List<Pedido> listaPedido) {
	this.listaPedido = listaPedido;
}
public List<Producto> getListaProducto() {
	return listaProducto;
}
public void setListaProducto(List<Producto> listaProducto) {
	this.listaProducto = listaProducto;
}
public PedidoControlador getPedidoControlador() {
	return pedidoControlador;
}
public void setPedidoControlador(PedidoControlador pedidoControlador) {
	this.pedidoControlador = pedidoControlador;
}
public ProductoControlador getProductoControlador() {
	return productoControlador;
}
public void setProductoControlador(ProductoControlador productoControlador) {
	this.productoControlador = productoControlador;
}
}