package com.TheInnovatonProyect.appTheInnov.facadeImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TheInnovatonProyect.appTheInnov.facade.ICategoriaCurso;
import com.TheInnovatonProyect.appTheInnov.modelo.CategoriaCurso;
import com.TheInnovatonProyect.appTheInnov.repository.CategoriaCursoRepository;

@Service
public class CategoriaCursodao implements ICategoriaCurso{

	@Autowired
	private CategoriaCursoRepository repository;

	@Override
	public List<CategoriaCurso> listarCategoria() {
		return repository.findAll();
	}

	@Override
	public CategoriaCurso guardarCategoria(CategoriaCurso categoriacurso) {
		return repository.save(categoriacurso);
	}

	@Override
	public CategoriaCurso obtenerCategoriaporId(Long id_cat) {
		return repository.findById(id_cat).get();
	}

	@Override
	public CategoriaCurso actualizarCategoria(CategoriaCurso categoriacurso) {
		return repository.save(categoriacurso);
	}

	@Override
	public void eliminarCategoria(Long id_cat) {
		repository.deleteById(id_cat);
		
	}
	
	
}
