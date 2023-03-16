package com.TheInnovatonProyect.appTheInnov.facadeImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TheInnovatonProyect.appTheInnov.facade.IUsuario;
import com.TheInnovatonProyect.appTheInnov.modelo.Usuarios;
import com.TheInnovatonProyect.appTheInnov.repository.UsuarioRepository;

@Service
public class Usuariodao implements IUsuario{
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public List<Usuarios> listarUsuarios() {
		return repository.findAll();
	}

	@Override
	public Usuarios guardarUsuario(Usuarios usuarios) {
		return repository.save(usuarios);
	}

	@Override
	public Usuarios obtenerUsuarioporId(Long id_usu) {
		return repository.findById(id_usu).get();
	}

	@Override
	public Usuarios actualizarUsuario(Usuarios usuarios) {
		return repository.save(usuarios);
	}

	@Override
	public void eliminarUsuario(Long id_usu) {
		repository.deleteById(id_usu);
		
	}

}
