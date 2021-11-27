package com.uisrael.Hospital.modelo.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.uisrael.Hospital.modelo.dao.PedidoDao;
import com.uisrael.Hospital.modelo.entidades.Pedido;



public class PedidoDaoImpl extends GenericaDaoImpl <Pedido> implements PedidoDao{
	
	EntityManager em = emf.createEntityManager();

	@Override
	public void insertarPedido(Pedido nuevoPedido) {
	
		
		try {
			this.beginTransaction();
			this.create(nuevoPedido);
			this.commit();
			/*em.getTransaction().begin();
			em.persist(nuevoCliente);
			em.getTransaction().commit();*/
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	

	@Override
	public void actualizarPedido(Pedido actualizarPedido) {
	
		try{
		this.beginTransaction();
		this.actualizarPedido(actualizarPedido);
		this.update(actualizarPedido);
		this.commit();
	} catch (Exception e) {
		// TODO: handle exception
	}
	}

	@Override
	public void eliminarPedido(Pedido eliminarPedido) {
		try{
			this.beginTransaction();
			this.delete(eliminarPedido);
			this.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		}

	@Override
	public List<Pedido> listarPedidoCB() {
		
		CriteriaBuilder cb= em.getCriteriaBuilder();
		//2.-Crea la consulta y define el resultado
	CriteriaQuery<Pedido> c= cb.createQuery(Pedido.class);
	//3.-	define el orgigen de la consulta tabla
	Root<Pedido> pedido = c.from(Pedido.class);	
	c.select(pedido);
	return em.createQuery(c).getResultList();
	}


	@Override
	public List<Tuple> leerdetallePedido() {
		CriteriaBuilder cb= em.getCriteriaBuilder();
		CriteriaQuery<Tuple> c= cb.createTupleQuery();
		Root<Pedido> pedido = c.from(Pedido.class);	
			c.select(cb.tuple(pedido.get("detallePedido")));
			return em.createQuery(c).getResultList();
			}


	@Override
	public List<Pedido> listarPedidoTB() {
		CriteriaBuilder cb= em.getCriteriaBuilder();
		CriteriaQuery<Pedido> c= cb.createQuery(Pedido.class);
		Root<Pedido> pedido = c.from(Pedido.class);	
		c.select(pedido);
		return em.createQuery(c).getResultList();
			}
	
	public List<Pedido> buscarpedido(String detallePedido){
		TypedQuery<Pedido> q2 = em.createQuery("Select v from Pedido v",Pedido.class);
	 return q2.getResultList();
		}


	@Override
	public Pedido Buscarpedido(String detallePedido) {
		
		CriteriaBuilder cb= em.getCriteriaBuilder();
		CriteriaQuery<Pedido> c= cb.createQuery(Pedido.class);
		Root<Pedido> pedido = c.from(Pedido.class);	
			c.select(pedido).where(cb.equal(pedido.get("detallePedido"), detallePedido));
			return em.createQuery(c).getSingleResult();
}


	public List<Pedido> listarPedidoTQ() {
		TypedQuery<Pedido> tc= this.entityManager.createQuery("Select c From Pedido c", Pedido.class);
		return tc.getResultList();
	}

	
	@Override
	public Pedido burcarPedidonombrePedido(String detallePedido) {
		CriteriaBuilder cb= em.getCriteriaBuilder();
		CriteriaQuery<Pedido> c= cb.createQuery(Pedido.class);
		Root<Pedido> pedido = c.from(Pedido.class);	
		c.select(pedido).where(cb.equal(pedido.get("detallePedido"), detallePedido));
		return em.createQuery(c).getSingleResult();
}
	




	public List<Pedido> listardetallePedidoTQ(String detallePedido) {
		TypedQuery<Pedido> tc= this.entityManager.createQuery("Select c From Pedido c where c.detallePedido="+detallePedido, Pedido.class);
		return tc.getResultList();
	}


	


}