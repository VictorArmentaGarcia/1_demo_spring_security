package com.demo.security.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class Users {

	public Users(String name, String pass, List<Rol> listRolEntity) {
		super();
		this.setName(name);
		this.setPass(pass);
		this.setRol(listRolEntity);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private String pass;
	
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( name = "user_rol",
    		joinColumns = @JoinColumn(table = "users", referencedColumnName = "id"),
    		inverseJoinColumns = @JoinColumn(table = "rol", referencedColumnName = "id"))
    private List<Rol> rol;
}
