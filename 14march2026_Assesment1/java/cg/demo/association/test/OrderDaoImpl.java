package cg.demo.association.test;

import java.util.List;



import jakarta.persistence.*;;



public class OrderDaoImpl implements OrderDao {
	  EntityManagerFactory emf =Persistence.createEntityManagerFactory("JPAHibernate");

	    EntityManager em = emf.createEntityManager();

	@Override
	public boolean addOrder(Order order,int custId) {
		
		 EntityTransaction tx = em.getTransaction();

	        tx.begin();

	        Customer cust = em.find(Customer.class, custId);

	      
	        order.setCustomer(cust);

	       
	        em.persist(order);

	        tx.commit();

	        return true;
	}

	@Override
	public Order getorder(int orderId) {
		 Order order = em.find(Order.class, orderId);

	     return order;
		
		
	}

	@Override
	public List<Order> getOrders(String custName) {
		 String jpql = "select o from Order o where o.customer.customerName=:name";

	    TypedQuery<Order> query =em.createQuery(jpql, Order.class);

	    query.setParameter("name", custName);

	    List<Order> list = query.getResultList();

			        return list;
		
		
	}

	
	

}
