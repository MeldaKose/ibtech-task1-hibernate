package com.meldakose.repositories;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateBaseRepo<T> {
	
	private Class<T> type;
	public HibernateBaseRepo(Class<T> type) {
        this.type = type;
   }
	public SessionFactory getConnection () throws HibernateException{
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(type).buildSessionFactory();
	    return factory;
		}
		
		public void add(T entity) {
			SessionFactory factory=getConnection();
			try (Session session=factory.getCurrentSession()) {
				session.beginTransaction();
				session.save(entity);
				session.getTransaction().commit();
			}finally {
				factory.close();
			}
		}
		
		public T get(long id) {
			SessionFactory factory=getConnection();
			T c;
			try (Session session=factory.getCurrentSession()) {
				session.beginTransaction();
				c=session.get(type,id);
				session.getTransaction().commit();
			}finally {
				factory.close();
			}
			return c;
		}
		
		public List<T> getAll() {
			SessionFactory factory=getConnection();
			List<T> data;
			try (Session session=factory.getCurrentSession()) {
				session.beginTransaction();
				CriteriaBuilder cb = session.getCriteriaBuilder();
			    CriteriaQuery<T> cq = cb.createQuery(type);
			    Root<T> rootEntry = cq.from(type);
			    CriteriaQuery<T> all = cq.select(rootEntry);
			    TypedQuery<T> allQuery = session.createQuery(all);
			    data=allQuery.getResultList();
				session.getTransaction().commit();
			}finally {
				factory.close();
			}
			return data;
			
		}
		
		public void update(T entity) {
			SessionFactory factory=getConnection();
			try (Session session=factory.getCurrentSession()) {
				session.beginTransaction();
				session.saveOrUpdate(entity);
				session.getTransaction().commit();
			}finally {
				factory.close();
			}
		}
		
		public void delete(T entity) {
			SessionFactory factory=getConnection();
			try (Session session=factory.getCurrentSession()) {
				session.beginTransaction();
				session.remove(entity);
				session.getTransaction().commit();
			}finally {
				factory.close();
			}
		}
}
