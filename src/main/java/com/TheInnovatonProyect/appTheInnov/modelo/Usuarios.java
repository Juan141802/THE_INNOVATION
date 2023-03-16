package com.TheInnovatonProyect.appTheInnov.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Usuarios")
public class Usuarios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usu;
	
	@Column(name="Nombre", length= 30)
	private String nom;
	
	@Column(name="Apellido", length= 30)
	private String ape;
	
	@Column(name="Correo", length= 30)
	private String corr;
	
	@Column(name="Telefono", length= 30)
	private int tel;
	
	@Column(name="Direccion", length= 30)
	private String dir;
	
	@Column(name="Contraseña", length= 30)
	private String con;

	public Usuarios() {
	
	}

	public Usuarios(Long id_usu, String nom, String ape, String corr, int tel, String dir, String con) {
		super();
		this.id_usu = id_usu;
		this.nom = nom;
		this.ape = ape;
		this.corr = corr;
		this.tel = tel;
		this.dir = dir;
		this.con = con;
	}

	@Override
	public String toString() {
		return "Usuarios [id_usu=" + id_usu + ", nom=" + nom + ", ape=" + ape + ", corr=" + corr + ", tel=" + tel
				+ ", dir=" + dir + ", con=" + con + "]";
	}

	public Long getId_usu() {
		return id_usu;
	}

	public void setId_usu(Long id_usu) {
		this.id_usu = id_usu;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getApe() {
		return ape;
	}

	public void setApe(String ape) {
		this.ape = ape;
	}

	public String getCorr() {
		return corr;
	}

	public void setCorr(String corr) {
		this.corr = corr;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getCon() {
		return con;
	}

	public void setCon(String con) {
		this.con = con;
	}
	
	
	

}
