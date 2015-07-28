package org.vodafone.exam.customer.bean;

import javax.ws.rs.QueryParam;

/**
 * This is a ParamBean of getCustomers method and contains filters parameters
 * that come from client.
 *
 * @author Adeleh
 * @version 0.1 Build July 26, 2015.
 */

public class CustomerParameterBean {

	private @QueryParam("name") String name;

	private @QueryParam("offset") int offset;

	private @QueryParam("limit") int limit;

	/**
	 * 
	 * @return name as String which is used for filtering based on customer Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 *            as String which is used for filtering based on customer Name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return offset as int which is used in pagination
	 */
	public int getOffset() {
		return offset;
	}

	/**
	 * 
	 * @param offset
	 *            as int which is used in pagination
	 */
	public void setOffset(int offset) {
		this.offset = offset;
	}

	/**
	 * 
	 * @return limit as int which is used pagination
	 */

	public int getLimit() {
		return limit;
	}

	/**
	 * 
	 * @param limit
	 *            as int which is used pagination
	 */

	public void setLimit(int limit) {
		this.limit = limit;
	}
}
