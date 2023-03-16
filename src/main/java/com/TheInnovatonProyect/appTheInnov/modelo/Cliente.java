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
@Table(name = "Cliente")
public class Cliente {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cliente;
	
	@Column(name="Nombre", length= 30)
	private String Nombre;
	
	@Column(name="Apellido", length= 30)
	private String Apellido;
	
	@Column(name="Telefono", length= 30)
	private Long Telefono;
	
	@Column(name="Edad", length= 2)
	private int Edad;
	
@ManyToOne
@JoinColumn(name = "asistencia_id")
private Asistencia asistencia;

public Long getId_cliente() {
	return id_cliente;
}

public void setId_cliente(Long id_cliente) {
	this.id_cliente = id_cliente;
}

public String getNombre() {
	return Nombre;
}

public void setNombre(String nombre) {
	Nombre = nombre;
}

public String getApellido() {
	return Apellido;
}

public void setApellido(String apellido) {
	Apellido = apellido;
}

public Long getTelefono() {
	return Telefono;
}

public void setTelefono(Long telefono) {
	Telefono = telefono;
}

public int getEdad() {
	return Edad;
}

public void setEdad(int edad) {
	Edad = edad;
}

public Asistencia getAsistencia() {
	return asistencia;
}

public void setAsistencia(Asistencia asistencia) {
	this.asistencia = asistencia;
}



public Cliente(Long id_cliente, String nombre, String apellido, Long telefono, int edad, Asistencia asistencia) {
	super();
	this.id_cliente = id_cliente;
	Nombre = nombre;
	Apellido = apellido;
	Telefono = telefono;
	Edad = edad;
	this.asistencia = asistencia;
}

public Cliente() {
	super();
}

public Cliente(String nombre, String apellido, Long telefono, int edad, Asistencia asistencia) {
	super();
	Nombre = nombre;
	Apellido = apellido;
	Telefono = telefono;
	Edad = edad;
	this.asistencia = asistencia;
}

public Cliente(String nombre) {
	super();
	Nombre = nombre;
}

}
