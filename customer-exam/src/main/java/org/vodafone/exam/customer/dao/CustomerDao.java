package org.vodafone.exam.customer.dao;

import java.util.List;

import org.vodafone.exam.customer.model.CustomerModel;

public interface CustomerDao {
	public void creatrCustomer(CustomerModel customer);
	
	public void updateCustomer(CustomerModel customer);
	 
	void deleteCustomer(final long customerId);
	
	public List<CustomerModel> findAllCustomer();
}
