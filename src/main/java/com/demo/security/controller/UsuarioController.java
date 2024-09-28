package com.demo.security.controller;

import com.demo.security.exception.BusinessException;

public interface UsuarioController {

	Object getUsuarios() throws BusinessException;
	
}
