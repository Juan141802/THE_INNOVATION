package com.TheInnovatonProyect.appTheInnov.facade;

import java.util.List;

import com.TheInnovatonProyect.appTheInnov.modelo.Rol;



public interface IRol {

	public List<Rol> encontrarTodo();

	public Rol encontrarId(Long id);
	public void crear(Rol rol);
	public void actualizar(Rol rol);
	public void eliminar(Long id);
	public void actualizarEstado(Rol rol);
	
}
