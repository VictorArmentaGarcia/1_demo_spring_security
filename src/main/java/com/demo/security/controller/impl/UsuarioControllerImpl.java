package com.demo.security.controller.impl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.security.controller.UsuarioController;
import com.demo.security.exception.BusinessException;
import com.demo.security.model.RespuestaGral;
import com.demo.security.service.UsuarioService;

@RestController(value = "usuario")
public class UsuarioControllerImpl implements UsuarioController {

	private UsuarioService userService;
	
	public UsuarioControllerImpl(UsuarioService usuarioService) {
		this.userService = usuarioService;
	}
	
	@Override
	@GetMapping("/all")
	public Object getUsuarios() throws BusinessException {
		return this.userService.getAllUsuarios();
	}

}
