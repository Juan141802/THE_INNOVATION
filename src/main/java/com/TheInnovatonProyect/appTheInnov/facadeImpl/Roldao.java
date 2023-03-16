package com.TheInnovatonProyect.appTheInnov.facadeImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TheInnovatonProyect.appTheInnov.facade.IRol;
import com.TheInnovatonProyect.appTheInnov.modelo.Rol;
import com.TheInnovatonProyect.appTheInnov.repository.RolRepository;
@Service
public class Roldao implements IRol{

	@Autowired
	private RolRepository rolRepository;
	
	@Override
	public List<Rol> encontrarTodo() {
		return this.rolRepository.findAll();
	}

	@Override
	public Rol encontrarId(Long id) {
		return this.rolRepository.getReferenceById(id);
	}

	@Override
	public void crear(Rol rol) {
		this.rolRepository.save(rol);
	}

	@Override
	public void actualizar(Rol rol) {
		this.rolRepository.save(rol);
	}

	

	@Override
	public void eliminar(Long id) {
		rolRepository.deleteById(id);
		
	}

	@Override
	public void actualizarEstado(Rol rol) {
		this.rolRepository.save(rol);
	}

	
}
