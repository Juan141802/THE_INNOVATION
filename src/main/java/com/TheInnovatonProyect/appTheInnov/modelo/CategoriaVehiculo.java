package com.TheInnovatonProyect.appTheInnov.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CategoriaVehiculo")
public class CategoriaVehiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_catv;
	
	@Column(name="Cilindraje", length= 30)
	private String cil;

	public Long getId_catv() {
		return id_catv;
	}

	public void setId_catv(Long id_catv) {
		this.id_catv = id_catv;
	}

	public String getCil() {
		return cil;
	}

	public void setCil(String cil) {
		this.cil = cil;
	}

	public CategoriaVehiculo() {
		super();
	}

	public CategoriaVehiculo(Long id_catv, String cil) {
		super();
		this.id_catv = id_catv;
		this.cil = cil;
	}

	public CategoriaVehiculo(Long id_catv) {
		super();
		this.id_catv = id_catv;
	}

	public CategoriaVehiculo(String cil) {
		super();
		this.cil = cil;
	}
	
	

}
