package org.vodafone.exam.customer.resource;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.vodafone.exam.customer.model.CustomerModel;
import org.vodafone.exam.customer.service.CustomerService;

/**
 * This class is used in order to mocking test. I've just implement two method
 * as a sample due to lack of time.
 * 
 * @author Adeleh
 * @version 0.1 Build July 26, 2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerResourceMockingTest {
	private static CustomerResource customerResource;
	@Mock
	private CustomerService customerServiceMock;
	public static InMemoryRestServer server;

	@BeforeClass
	public static void beforeClass() throws Exception {
		server = InMemoryRestServer.create(customerResource);
	}

	@AfterClass
	public static void afterClass() throws Exception {
		server.close();
	}

	@Test
	public void getCustomersWithMocking() throws Exception {
		List<CustomerModel> customers = new ArrayList<CustomerModel>();
		CustomerModel customer1 = new CustomerModel(1L, "Name 1", "Address 1",
				"111");
		CustomerModel customer2 = new CustomerModel(2L, "Name 2", "Address 2",
				"222");
		customers.add(customer1);
		customers.add(customer2);

		Mockito.when(customerServiceMock.readAllCustomer()).thenReturn(
				customers);

		Response response = server
				.newRequest("/customer-exam/webapi/customers").request().get();

		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
		List<CustomerModel> persistedCustomer = (List<CustomerModel>) response
				.readEntity(List.class);
		assertEquals(persistedCustomer, customers);
	}

	@Test
	public void createCustomerWithMocking() throws Exception {
		CustomerModel customer = new CustomerModel("Name 1", "Address 1", "111");

		Mockito.when(customerServiceMock.createCustomer(customer)).thenReturn(
				1L);

		Response response = server
				.newRequest("/customer-exam/webapi/customers").request().get();

		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
		CustomerModel persistedCustomer = response
				.readEntity(CustomerModel.class);
		assertEquals(persistedCustomer, customer);
	}

	@Test
	public void deleteCustomerWithMocking() throws Exception {

		Mockito.when(customerServiceMock.deleteCustomer(1L)).thenReturn(true);

		Response response = server
				.newRequest("/customer-exam/webapi/customers").request().get();

		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}
}
