package com.demo.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.security.entity.UsuarioEntity;
import com.demo.security.enums.EnumHttpStatus;
import com.demo.security.exception.BusinessException;
import com.demo.security.model.RespuestaGral;
import com.demo.security.model.UsuarioModel;
import com.demo.security.repository.UsuarioRepository;
import com.demo.security.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository userRepo;
	
	@Override
	public RespuestaGral getAllUsuarios() throws BusinessException {
		try {
			List<UsuarioEntity> usuarios = userRepo.findAll();
			
			if(usuarios.isEmpty()) {
				return new RespuestaGral(true, null);
			}
			
			List<UsuarioModel> userList = usuarios.stream()
				.map(
						user -> { 
							return new UsuarioModel(user);
							})
				.toList();
			return new RespuestaGral(true, userList);	
		} catch (Exception e) {
			throw new BusinessException(EnumHttpStatus.CLIENT_ERROR_BAD_REQUEST, "Rol no existente", e.getMessage());
		}
	}
		
}