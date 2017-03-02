/**
 * @date:2017年2月27日
 * @author:d1m
 */
package org.mvc.exception;

/**
 * @author d1m
 *
 */
public class InvaildPropertiesException extends Exception {

	private static final long serialVersionUID = -6223610642642824605L;
    
	private String message;
	
	public InvaildPropertiesException(String message) {
		super(message);
	}

	public String getMessage() {
		return super.getMessage();
	}

}
