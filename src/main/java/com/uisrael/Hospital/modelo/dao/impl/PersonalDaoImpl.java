package com.uisrael.Hospital.modelo.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.uisrael.Hospital.modelo.dao.PersonalDao;
import com.uisrael.Hospital.modelo.entidades.Personal;

public class PersonalDaoImpl extends GenericaDaoImpl<Personal> implements PersonalDao {
	
	EntityManager em = emf.createEntityManager();

	@Override
	public void insertarPersonal(Personal nuevoPersonal) {
		
		
			this.beginTransaction();
			this.create(nuevoPersonal);
			this.commit();
			try {
			/*em.getTransaction().begin();
			em.persist(nuevoCliente);
			em.getTransaction().commit();*/
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	@Override
	public void actualizarPersonal(Personal actualizarPersonal) {
		try{
			this.beginTransaction();
			this.actualizarPersonal(actualizarPersonal);
			this.update(actualizarPersonal);
			this.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		}

	@Override
	public void eliminarPersonal(Personal eliminarPersonal) {
		try{
			this.beginTransaction();
			this.delete(eliminarPersonal);
			this.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		}
	

	@Override
	public List<Personal> listarPersonalCB() {
		
		CriteriaBuilder cb= em.getCriteriaBuilder();
		//2.-Crea la consulta y define el resultado
	CriteriaQuery<Personal> c= cb.createQuery(Personal.class);
	//3.-	define el orgigen de la consulta tabla
	Root<Personal> personal = c.from(Personal.class);	
	c.select(personal);
	return em.createQuery(c).getResultList();
	}



	public List<Tuple> leerNombreApellido() {
		
		CriteriaBuilder cb= em.getCriteriaBuilder();
		CriteriaQuery<Tuple> c= cb.createTupleQuery();
		Root<Personal> personal = c.from(Personal.class);	
			c.select(cb.tuple(personal.get("nombre"),personal.get("apellido")));
			return em.createQuery(c).getResultList();
			}



	public List<Personal> listarPersonalTB() {
		
		CriteriaBuilder cb= em.getCriteriaBuilder();
		CriteriaQuery<Personal> c= cb.createQuery(Personal.class);
		Root<Personal> personal = c.from(Personal.class);	
		c.select(personal);
		return em.createQuery(c).getResultList();
			}



public List<Personal> buscarpersonal(String nombreapellido){
	TypedQuery<Personal> q2 = em.createQuery("Select v from Personal v",Personal.class);
 return q2.getResultList();
	}
	
	
@Override
public Personal Buscarpersonal(String nombreapellido) {
	CriteriaBuilder cb= em.getCriteriaBuilder();
	CriteriaQuery<Personal> c= cb.createQuery(Personal.class);
	Root<Personal> personal = c.from(Personal.class);	
		c.select(personal).where(cb.equal(personal.get("apellido"), nombreapellido));
		return em.createQuery(c).getSingleResult();
}



	@Override
	public List<Personal> listarPersonalTQ() {
		TypedQuery<Personal> tc= this.entityManager.createQuery("Select c From Personal c", Personal.class);
		return tc.getResultList();
	}


	
	public Personal burcarPersonalEmailTQ(String email){
		TypedQuery<Personal> tc= this.entityManager.createQuery("Select c From Personal c where c.email=:"+email, Personal.class);
		return tc.getSingleResult();
	}
	
	
	
	@Override
	public Personal burcarPersonalEmail(String email) {
		
		CriteriaBuilder cb= this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Personal> c= cb.createQuery(Personal.class);
		Root<Personal> personal= c.from(Personal.class);
		c.select(personal).where(cb.equal(personal.get("email"), email));
		return this.entityManager.createQuery(c).getSingleResult();
	}

	@Override
	public Personal LoginPersonal(String nombre, String cedula) {
		// TODO Auto-generated method stub
				String Sql = "Select c From Personal c where c.nombre=:nombre and c.password=:cedula";
				TypedQuery <Personal> buscarTqPersonal = this.entityManager.createQuery(Sql,Personal.class).setParameter("cedula", cedula).setParameter("password", cedula);
				return buscarTqPersonal.getSingleResult();
	}
		
}
	
