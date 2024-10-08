package com.demo.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.security.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

	Optional<Users> findByName(String name);
	
}
