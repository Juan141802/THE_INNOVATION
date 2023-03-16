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
@Table(name = "Servicio")
public class Servicio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_serv;
	
	@Column(name = "Nombre")
	private String nom;
	
	@ManyToOne
	@JoinColumn(name = "ventaservicios_id")
	private VentaServicios ventaservicios;

	public Long getId_serv() {
		return id_serv;
	}

	public void setId_serv(Long id_serv) {
		this.id_serv = id_serv;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public VentaServicios getVentaservicios() {
		return ventaservicios;
	}

	public void setVentaservicios(VentaServicios ventaservicios) {
		this.ventaservicios = ventaservicios;
	}

	public Servicio() {
		super();
	}

	public Servicio(Long id_serv) {
		super();
		this.id_serv = id_serv;
	}

	public Servicio(String nom) {
		super();
		this.nom = nom;
	}
	
	

}
