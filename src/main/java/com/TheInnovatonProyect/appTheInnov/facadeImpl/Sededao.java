package com.TheInnovatonProyect.appTheInnov.facadeImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TheInnovatonProyect.appTheInnov.facade.ISede;
import com.TheInnovatonProyect.appTheInnov.modelo.Sede;
import com.TheInnovatonProyect.appTheInnov.repository.SedeRepository;

@Service
public class Sededao implements ISede{
	
	@Autowired
	private SedeRepository repository;

	@Override
	public List<Sede> listarSede() {
		return repository.findAll();
	}

	@Override
	public Sede guardarSede(Sede sede) {
		return repository.save(sede);
	}

	@Override
	public Sede obtenerSedeporId(Long id_sede) {
		return repository.findById(id_sede).get();
	}

	@Override
	public Sede actualizarSede(Sede sede) {
		return repository.save(sede);
	}

	@Override
	public void eliminarSede(Long id_sede) {
		repository.deleteById(id_sede);
		
	}

}
