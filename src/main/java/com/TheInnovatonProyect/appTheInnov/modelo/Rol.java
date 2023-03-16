package com.TheInnovatonProyect.appTheInnov.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name = "Rol")
public class Rol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	@ManyToMany(mappedBy = "roles")
	private List<UsuariosSesion> usuario = new ArrayList<UsuariosSesion>();


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Rol(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Rol() {
		super();
	}

	public Rol(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre;
	}

}
