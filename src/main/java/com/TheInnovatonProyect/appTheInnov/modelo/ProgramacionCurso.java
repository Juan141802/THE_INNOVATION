package com.TheInnovatonProyect.appTheInnov.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ProgramacionCurso")
public class ProgramacionCurso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_prog;
	
	@Column(name = "FechaHora")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechor;

	public Long getId_prog() {
		return id_prog;
	}

	public void setId_prog(Long id_prog) {
		this.id_prog = id_prog;
	}

	public Date getFechor() {
		return fechor;
	}

	public void setFechor(Date fechor) {
		this.fechor = fechor;
	}

	public ProgramacionCurso() {
		super();
	}

	public ProgramacionCurso(Long id_prog, Date fechor) {
		super();
		this.id_prog = id_prog;
		this.fechor = fechor;
	}

	public ProgramacionCurso(Long id_prog) {
		super();
		this.id_prog = id_prog;
	}

	public ProgramacionCurso(Date fechor) {
		super();
		this.fechor = fechor;
	}
	
	

}
