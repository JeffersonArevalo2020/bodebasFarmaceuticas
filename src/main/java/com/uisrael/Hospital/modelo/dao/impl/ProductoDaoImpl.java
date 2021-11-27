package com.uisrael.Hospital.modelo.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.uisrael.Hospital.modelo.dao.ProductoDao;
import com.uisrael.Hospital.modelo.entidades.Producto;

public class ProductoDaoImpl extends GenericaDaoImpl < Producto> implements  ProductoDao{
	
	EntityManager em = emf.createEntityManager();
	@Override
	public void insertarProducto(Producto nuevoProducto) {
		

		try {
		this.beginTransaction();
		this.create(nuevoProducto);
		this.commit();
		/*em.getTransaction().begin();
		em.persist(nuevoProducto);
		em.getTransaction().commit();*/
	} catch (Exception e) {
		// TODO: handle exception
	}
	}
		
	


	@Override
	public void actualizarProducto(Producto actualizarProducto) {
		
		em.getTransaction().begin();
		em.merge(actualizarProducto);
		em.getTransaction().commit();
		
		try {
			this.beginTransaction();
			this.actualizarProducto(actualizarProducto);
			this.commit();		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	@Override
	public void eliminarProducto(Producto elimninarProducto) {
		try {
			this.beginTransaction();
			this.delete(elimninarProducto);
			this.commit();		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


	@Override
	public List<Producto> listarProductoCB() {
	//select * from Proveedor;
		
			//CriteriaBuilder cb= em.getCriteriaBuilder();
		CriteriaBuilder cb= em.getCriteriaBuilder();
		//2.-Crea la consulta y define el resultado
	CriteriaQuery<Producto> c= cb.createQuery(Producto.class);
	//3.-	define el orgigen de la consulta tabla
	Root<Producto> producto = c.from(Producto.class);	
	c.select(producto);
	return em.createQuery(c).getResultList();
	}

	@Override
	public List<Tuple> leerNombrePrecio() {
		
		CriteriaBuilder cb= em.getCriteriaBuilder();
		CriteriaQuery<Tuple> c= cb.createTupleQuery();
		Root<Producto> producto = c.from(Producto.class);	
			c.select(cb.tuple(producto.get("nombre"),producto.get("precio")));
			return em.createQuery(c).getResultList();
			}




	@Override
	public List<Producto> listarProductoTB() {
		CriteriaBuilder cb= em.getCriteriaBuilder();
		CriteriaQuery<Producto> c= cb.createQuery(Producto.class);
		Root<Producto> producto = c.from(Producto.class);	
		c.select(producto);
		return em.createQuery(c).getResultList();

	}



public List<Producto> buscarproducto(String idProducto){
	TypedQuery<Producto> q2 = em.createQuery("Select v from Producto v",Producto.class);
 return q2.getResultList();
	}




@Override
public Producto Buscarproducto(String idProducto) {

		CriteriaBuilder cb= em.getCriteriaBuilder();
	CriteriaQuery<Producto> c= cb.createQuery(Producto.class);
		Root<Producto> producto = c.from(Producto.class);	
			c.select(producto).where(cb.equal(producto.get("descripcion"), idProducto));
			return em.createQuery(c).getSingleResult();
}

public List<Producto> listarProductoTQ(){
	TypedQuery<Producto> tc= this.entityManager.createQuery("Select c From Producto c", Producto.class);
	return tc.getResultList();
}


public Producto burcarProductoDescripcionTQ(String descripcion){
	TypedQuery<Producto> tc= this.entityManager.createQuery("Select c From Producto c where c.descripcion=:"+descripcion, Producto.class);
	return tc.getSingleResult();
}


@Override
public Producto buscarProductoDescripcion(String descripcion) {
	CriteriaBuilder cb= this.entityManager.getCriteriaBuilder();
	CriteriaQuery<Producto> c= cb.createQuery(Producto.class);
	Root<Producto> producto= c.from(Producto.class);
	c.select(producto).where(cb.equal(producto.get("descripcion"), descripcion));
	return this.entityManager.createQuery(c).getSingleResult();
	
}



}


