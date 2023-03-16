package com.TheInnovatonProyect.appTheInnov.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Asistencia")
public class Asistencia {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_asistencia;
	
	@Column(name="Asistencia", length= 30)
	private String Asistencia;

	public Long getId_asistencia() {
		return id_asistencia;
	}

	public void setId_asistencia(Long id_asistencia) {
		this.id_asistencia = id_asistencia;
	}

	public String getAsistencia() {
		return Asistencia;
	}

	public void setAsistencia(String asistencia) {
		Asistencia = asistencia;
	}

	public Asistencia() {
		super();
	}

	public Asistencia(Long id_asistencia, String asistencia) {
		super();
		this.id_asistencia = id_asistencia;
		Asistencia = asistencia;
	}
	public Asistencia(Long id_asistencia) {
		super();
		this.id_asistencia = id_asistencia;
		
	}
	public Asistencia( String asistencia) {
		super();
		this.Asistencia = asistencia;;
		
	}
}
