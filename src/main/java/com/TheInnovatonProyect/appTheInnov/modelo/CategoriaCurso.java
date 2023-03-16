package com.TheInnovatonProyect.appTheInnov.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CategoriaCurso")
public class CategoriaCurso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cat;
	
	@Column(name="Nombre", length= 30)
	private String nom;
	
	@Column(name="Valor", length= 30)
	private String val;

	public CategoriaCurso() {

	}

	public CategoriaCurso(Long id_cat, String nom, String val) {
		super();
		this.id_cat = id_cat;
		this.nom = nom;
		this.val = val;
	}

	public Long getId_cat() {
		return id_cat;
	}

	public void setId_cat(Long id_cat) {
		this.id_cat = id_cat;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return "CategoriaCurso [id_cat=" + id_cat + ", nom=" + nom + ", val=" + val + "]";
	}
		
}
