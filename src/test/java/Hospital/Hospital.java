package Hospital;

import java.util.Date;

import org.junit.Test;

import com.uisrael.Hospital.controlador.CompraControlador;
import com.uisrael.Hospital.controlador.PedidoControlador;
import com.uisrael.Hospital.controlador.PersonalControlador;
import com.uisrael.Hospital.controlador.ProductoControlador;
import com.uisrael.Hospital.controlador.ProveedorControlador;
import com.uisrael.Hospital.controlador.impl.CompraControladorImpl;
import com.uisrael.Hospital.controlador.impl.PedidoControladorImpl;
import com.uisrael.Hospital.controlador.impl.PersonalControladorImpl;
import com.uisrael.Hospital.controlador.impl.ProductoControladorImpl;
import com.uisrael.Hospital.controlador.impl.ProveedorControladorImpl;
import com.uisrael.Hospital.modelo.entidades.Compra;
import com.uisrael.Hospital.modelo.entidades.Pedido;
import com.uisrael.Hospital.modelo.entidades.Personal;
import com.uisrael.Hospital.modelo.entidades.Producto;
import com.uisrael.Hospital.modelo.entidades.Proveedor;

public class Hospital {
	
	private PersonalControlador personalControlador;
	private  PedidoControlador pedidoControlador;
	 private ProveedorControlador proveedorControlador; 
	 private CompraControlador compraControlador;
	 private ProductoControlador productoControlador;
	 
@Test
	public void Hospital() {
	//	 	 fail("Not yet implemented");
  
		
	/*  Proveedor nuevoProveedor = new Proveedor ();
		  nuevoProveedor.setIdproveedor(24);
		  nuevoProveedor.setApellido("adrian");
		  nuevoProveedor.setNombre("Arevalo");
		  nuevoProveedor.setEdad(24);
		  nuevoProveedor.setGenero("masculino");
		  nuevoProveedor.setEstado("Casado");
		  nuevoProveedor.setEmail("jonathan@gmail.com");
		  nuevoProveedor.setIdproveedor(23);
		  nuevoProveedor.setInstitucion("uisrael");
		  nuevoProveedor.setTelefono("232323");
		  nuevoProveedor.setInstitucion("cruz");
		  nuevoProveedor.setDocumentoIdentificacion("1234324234");
	  
 
			 proveedorControlador = new ProveedorControladorImpl();
			 proveedorControlador.actualizarProveedor(nuevoProveedor);*/
	
	
	   /* Compra nuevoCompra = new Compra();
	   
	    nuevoCompra.setIdCompra(9);	 
	    nuevoCompra.setCompraproductos("Pastillas Astrozeneca");
	    nuevoCompra.setDetallePedido("eeee");
	    nuevoCompra.setFechaEnvio(null);
	    nuevoCompra.setFechaPedido(null);
	    nuevoCompra.setCantidadPedido(33);
 
	    compraControlador = new CompraControladorImpl();
	    compraControlador.actualizarCompra(nuevoCompra);*/
	
	
	/*
 Personal nuevoPersonal = new Personal (); 
	  
	  nuevoPersonal.setIdPersonal(50);
	  nuevoPersonal.setNombre("luis"); 
	  nuevoPersonal.setApellido("hernandez");
	  nuevoPersonal.setEdad(25);
	  nuevoPersonal.setGenero("masculino");
	  nuevoPersonal.setTelefono(92158551);
	  nuevoPersonal.setCedula("1724532212");
	  nuevoPersonal.setCorreo("Jeffersonarevalo733@gmail.com");
	  nuevoPersonal.setCargo("Administrador");
	  
	  personalControlador = new PersonalControladorImpl();
	  personalControlador.actualizarPersonal(nuevoPersonal);
	*/
	
/*	Pedido nuevoPedido = new Pedido(); 
	
	nuevoPedido.setIdpedido(13);
	 nuevoPedido.setDetallePedido("se pide vacunas antigripal");
	 nuevoPedido.setNombrePedido("finalin");
	 nuevoPedido.setCantidadPedido(10);
	  nuevoPedido.setFechaEnvio(23-1-15);
	 nuevoPedido.setFechaPedido(25-1-16);
	 nuevoPedido.setIngresoPedido(0112);
	  nuevoPedido.setReclamoPedido("No hay defectos en el producto");
	 
	
	 pedidoControlador = new PedidoControladorImpl();
	 pedidoControlador.actualizarPedido(nuevoPedido);*/
	
	
	
	Producto nuevoProducto = new Producto ();
 nuevoProducto.setIdproducto(5);
  nuevoProducto.setNombreProducto("biulanaca");
  nuevoProducto.setDescripcion("dolor de estomago");
  nuevoProducto.setStock("stock");
  nuevoProducto.setPrecio(159);
productoControlador = new ProductoControladorImpl();
productoControlador.actualizarProducto(nuevoProducto);
	
	
	//			  	  proveedorControlador.BuscarproveedorEmail("mariop@gmail.com");
		  //		  proveedorControlador.Buscarproveedor("Martin");
	//		  List <Proveedor> listaV= proveedorControlador.listarProveedorCB();
	  
	//	 for(Proveedor tmp: listaV) {
	//	  System.out.println(tmp);
//	  

//	  }
	 
	 //	 personalControlador = new PersonalControladorImpl(); Personal resulDp =
	 //		 personalControlador.Buscarpersonal("Torres");
			 //		 	 System.out.println(resulDp); 
	 
	 
	 // esta linstanfo y buscando 
	 // 	  proveedorControlador = new ProveedorControladorImpl();
	 // //  	List <Proveedor> listaV = (List<Proveedor>) proveedorControlador.listarProveedorCB();
	 //  	 for(Proveedor tmp:listaV){  
	 //  	 System.out.println(tmp); }
 // 

 
//	// ingreso Personal //
	/*
	 * private PersonalControlador personalControlador;
	 * 
	 * @Test public void test() { // fail("Not yet implemented");
	 * 
	 * Personal nuevoPersonal = new Personal (); nuevoPersonal.setIdPersonal(0);
	 * nuevoPersonal.setNombre("luis"); nuevoPersonal.setApellido("PEREZ");
	 * nuevoPersonal.setEdad(25); nuevoPersonal.setGenero("masculino");
	 * nuevoPersonal.setTelefono(92158551);
	 * nuevoPersonal.setCorreo("Jeffersonarevalo733@gmail.com");
	 * nuevoPersonal.setCargo("Administrador");
	 * 
	 * personalControlador = new PersonalControladorImpl();
	 * personalControlador.insertarPersonal(nuevoPersonal);
	 */
//

	// ingreso PRODUCTO //

	//private ProductoControlador productoControlador;

//	@Test
	//public void test() {
//		fail("Not yet implemented");

	//	Producto nuevoProducto1 = new Producto();

////		nuevoProducto1.setIdproducto(11);
//		nuevoProducto1.setNombreProducto("mentol");
//		nuevoProducto1.setDescripcion("antigripal");
//		/*
//		 * nuevoProducto.setFechacaducidad(2021-11-16);
//		 * nuevoProducto.setFechaelaboracion(2021-11-16);
//		 */
//		nuevoProducto1.setPrecio(100);
//		nuevoProducto1.setStock("Vigente");

//		productoControlador = new ProductoControladorImpl();
//		productoControlador.insertarProducto(nuevoProducto1);
       
	//	productoControlador.BuscarproductoDescripcion("Manejo intrahospitalario de malaria severa");
	//	productoControlador.actualizarProducto(mentol);
		// ingreso Pedidos//

		/*
		 * private PedidoControlador pedidoControlador;
		 * 
		 * @Test public void test() { // fail("Not yet implemented");
		 * 
		 * Pedido nuevoPedido = new Pedido(); nuevoPedido.setIdpedido(0234);
		 * nuevoPedido.setDetallePedido(" se pide vacunas para el covid");
		 * nuevoPedido.setIngresoPedido(0112); nuevoPedido.setCantidadPedido(10);
		 * nuevoPedido.setNombrePedido("vacunas Pfizer");
		 * nuevoPedido.setFechaEnvio(21-1-15); nuevoPedido.setFechaPedido(21-1-16);
		 * nuevoPedido.setReclamoPedido("No hay defectos en el producto");
		 
		
		 pedidoControlador = new PedidoControladorImpl();
		 pedidoControlador.insertarPedido(nuevoPedido);
		

		// ingreso Compra //

		/*
		 * Compra nuevoCompra = new Compra(); nuevoCompra.setIdCompra(0);
		 * nuevoCompra.setFkPersonal(null);
		 * nuevoCompra.setComprapeliculas("peliculas de terror");
		 * nuevoCompra.setDetallePedido("Envio de peliculas de estreno 2021");
		 * nuevoCompra.setFechaEnvio(2021-01-16);
		 * nuevoCompra.setFechaPedido(2021-01-15);
		 * nuevoCompra.setDetallePedido("Peliculas de Estreno genero terror");
		 * nuevoCompra.setCantidadPedido(1); nuevoCompra.
		 * setComprapeliculas("Se confirma por correo o al numero celular con sms");
		 * 
		 * compraControlador = new CompraControladorImpl();
		 * compraControlador.insertarCompra(nuevoCompra);
		 */

		/// PROVEEDOR (CONSULTAS) ///

		/* LISTAR */

		/*
		 * proveedorControlador = new ProveedorControladorImpl(); List <Proveedor>
		 * listaV = proveedorControlador.listarProveedorCB(); for(Proveedor tmp:listaV){
		 * System.out.println(tmp); }
		 */

		/* LEER */

		/*
		 * proveedorControlador = new ProveedorControladorImpl(); List<Tuple> listaV =
		 * proveedorControlador.leerNombreApellido(); for(Tuple tmp:listaV){
		 * System.out.println(tmp.get(0)+"-"+tmp.get(0)); }
		 */

		/*
		 * proveedorControlador = new ProveedorControladorImpl(); Proveedor buscar =
		 * proveedorControlador.Buscarproveedor("Erazo"); System.out.println(buscar);
		 */

		/* LEER TYPE QUERY */

//		
//		  proveedorControlador = new ProveedorControladorImpl(); 
//		  
//		  List<Proveedor> listaV = proveedorControlador.listarProveedorTB();
//		  
//		  for(Proveedor tmp:listaV){
//		  System.out.println(tmp); 
//		  }
//	
//		  }
		  
		  ///PERSONAL (CONSULTAS) ///
//		 * 
//		 * 
//		 * personalControlador = new PersonalControladorImpl(); List<Personal> listaP =
//		 * personalControlador.listarPersonal(); for(Personal tmp : listaP) {
//		 * System.out.println(tmp); }
//		 * 
	
		  /* personalControlador = new PersonalControladorImpl(); Personal resulP =
		 *personalControlador.buscarPersonalNombre("luis"); System.out.println(resulP);
		 */

		/*
		 * personalControlador = new PersonalControladorImpl(); Personal resulC =
		 * personalControlador.BuscarpersonalEmail("Jeffersonarevalo733@gmail.com");
		 * System.out.println(resulC);
		 */

		/// PELICULAS CONSULTA ///

		/*
		 * peliculaControlador = new PeliculaControladorImpl(); List<Pelicula> lista =
		 * peliculaControlador.listarPelicula(); for(Pelicula tmp : lista) {
		 * System.out.println(tmp); }
		 */

		/////
		/*
		 * peliculaControlador = new PeliculaControladorImpl(); Pelicula resulP =
		 * peliculaControlador.buscarPeliculanombrePelicula("RapidosyFuriosos");
		 * System.out.println(resulP); }
		 */

		/*
		 * peliculaControlador = new PeliculaControladorImpl(); Pelicula resulL =
		 * peliculaControlador.buscarPeliculageneroPelicula("Accion");
		 * System.out.println(resulL);
		 */

		/*
		 * List<Pelicula> lista=peliculaControlador.listarPeliculaTypeQuery();
		 * for(Pelicula tmp:lista) { System.out.println(tmp); }
		 */

		/// CONSULTAS (COMPRA) ///

		/*
		 * compraControlador = new CompraControladorImpl(); Compra resul =
		 * compraControlador.Buscarcompra("Envio de peliculas de estreno 2021");
		 * System.out.println(resul);
		 * 
		 * }
		 */

		/*
		 * List<Compra> lista=compraControlador.listarCompraTypeQuery(); for(Compra
		 * tmp:lista) { System.out.println(tmp);
		 * 
		 * }
		 */
		/// CONSULTAS ((DETALLE PEDIDO) ///

		
	//		 pedidoControlador = new PedidoControladorImpl();
	//			 List<Pedido> lista =
	//		 pedidoControlador.listarPedidoCB(); for(Pedido tmp: lista) {
			//			//		System.out.println(tmp); }
		

	
		 
	 //  pedidoControlador = new PedidoControladorImpl(); Pedido resulDp =
	 //	  pedidoControlador.BuscarpedidodetallePedido("es una pastilla analgesica para la gripe ");
	 //	 System.out.println(resulDp); 
	 
 }		 


 }	
 
		 
		 
		 
		 
		 
		 