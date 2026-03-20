package com.demo.assessment;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import com.demo.assessment.entities.Order;
import com.demo.assessment.entities.Customer;


public class OrderDaoImpl implements OrderDao{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager em = emf.createEntityManager();

	public boolean addOrder(Order o, int id) {

	    em.getTransaction().begin();

	    Customer c = em.find(Customer.class, id);

	    if (c == null) {
	        em.getTransaction().rollback();
	        return false;
	    }

	    o.setCust(c);
	    em.persist(o);

	    em.getTransaction().commit();

	    return true;
	}
	
	public Order getOrder(int id) {
		em.getTransaction().begin();
		Order o = em.find(Order.class,id);
		em.getTransaction().commit();
		return o;
	}
	
	public List<Order> getOrders(String name){

	    List<Order> list = em.createQuery(
	        "SELECT o FROM Order o WHERE o.cust.Customer_name = :name", Order.class)
	    		.setParameter("name", name).getResultList();

	    return list;
	}
}








