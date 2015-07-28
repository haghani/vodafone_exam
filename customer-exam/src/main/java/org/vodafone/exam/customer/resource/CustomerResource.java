package org.vodafone.exam.customer.resource;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.transaction.Status;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.container.TimeoutHandler;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ManagedAsync;
import org.vodafone.exam.customer.bean.CustomerParameterBean;
import org.vodafone.exam.customer.model.CustomerModel;
import org.vodafone.exam.customer.service.CustomerService;
import org.vodafone.exam.customer.service.impl.CustomerServiceImp;

/**
 * This is the main resource of project.
 *
 * @author Adeleh
 * @version 0.1 Build July 26, 2015.
 */

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/customers")
public class CustomerResource {
	private CustomerService customerService;

	public CustomerResource() {
		this(new CustomerServiceImp());
	}

	public CustomerResource(CustomerService customerService) {
		this.customerService = customerService;
	}

	/**
	 * 
	 * Set customer service
	 * 
	 * @param customerService
	 *            CustomerService class.
	 */
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	/**
	 * Run addCustomer method of service object and sent inserted customer model
	 * object in response asynchronously.
	 * 
	 * @param asyncResponse
	 *            By this parameter into we tell the Jersey runtime that the
	 *            method is supposed to be invoked using the asynchronous
	 *            processing mode
	 * @param customer
	 *            CustomerModel which come from client.
	 */
	@POST
	@ManagedAsync
	public void addCustomer(@Suspended final AsyncResponse asyncResponse,
			final CustomerModel customer) throws InterruptedException {

		handleTimeout(asyncResponse, 20, "Getting customer operation time out!");

		customerService.creatrCustomer(customer);
		asyncResponse.resume(customer);

	}

	/**
	 * Run getCustomers method of service object and sent list of customer model
	 * objects in response asynchronously. In this method we use @ManagedAsync
	 * instead of thread programming.
	 * 
	 * @param asyncResponse
	 *            By this parameter into we tell the Jersey runtime that the
	 *            method is supposed to be invoked using the asynchronous
	 *            processing mode
	 * @param customerParamBean
	 *            CustomerParameterBean which may contain customer name, offset
	 *            and limit for filtering.
	 */

	@GET
	@ManagedAsync
	public void getCustomers(@Suspended final AsyncResponse asyncResponse,
			@BeanParam CustomerParameterBean customerParamBean) {
		handleTimeout(asyncResponse, 20, "Getting customer operation time out!");
		List<CustomerModel> matched;
		GenericEntity<List<CustomerModel>> entity;

		matched = customerService.readAllCustomer();
		entity = new GenericEntity<List<CustomerModel>>(matched) {
		};

		asyncResponse.resume(entity);

	}

	/**
	 * Run updateCustomer method of service object and puts updated customer
	 * model in response object, and runs asynchronously
	 * 
	 * @param asyncResponse
	 *            By this parameter into we tell the Jersey runtime that the
	 *            method is supposed to be invoked using the asynchronous
	 *            processing mode
	 * @param customerId
	 *            Selected customer id.
	 * @param customer
	 *            Changed customer customer model.
	 */

	@PUT
	@Path("/{customerId}")
	@ManagedAsync
	public void updateCustomer(@Suspended final AsyncResponse asyncResponse,
			@PathParam("customerId") long customerId,
			final CustomerModel customer) {
		customer.setId(customerId);

		customerService.updateCustomer(customer);
		asyncResponse.resume(customer);

	}

	/**
	 * Run deleteCustomer method of service object asynchronously
	 * 
	 * @param asyncResponse
	 *            By this parameter into we tell the Jersey runtime that the
	 *            method is supposed to be invoked using the asynchronous
	 *            processing mode
	 * @param customerId
	 *            Selected customer id.
	 */

	@DELETE
	@Path("/{customerId}")
	@ManagedAsync
	public void deleteCustomer(@Suspended final AsyncResponse asyncResponse,
			@PathParam("customerId") final long customerId) {
		customerService.deleteCustomer(customerId);

	}

	/**
	 * In this method timeout handler will be set.
	 * 
	 * @param asyncResponse
	 *            Timeout will be set in this parameter
	 * @param timeoutDuration
	 *            waiting time in sec.
	 * @param message
	 *            Massage in case of time out.
	 */
	public void handleTimeout(AsyncResponse asyncResponse, int timeoutDuration,
			final String message) {
		asyncResponse.setTimeoutHandler(new TimeoutHandler() {

			@Override
			public void handleTimeout(final AsyncResponse asyncResponse) {
				Response response = Response
						.status(Response.Status.SERVICE_UNAVAILABLE)
						.entity(message).build();
				asyncResponse.resume(response);
			}
		});
		asyncResponse.setTimeout(timeoutDuration, TimeUnit.SECONDS);

	}
}
