package com.uisrael.Hospital.modelo.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.uisrael.Hospital.modelo.dao.ProveedorDao;
import com.uisrael.Hospital.modelo.entidades.Proveedor;

public class ProveedorDaoImpl extends GenericaDaoImpl <Proveedor> implements ProveedorDao{
	
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("HospitalPU");
	EntityManager em = emf.createEntityManager();

	@Override
	public void insertarProveedor(Proveedor nuevoProveedor) {
		
		
		
		try {
			this.beginTransaction();
			this.create(nuevoProveedor);
			this.commit();
			/*em.getTransaction().begin();
			em.persist(nuevoCliente);
			em.getTransaction().commit();*/
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	@Override
	public void actualizarProveedor(Proveedor actualizarProveedor) {
	
		em.getTransaction().begin();
		em.merge(actualizarProveedor);
		em.getTransaction().commit();
		
	
		try{
			this.beginTransaction();
			this.update(actualizarProveedor);		
			this.commit();
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	@Override
	public void eliminarProveedor(Proveedor eliminarProveedor) {
		try{
			this.beginTransaction();
			this.delete(eliminarProveedor);
			this.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		}

	@Override
	
	public List<Proveedor> listarProveedorCB() {
		//select * from Proveedor;
		
		//1.- crear el criterial : utilizar la conexion string
		//CriteriaBuilder cb= em.getCriteriaBuilder();
		CriteriaBuilder cb= em.getCriteriaBuilder();
		//2.-Crea la consulta y define el resultado
	CriteriaQuery<Proveedor> c= cb.createQuery(Proveedor.class);
	//3.-	define el orgigen de la consulta tabla
	Root<Proveedor> proveedor = c.from(Proveedor.class);	
	c.select(proveedor);
	return em.createQuery(c).getResultList();
	}


public List <Tuple> leerNombreApellido(){
	//select nombre, apellido from proveendor;
	
	CriteriaBuilder cb= em.getCriteriaBuilder();
	CriteriaQuery<Tuple> c= cb.createTupleQuery();
	Root<Proveedor> proveedor = c.from(Proveedor.class);	
		c.select(cb.tuple(proveedor.get("nombre"),proveedor.get("apellido")));
		return em.createQuery(c).getResultList();
		}



public List<Proveedor> listarProveedorTB(){
	CriteriaBuilder cb= em.getCriteriaBuilder();
CriteriaQuery<Proveedor> c= cb.createQuery(Proveedor.class);
Root<Proveedor> proveedor = c.from(Proveedor.class);	
c.select(proveedor);
return em.createQuery(c).getResultList();
	}



public List<Proveedor> buscarproveedor(String nombreapellido){
	TypedQuery<Proveedor> q2 = em.createQuery("Select v from Proveedor v",Proveedor.class);
 return q2.getResultList();
	}




@Override
public Proveedor Buscarproveedor(String nombreapellido) {

		CriteriaBuilder cb= em.getCriteriaBuilder();
		//select * from Cliente where proveedor=?;
		CriteriaQuery<Proveedor> c= cb.createQuery(Proveedor.class);
		Root<Proveedor> proveedor = c.from(Proveedor.class);	
			c.select(proveedor).where(cb.equal(proveedor.get("apellido"), nombreapellido));
			return em.createQuery(c).getSingleResult();
}

public List<Proveedor> listarProveedorTQ(){
	TypedQuery<Proveedor> tc= this.entityManager.createQuery("Select c From Proveedor c", Proveedor.class);
	return tc.getResultList();
}


public Proveedor burcarProveedorEmailTQ(String email){
	TypedQuery<Proveedor> tc= this.entityManager.createQuery("Select c From Proveedor c where c.email=:"+email, Proveedor.class);
	return tc.getSingleResult();
}


@Override
public Proveedor burcarProveedorEmail(String email) {
	CriteriaBuilder cb= this.entityManager.getCriteriaBuilder();
	CriteriaQuery<Proveedor> c= cb.createQuery(Proveedor.class);
	Root<Proveedor> proveedor= c.from(Proveedor.class);
	c.select(proveedor).where(cb.equal(proveedor.get("email"), email));
	return this.entityManager.createQuery(c).getSingleResult();
	
}



}


