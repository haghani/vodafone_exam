package org.vodafone.exam.customer.model;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * Error message class definition.
 *
 * @author Adeleh
 * @version 0.1 Build July 26, 2015.
 */

@XmlRootElement
public class ErrorMessage {
	public ErrorMessage() {
	}

	public ErrorMessage(int errorCode, String errorText, String errorDesc) {
		super();
		this.errorCode = errorCode;
		this.errorText = errorText;
		this.errorDesc = errorDesc;
	}

	private int errorCode;

	private String errorText;

	private String errorDesc;

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorText() {
		return errorText;
	}

	public void setErrorText(String errorText) {
		this.errorText = errorText;
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
}
