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
import com.uisrael.Hospital.controlador.ProveedorControlador;
import com.uisrael.Hospital.controlador.impl.PedidoControladorImpl;
import com.uisrael.Hospital.controlador.impl.ProductoControladorImpl;
import com.uisrael.Hospital.controlador.impl.ProveedorControladorImpl;
import com.uisrael.Hospital.modelo.entidades.Pedido;
import com.uisrael.Hospital.modelo.entidades.Producto;
import com.uisrael.Hospital.modelo.entidades.Proveedor;


@ManagedBean
@ViewScoped
public class ProductoVista implements Serializable {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	private int idproducto; 
	private String nombreProducto;
	private String descripcion;
	private String stock;
	private Date fechaelaboracion;
	private Date fechacaducidad;
	private int precio;
	
	// producto aumentado de campo  y crear el gget and setters 
	
	private Producto selectedProducto;

	private Pedido nuevoPedido;
	private Proveedor nuevoProveedor;
	private Producto nuevoProducto;
	
	
	
	private List<Producto> listaProducto;
	private List<Pedido> listaPedido;
	private List<Proveedor> listaProveedor;
	
	private int proveedorSeleccionado;
	private int pedidoSeleccionado;
	
	
	private ProveedorControlador proveedorControlador;
	private ProductoControlador productoControlador;
	private PedidoControlador pedidoControlador;
	
	
	public ProductoVista() {
		
	}

	@PostConstruct
	public void init() {
		
		productoControlador= new ProductoControladorImpl();
		listaProducto= new ArrayList<Producto>();
	
		proveedorControlador = new ProveedorControladorImpl();
		listaProveedor= new ArrayList<Proveedor>();
		
		pedidoControlador = new PedidoControladorImpl();
		listaPedido= new ArrayList<Pedido>();
		
		
 listarProducto();
 listarPedido();
	}
	
	public void insertarProducto() {

		try {			
		
			nuevoProducto = new Producto();
		
	nuevoProducto.setDescripcion(descripcion);
    nuevoProducto.setFechacaducidad(fechacaducidad);
    nuevoProducto.setFechaelaboracion(fechaelaboracion);
	nuevoProducto.setIdproducto(idproducto);
	nuevoProducto.setNombreProducto(nombreProducto);
	nuevoProducto.setPrecio(precio);
	nuevoProducto.setStock(stock);
	nuevoProducto.setFkProveedor(nuevoProveedor);

	Proveedor select= new Proveedor();
	select.setIdproveedor(proveedorSeleccionado);
	nuevoProducto.setFkProveedor(select);
	

	
	pedidoControlador.insertarPedido(nuevoPedido);
	productoControlador.insertarProducto(nuevoProducto);
	
	listarProducto();
	FacesContext.getCurrentInstance().addMessage( null,
			new FacesMessage(FacesMessage.SEVERITY_INFO,"Info","se ha guardado CORRECTAMENTE"));
	System.out.println("Correcto" );
	
		}
	catch(Exception e) {
		System.out.println("Error"+e.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","hubo un problema al guardar"));
	}	
	
		
}

public void listarProducto() {
	listaProducto=productoControlador.listarProductoTB();
	listaProveedor=proveedorControlador.listarProveedorTB();
	
}
public void listarPedido() {
	listaPedido=pedidoControlador.listarPedidoTB();
}

public void deleteProduct(int id) {
	
	try {
	System.out.print(id);
		nuevoProducto = new Producto();
		nuevoProducto.setIdproducto(id);
		productoControlador.eliminarProducto(nuevoProducto);
		listaProducto.clear();
		listaProducto=productoControlador.listarProductoTB();
		
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Usuario Actualizado Correctamente"));
		System.out.println("Correcto");
		listarProducto();
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Error" +e.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Error al realizar la actualizacion"));
	}
}
	
ProductoControladorImpl productoControladorImpl = new ProductoControladorImpl();


public void actualizarProducto(Producto producto) {

 try {
	 productoControladorImpl.actualizarProducto(nuevoProducto);

	
	listarProducto();
	FacesContext.getCurrentInstance().addMessage(null,
			new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", " Actualizado Correctamente"));
	System.out.println("funciona correctamentamente");

} catch (Exception e)	{
	FacesContext.getCurrentInstance().addMessage(null,
	new FacesMessage(FacesMessage.SEVERITY_ERROR , "Error", "No se actualizo correctamente"));
	System.out.println("No funciona correctamentamente");
}	

}	

public void seleccionarProducto(Producto seleccionProducto) {
	
	nuevoProducto = seleccionProducto;
    idproducto = nuevoProducto.getIdproducto();
    nombreProducto = nuevoProducto.getNombreProducto();
    descripcion = nuevoProducto.getDescripcion();
    precio = nuevoProducto.getPrecio();
    stock = nuevoProducto.getStock();
    fechacaducidad = nuevoProducto.getFechacaducidad();
    fechaelaboracion = nuevoProducto.getFechaelaboracion();
    nuevoProveedor = nuevoProducto.getFkProveedor();
}

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

public Producto getSelectedProducto() {
	return selectedProducto;
}

public void setSelectedProducto(Producto selectedProducto) {
	this.selectedProducto = selectedProducto;
}

public Pedido getNuevoPedido() {
	return nuevoPedido;
}

public void setNuevoPedido(Pedido nuevoPedido) {
	this.nuevoPedido = nuevoPedido;
}

public Proveedor getNuevoProveedor() {
	return nuevoProveedor;
}

public void setNuevoProveedor(Proveedor nuevoProveedor) {
	this.nuevoProveedor = nuevoProveedor;
}

public Producto getNuevoProducto() {
	return nuevoProducto;
}

public void setNuevoProducto(Producto nuevoProducto) {
	this.nuevoProducto = nuevoProducto;
}

public List<Producto> getListaProducto() {
	return listaProducto;
}

public void setListaProducto(List<Producto> listaProducto) {
	this.listaProducto = listaProducto;
}

public List<Pedido> getListaPedido() {
	return listaPedido;
}

public void setListaPedido(List<Pedido> listaPedido) {
	this.listaPedido = listaPedido;
}

public List<Proveedor> getListaProveedor() {
	return listaProveedor;
}

public void setListaProveedor(List<Proveedor> listaProveedor) {
	this.listaProveedor = listaProveedor;
}

public int getProveedorSeleccionado() {
	return proveedorSeleccionado;
}

public void setProveedorSeleccionado(int proveedorSeleccionado) {
	this.proveedorSeleccionado = proveedorSeleccionado;
}

public int getPedidoSeleccionado() {
	return pedidoSeleccionado;
}

public void setPedidoSeleccionado(int pedidoSeleccionado) {
	this.pedidoSeleccionado = pedidoSeleccionado;
}

public ProveedorControlador getProveedorControlador() {
	return proveedorControlador;
}

public void setProveedorControlador(ProveedorControlador proveedorControlador) {
	this.proveedorControlador = proveedorControlador;
}

public ProductoControlador getProductoControlador() {
	return productoControlador;
}

public void setProductoControlador(ProductoControlador productoControlador) {
	this.productoControlador = productoControlador;
}

public PedidoControlador getPedidoControlador() {
	return pedidoControlador;
}

public void setPedidoControlador(PedidoControlador pedidoControlador) {
	this.pedidoControlador = pedidoControlador;
}
}