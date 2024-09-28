package com.demo.security;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.security.entity.UsuarioEntity;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Integer> {

	
}
