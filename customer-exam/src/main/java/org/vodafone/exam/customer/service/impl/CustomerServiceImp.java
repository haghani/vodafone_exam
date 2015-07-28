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
	public void creatrCustomer(final CustomerModel customer) {
		customerDao.creatrCustomer(customer);
	}
	
	/**
	 * updatec customer
	 */
	@Override
	public void updateCustomer(final CustomerModel customer) {
		customerDao.updateCustomer(customer);
	}

	/**
	 * delete customer
	 */
	@Override
	public void deleteCustomer(final long customerId) {
		customerDao.deleteCustomer(customerId);

	}

	/**
	 * read customer
	 */
	@Override
	public List<CustomerModel> readAllCustomer() {
		return customerDao.findAllCustomer();
	}

}
