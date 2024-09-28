package com.demo.security.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.security.controller.UsuarioController;
import com.demo.security.enums.EnumHttpStatus;
import com.demo.security.exception.BusinessException;
import com.demo.security.service.UsuarioService;

@RestController(value = "usuario")
public class UsuarioControllerImpl implements UsuarioController {

	private static Logger logger = LoggerFactory.getLogger(UsuarioControllerImpl.class);
	private UsuarioService userService;
	
	@GetMapping("/health/ready")
	@ResponseStatus(HttpStatus.OK)
	public void ready() {
	}

	@GetMapping("/health/live")
	@ResponseStatus(HttpStatus.OK)
	public void live() {
		// Service to validate if the server is alive
	}
	
	public UsuarioControllerImpl(UsuarioService usuarioService) {
		this.userService = usuarioService;
	}
	
	@Override
	@GetMapping("/all")
	public Object getUsuarios() throws BusinessException {
		try {
			logger.info("peticion realizada","ok");
			return this.userService.getAllUsuarios();
		} catch (Exception e) {
			throw new BusinessException(EnumHttpStatus.CLIENT_ERROR_BAD_REQUEST, 
					"Inconveniente al conultar informacion", e.getMessage()); 
		}
	}

	private void logs() {
	    logger.info("This is sample info message");
	    logger.warn("This is sample warn message");
	    logger.error("This is sample error message");
	    logger.debug("This is sample debug message");
	}
	
}
