package com.TheInnovatonProyect.appTheInnov.facadeImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TheInnovatonProyect.appTheInnov.facade.IVentaServicio;
import com.TheInnovatonProyect.appTheInnov.modelo.VentaServicios;
import com.TheInnovatonProyect.appTheInnov.repository.VentaServicioRepository;

@Service
public class VentaServiciodao implements IVentaServicio{
	
	@Autowired
	private VentaServicioRepository repository;

	@Override
	public List<VentaServicios> listarVentaServicios() {
		return repository.findAll();
	}

	@Override
	public VentaServicios guardarVentaServicios(VentaServicios ventaservicios) {
		return repository.save(ventaservicios);
	}

	@Override
	public VentaServicios obtenerVentaSporId(Long id_vser) {
		return repository.findById(id_vser).get();
	}

	@Override
	public VentaServicios actualizarVentaServicio(VentaServicios ventaservicios) {
		return repository.save(ventaservicios);
	}

	@Override
	public void eliminarVentaServicio(Long id_vser) {
		repository.deleteById(id_vser);
		
	}
	

}
