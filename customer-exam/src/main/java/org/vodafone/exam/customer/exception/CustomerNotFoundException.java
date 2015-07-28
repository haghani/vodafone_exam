package org.vodafone.exam.customer.exception;

/**
 * This is an exeption class wich extends RuntimeException and is used when the
 * selected customer is null or customer list is emty.
 *
 * @author Adeleh
 * @version 0.1 Build July 26, 2015.
 */

public class CustomerNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1032466468451259709L;

	/**
	 * constructor
	 *
	 * @param String massage
	 **/

	public CustomerNotFoundException(String message) {
		super(message);
	}

}
