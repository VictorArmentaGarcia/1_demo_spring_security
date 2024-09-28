package com.demo.security.model;

import java.io.Serializable;

import com.demo.security.entity.UsuarioEntity;

import lombok.Data;

@Data
public class UsuarioModel implements Serializable {

	private static final long serialVersionUID = -2786957971923001160L;

	public UsuarioModel(UsuarioEntity user) {
		this.setId(user.getId());
		this.setNombre(user.getNombre());
	}
	
	private int id;
	
	private String nombre;
	
}
