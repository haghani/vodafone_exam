package org.vodafone.exam.customer.service.impl;

import java.io.Serializable;
import java.util.List;

import org.vodafone.exam.customer.dao.CustomerDao;
import org.vodafone.exam.customer.dao.impl.CustomerDaoImp;
import org.vodafone.exam.customer.model.CustomerModel;
import org.vodafone.exam.customer.service.CustomerService;

/**
 * customer service implement
 * 
 * @author Adeleh
 *
 */
public class CustomerServiceImp implements CustomerService, Serializable {

	/**
	 * customer dao
	 */
	private CustomerDao customerDao;

	public CustomerServiceImp(){
		customerDao = new CustomerDaoImp();
	}
	/**
	 * set customer dao
	 * 
	 * @param customerDao
	 */
	public void setCustomerDao(final CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	/**
	 * create customer
	 */
	@Override
	public long createCustomer(CustomerModel customer) {
		customerDao.createCustomer(customer);
		return customer.getId();
	}
	
	/**
	 * updatec customer
	 */
	@Override
	public boolean updateCustomer(final CustomerModel customer) {
		return customerDao.updateCustomer(customer);
	}

	/**
	 * delete customer
	 */
	@Override
	public boolean deleteCustomer(final long customerId) {
		return customerDao.deleteCustomer(customerId);

	}

	/**
	 * read customer
	 */
	@Override
	public List<CustomerModel> readAllCustomer() {
		return customerDao.findAllCustomer();
	}

}
