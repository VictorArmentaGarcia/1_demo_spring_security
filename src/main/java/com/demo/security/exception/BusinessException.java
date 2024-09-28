package com.demo.security.exception;

import com.demo.security.enums.EnumHttpStatus;
import com.demo.security.model.ErrorResponse;

import lombok.Data;

@Data
public class BusinessException extends Exception {

	private ErrorResponse errorResponse;
	
	public BusinessException(EnumHttpStatus status, String businessMessage, String exception) {
		super(businessMessage);
		errorResponse = new ErrorResponse(status, businessMessage, exception);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3994169212572730399L;

}
