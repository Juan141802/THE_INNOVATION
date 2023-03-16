package com.TheInnovatonProyect.appTheInnov.facade;

import java.util.List;

import com.TheInnovatonProyect.appTheInnov.modelo.VentaServicios;

public interface IVentaServicio {
	
	public List<VentaServicios> listarVentaServicios();
	
	public VentaServicios guardarVentaServicios(VentaServicios ventaservicios);
	
	public VentaServicios obtenerVentaSporId(Long id_vser);
	
	public VentaServicios actualizarVentaServicio(VentaServicios ventaservicios);
	
	public void eliminarVentaServicio(Long id_vser);

}
