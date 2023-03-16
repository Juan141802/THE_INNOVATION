package com.TheInnovatonProyect.appTheInnov.modelo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Clase")
public class Clase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_clase;
	
	@Column(name = "Nombre")
	private String nom;
	
	@ManyToOne
	@JoinColumn(name = "programacioncurso_id")
	private ProgramacionCurso programacioncurso;

	public Long getId_clase() {
		return id_clase;
	}

	public void setId_clase(Long id_clase) {
		this.id_clase = id_clase;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ProgramacionCurso getProgramacioncurso() {
		return programacioncurso;
	}

	public void setProgramacioncurso(ProgramacionCurso programacioncurso) {
		this.programacioncurso = programacioncurso;
	}

	public Clase() {
		super();
	}

	public Clase(Long id_clase) {
		super();
		this.id_clase = id_clase;
	}

	public Clase(String nom) {
		super();
		this.nom = nom;
	}

	
	
	

}
