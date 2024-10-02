package com.demo.security.service.impl;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Component;

import com.demo.security.entity.Rol;
import com.demo.security.entity.Users;
import com.demo.security.enums.EnumRol;
import com.demo.security.repository.RolRepository;
import com.demo.security.repository.UsersRepository;

@Component
public class RunnerImpl implements CommandLineRunner {

    private final UsersRepository userRepo;
    private final RolRepository rolRepo;

    public RunnerImpl(UsersRepository userRepository, RolRepository rolRepository) {
        this.userRepo = userRepository;
        this.rolRepo = rolRepository;
    }

	
	@Override
	public void run(String... args) throws Exception {

        if (this.rolRepo.count() == 0) {
            this.rolRepo.saveAll(List.of(
                    new Rol(EnumRol.admin),
                    new Rol(EnumRol.escritura),
                    new Rol(EnumRol.lectura)
            ));
        }

        if (this.userRepo.count() == 0) {
            var encoders = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            this.userRepo.saveAll(List.of(
                            new Users("uncledave", encoders.encode("UncleDave123"), List.of(this.rolRepo.findByNombre(EnumRol.admin).get())),
                            new Users("user01", "User01123", List.of(this.rolRepo.findByNombre(EnumRol.lectura).get())),
                            new Users("user02", "User02123", List.of(this.rolRepo.findByNombre(EnumRol.escritura).get()))
                    )
            );
        }
	}

}
