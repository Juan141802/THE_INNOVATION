package com.TheInnovatonProyect.appTheInnov.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VentaServicios")
public class VentaServicios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_vser;
	
	@Column(name="Nombre", length= 30)
	private String nom;
	
	@Column(name="Informacion", length= 100)
	private String info;
	
	@Column(name="Valor", length= 30)
	private int val;

	public VentaServicios() {

	}

	public VentaServicios(Long id_vser, String nom, String info, int val) {
		super();
		this.id_vser = id_vser;
		this.nom = nom;
		this.info = info;
		this.val = val;
	}

	@Override
	public String toString() {
		return "VentaServicios [id_vser=" + id_vser + ", nom=" + nom + ", info=" + info + ", val=" + val + "]";
	}

	public Long getId_vser() {
		return id_vser;
	}

	public void setId_vser(Long id_vser) {
		this.id_vser = id_vser;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

}
