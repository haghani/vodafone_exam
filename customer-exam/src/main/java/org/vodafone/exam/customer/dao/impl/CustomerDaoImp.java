package org.vodafone.exam.customer.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.vodafone.exam.customer.dao.CustomerDao;
import org.vodafone.exam.customer.exception.CustomerNotFoundException;
import org.vodafone.exam.customer.model.CustomerModel;

/**
 * Dao implement class
 * 
 * @author Adeleh
 *
 */
public class CustomerDaoImp implements CustomerDao {

	public CustomerDaoImp() {

	}

	public static SessionFactory getSessionFactory() {

		Configuration configuration = new Configuration().configure();

		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());

		return configuration.buildSessionFactory(builder.build());

	}

	/**
	 * create customer
	 */
	@Override
	public void creatrCustomer(final CustomerModel customer) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.save(customer);
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * 
	 */

	@Override
	public void updateCustomer(final CustomerModel customer) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.update(customer);
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * 
	 */

	@Override
	public void deleteCustomer(final long customerId) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		try {
			Query query = session.createQuery(
					"from CustomerModel where id = ?");
			query.setLong(0, customerId);
			List<CustomerModel> targetCustomets = query.list();
			if (targetCustomets != null && !targetCustomets.isEmpty())
				session.delete(targetCustomets.get(0));
			else
				throw new CustomerNotFoundException("customer " + customerId
						+ " not found for delete");
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

	/**
	 * 
	 */

	@Override
	public List<CustomerModel> findAllCustomer() {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Query query =session.createQuery(
				"from CustomerModel");
		List<CustomerModel> targetCustomets = query.list();
		
		session.getTransaction().commit();
		session.close();
		return targetCustomets;
	}

}
