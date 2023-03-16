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
@Table(name = "Vehiculo")
public class Vehiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_vehi;
	
	@Column(name="Marca", length= 30)
	private String mar;
	
	@Column(name="Modelo", length= 30)
	private String mod;
	
	@ManyToOne
	@JoinColumn(name = "categoriavehiculo_id")
	private CategoriaVehiculo categoriavehiculo;

	public Long getId_vehi() {
		return id_vehi;
	}

	public void setId_vehi(Long id_vehi) {
		this.id_vehi = id_vehi;
	}

	public String getMar() {
		return mar;
	}

	public void setMar(String mar) {
		this.mar = mar;
	}

	public String getMod() {
		return mod;
	}

	public void setMod(String mod) {
		this.mod = mod;
	}

	public CategoriaVehiculo getCategoriavehiculo() {
		return categoriavehiculo;
	}

	public void setCategoriavehiculo(CategoriaVehiculo categoriavehiculo) {
		this.categoriavehiculo = categoriavehiculo;
	}

	public Vehiculo() {
		super();
	}

	public Vehiculo(Long id_vehi, String mar, String mod, CategoriaVehiculo categoriavehiculo) {
		super();
		this.id_vehi = id_vehi;
		this.mar = mar;
		this.mod = mod;
		this.categoriavehiculo = categoriavehiculo;
	}

	public Vehiculo(String mar, String mod, CategoriaVehiculo categoriavehiculo) {
		super();
		this.mar = mar;
		this.mod = mod;
		this.categoriavehiculo = categoriavehiculo;
	}

	public Vehiculo(String mar) {
		super();
		this.mar = mar;
	}
	
	

}
