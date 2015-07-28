package org.vodafone.exam.customer.dao;

import java.util.List;

import org.vodafone.exam.customer.model.CustomerModel;

public interface CustomerDao {
	public long createCustomer(CustomerModel customer);
	
	public boolean updateCustomer(CustomerModel customer);
	 
	public boolean deleteCustomer(final long customerId);
	
	public List<CustomerModel> findAllCustomer();
}
