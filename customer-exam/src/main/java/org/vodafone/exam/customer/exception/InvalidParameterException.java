package org.vodafone.exam.customer.exception;

/**
 * This is an exeption class wich extends RuntimeException and is used when the
 * the parameters send by client are invalid.
 *
 * @author Adeleh
 * @version 0.1 Build July 26, 2015.
 */
public class InvalidParameterException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1032466468451259709L;

	/**
	 * constructor
	 *
	 * @param String
	 *            massage
	 **/
	public InvalidParameterException(String message) {
		super(message);
	}

}
