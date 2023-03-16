package com.TheInnovatonProyect.appTheInnov.facade;

import java.util.List;

import com.TheInnovatonProyect.appTheInnov.modelo.Usuarios;

public interface IUsuario {
	
	public List<Usuarios> listarUsuarios();
	
	public Usuarios guardarUsuario(Usuarios usuarios);
	
	public Usuarios obtenerUsuarioporId(Long id_usu);
	
	public Usuarios actualizarUsuario(Usuarios usuarios);
	
	public void eliminarUsuario(Long id_usu);

}
