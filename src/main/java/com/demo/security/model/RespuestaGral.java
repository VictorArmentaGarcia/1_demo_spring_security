package com.demo.security.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RespuestaGral implements Serializable {

	private static final long serialVersionUID = -5128839417451516143L;

	private boolean exitoso;
	
	private Object respuesta;
	
}
