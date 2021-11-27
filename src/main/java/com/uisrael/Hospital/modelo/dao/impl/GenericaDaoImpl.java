package com.uisrael.Hospital.modelo.dao.impl;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericaDaoImpl<T>
{
    private Class<T> entityClass;
    
    protected static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("HospitalPU");
    protected EntityManager entityManager;

    public GenericaDaoImpl() 
    {
        entityManager = emf.createEntityManager();
    }
    
    public GenericaDaoImpl(Class<T>entityClass)
    {
        this.entityClass = entityClass;
        entityManager = emf.createEntityManager();
    }
    
    //Definimos el CRUD
    public T create(T t)
    {
        this.entityManager.persist(t);
        return t;
    }
    
    public T read (Object id)
    {
        return this.entityManager.find(entityClass, id);
    }
    
    public T update (T t)
    {
        return this.entityManager.merge(t);
    }
    
    public void delete(T t)
    {
        t = this.entityManager.merge(t);
        this.entityManager.remove(t);
    }
    
    
    //Definir los parámetros
    public void beginTransaction()
    {
        if(!entityManager.getTransaction().isActive())
            entityManager = emf.createEntityManager();
        
        entityManager.getTransaction().begin();    
    }
    
    public void commit()
    {
        if(entityManager.getTransaction().isActive())
            entityManager.getTransaction().commit();
    }
    
    public void rollback()
    {
         if(entityManager.getTransaction().isActive())
            entityManager.getTransaction().rollback();
    }
    
    public void closeTransaction()
    {
        entityManager.close();
    }
    
    public void commitAndCloseTransaction()
    {
        commit();
        closeTransaction();
    }
    
    public void flush()
    {
        entityManager.flush();
    }
    
    public List<T> findAll()
    {
        javax.persistence.criteria.CriteriaQuery cq = this.entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return this.entityManager.createQuery(cq).getResultList();
    }
    
}