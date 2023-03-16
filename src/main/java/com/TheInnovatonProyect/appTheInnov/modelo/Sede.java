package com.TheInnovatonProyect.appTheInnov.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Sede")
public class Sede {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_sede;
	
	@Column(name="Barrio", length= 30)
	private String bar;

	public Sede() {

	}

	public Sede(Long id_sede, String bar) {
		super();
		this.id_sede = id_sede;
		this.bar = bar;
	}

	public Long getId_sede() {
		return id_sede;
	}

	public void setId_sede(Long id_sede) {
		this.id_sede = id_sede;
	}

	public String getBar() {
		return bar;
	}

	public void setBar(String bar) {
		this.bar = bar;
	}

	@Override
	public String toString() {
		return "Sede [id_sede=" + id_sede + ", bar=" + bar + "]";
	}
	
	

	
}
