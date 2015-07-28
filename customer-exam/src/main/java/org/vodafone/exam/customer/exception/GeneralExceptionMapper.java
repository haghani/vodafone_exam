package org.vodafone.exam.customer.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.vodafone.exam.customer.model.ErrorMessage;

/**
 * By having implementations of ExceptionMapper to handle exceptions and errors,
 * the service can provide a meaningful JSON response instead of stack trace to
 * the clients for all exceptions except InvalidParamterException and
 * CustomerNotFoundException. It also provides other capabilities like logging,
 * sending notifications etc.,
 *
 * @author Adeleh
 * @version 0.1 Build July 26, 2015.
 */
@Provider
public class GeneralExceptionMapper implements ExceptionMapper<Throwable> {
	/**
	 * 
	 * Map an exception to a Response.
	 * 
	 * @param ex
	 *            CustomerNotFoundException
	 * 
	 * @return Response
	 **/
	@Override
	public Response toResponse(Throwable ex) {
		ErrorMessage error = new ErrorMessage(500, ex.getMessage(),
				"This is a description for all other Exception.\n ---");
		ex.printStackTrace();
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(error)
				.build();

	}

}
