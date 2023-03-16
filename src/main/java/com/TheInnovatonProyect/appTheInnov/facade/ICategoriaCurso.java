package com.TheInnovatonProyect.appTheInnov.facade;

import java.util.List;

import com.TheInnovatonProyect.appTheInnov.modelo.CategoriaCurso;

public interface ICategoriaCurso {
	
	public List<CategoriaCurso> listarCategoria();
	
	public CategoriaCurso guardarCategoria(CategoriaCurso categoriacurso);
	
	public CategoriaCurso obtenerCategoriaporId(Long id_cat);
	
	public CategoriaCurso actualizarCategoria(CategoriaCurso categoriacurso);
	
	public void eliminarCategoria(Long id_cat);

}
