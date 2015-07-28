package org.vodafone.exam.customer.service;

import java.util.List;

import org.vodafone.exam.customer.model.CustomerModel;

/**
 * 
 * @author Adeleh
 *
 */
public interface CustomerService {
	/**
	 * create customer
	 * 
	 * @param customer
	 */
	public void creatrCustomer(final CustomerModel customer);

	/**
	 * update
	 * 
	 * @param customer
	 */
	public void updateCustomer(final CustomerModel customer);

	/**
	 * delete
	 * 
	 * @param customer
	 */
	public void deleteCustomer(final long customerId);

	/**
	 * read
	 * 
	 * @return
	 */
	public List<CustomerModel> readAllCustomer();

}
