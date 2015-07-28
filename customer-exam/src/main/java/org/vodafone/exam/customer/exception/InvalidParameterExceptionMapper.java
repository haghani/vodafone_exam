package org.vodafone.exam.customer.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.vodafone.exam.customer.model.ErrorMessage;
/**
 * By having implementations of ExceptionMapper to handle exceptions and errors,
 * the service can provide a meaningful JSON response instead of stack trace to
 * the clients. It also provides other capabilities like logging, sending
 * notifications etc.,
 *
 * @author Adeleh
 * @version 0.1 Build July 26, 2015.
 */

@Provider
public class InvalidParameterExceptionMapper implements
		ExceptionMapper<InvalidParameterException> {
	/**
	 * 
	 * Map InvalidParameterException exception to a Response.
	 * 
	 * @param ex
	 *            CustomerNotFoundException
	 * 
	 * @return Response
	 **/

	@Override
	public Response toResponse(InvalidParameterException ex) {
		ErrorMessage error = new ErrorMessage(400, ex.getMessage(),
				"This is a description for InvalidParameterException.");
		return Response.status(Status.BAD_REQUEST).entity(error).build();
	}

}
