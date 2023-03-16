package com.TheInnovatonProyect.appTheInnov.modelo;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "UsuariosSesion", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class UsuariosSesion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	private String email;

	private String password;
	
	//1. Se indica en una relación muchos a muchos
	//2. Se crea una tabla intermedia llamada "Usuarios_Roles"
	//3. Se crea una columna "usuario_id" y se une con la columna referenciada "id" de la tabla "UsuariosSesion"
	//4. La columna inversa "rol_id" irá a la otra tabla de "Rol"
	
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
    		name = "usuarios_roles",
    		joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
    		inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id")
    		)
	private Collection<Rol> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Rol> roles) {
		this.roles = roles;
	}

	public UsuariosSesion(Long id, String nombre, String apellido, String email, String password,
			Collection<Rol> roles) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public UsuariosSesion(String nombre, String apellido, String email, String password, Collection<Rol> roles) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public UsuariosSesion() {
		super();
	}

}
