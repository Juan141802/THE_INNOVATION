package com.TheInnovatonProyect.appTheInnov.facade;

import java.util.List;

import com.TheInnovatonProyect.appTheInnov.modelo.Sede;

public interface ISede {
	
	public List<Sede> listarSede();
	
	public Sede guardarSede(Sede sede);
	
	public Sede obtenerSedeporId(Long id_sede);
	
	public Sede actualizarSede(Sede sede);
	
	public void eliminarSede(Long id_sede);

}
