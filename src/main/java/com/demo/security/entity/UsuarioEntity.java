package com.demo.security.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name =  "usuario")
@Entity
public class UsuarioEntity {

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
}
