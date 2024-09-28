package com.demo.security.service;

import com.demo.security.exception.BusinessException;
import com.demo.security.model.RespuestaGral;

public interface UsuarioService {

	RespuestaGral getAllUsuarios() throws BusinessException;
	
}
