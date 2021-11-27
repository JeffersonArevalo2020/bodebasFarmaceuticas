package com.uisrael.Hospital.modelo.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.uisrael.Hospital.modelo.dao.CompraDao;
import com.uisrael.Hospital.modelo.entidades.Compra;

public class CompraDaoImpl extends GenericaDaoImpl <Compra>  implements CompraDao {
	
	EntityManager em = emf.createEntityManager();

	@Override
	public void insertarCompra(Compra nuevoCompra) {
		
		EntityTransaction ext= em.getTransaction();
		ext.begin();
		em.persist(nuevoCompra);
		ext.commit();
		
		
	try {
		/*em.getTransaction().begin();
		em.persist(nuevoCompra);
		em.getTransaction().commit();*/
	} catch (Exception e)	{
		// TODO: handle exception
	}
	}
	


	@Override
	public void actualizarCompra(Compra actualizarCompra) {
	
			try {
				this.beginTransaction();
				this.actualizarCompra(actualizarCompra);		
				this.commit();		
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
	
	
	@Override
	public void eliminarCompra(Compra eliminarCompra) {
		try {
			this.beginTransaction();
			this.delete(eliminarCompra);	
			this.commit();		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	

	
	@Override
	public List<Compra> listarCompraCB() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Compra> c = cb.createQuery(Compra.class);
		Root<Compra> compra = c.from(Compra.class);
		c.select(compra);
		return em.createQuery(c).getResultList();
		}

	public List<Tuple> leerproductoPedido() {
	
	CriteriaBuilder cb= em.getCriteriaBuilder();
		CriteriaQuery<Tuple> c= cb.createTupleQuery();
		Root<Compra> compra = c.from(Compra.class);	
			c.select(cb.tuple(compra.get("productoPedido"),compra.get("productoPedido")));
			return em.createQuery(c).getResultList();
		}
	

	public List<Compra> listarCompraTB() {
		
		CriteriaBuilder cb= em.getCriteriaBuilder();
		CriteriaQuery<Compra> c= cb.createQuery(Compra.class);
		Root<Compra> compra = c.from(Compra.class);	
		c.select(compra);
		return em.createQuery(c).getResultList();
	}
	

	public List<Compra> buscarcompra(String detallePedido){
		TypedQuery<Compra> q2 = em.createQuery("Select v from Compra v",Compra.class);
		 return q2.getResultList();
		
		}
		
	
	@Override
	public Compra Buscarcompra(String detallePedido) {
		CriteriaBuilder cb= em.getCriteriaBuilder();
		CriteriaQuery<Compra> c= cb.createQuery(Compra.class);
		Root<Compra> compra = c.from(Compra.class);	
			c.select(compra).where(cb.equal(compra.get("detallePedido"), detallePedido));
			return em.createQuery(c).getSingleResult();
	}
	


	@Override
	public List<Compra> listarCompraTQ() {
		TypedQuery<Compra> tc= this.entityManager.createQuery("Select c From Compra c", Compra.class);
		return tc.getResultList();

	}


	public Compra burcarCompraproductoPedido(String productoPedido) {
		TypedQuery<Compra> tc= this.entityManager.createQuery("Select c From Compra c where c.productoPedido=:"+productoPedido, Compra.class);
		return tc.getSingleResult();
	}

		@Override
		public Compra burcarCompracantidadPedido(String cantidadPedido) {
			CriteriaBuilder cb= this.entityManager.getCriteriaBuilder();
			CriteriaQuery<Compra> c= cb.createQuery(Compra.class);
			Root<Compra> compra= c.from(Compra.class);
			c.select(compra).where(cb.equal(compra.get("cantidadPedido"), cantidadPedido));
			return this.entityManager.createQuery(c).getSingleResult();
			
	
		}



}