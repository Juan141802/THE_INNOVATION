package com.TheInnovatonProyect.appTheInnov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.TheInnovatonProyect.appTheInnov.facadeImpl.VentaServiciodao;
import com.TheInnovatonProyect.appTheInnov.modelo.VentaServicios;

@Controller
public class VentaServicioController {
	
	@Autowired
	private VentaServiciodao ventasdao;
	
	@GetMapping("/ventaservicio")
	public String listarVentaServicio(Model modelo) {
		modelo.addAttribute("ventaservicio", ventasdao.listarVentaServicios());
		return "ventaservicio";
	}

	@GetMapping("/ventaservicio/nuevo")
	public String crearVentaServicio(Model modelo) {
		VentaServicios ventaservicios = new VentaServicios();
		modelo.addAttribute("ventaservicio", ventaservicios);
		return "crear_ventaservicio";
	}
	
	@PostMapping("ventaservicio")
	public String guardarVentaServicio(@ModelAttribute("ventaservicio") VentaServicios ventaservicios ) {
		ventasdao.guardarVentaServicios(ventaservicios);
		return "redirect:/ventaservicio";
	}
	
	@GetMapping("/ventaservicio/editar/{id_vser}")
	public String editarVentaServicio(@PathVariable Long id_vser, Model modelo) {
		modelo.addAttribute("ventaservicio", ventasdao.obtenerVentaSporId(id_vser));
		return "editar_ventaservicio";
	}
	
	@PostMapping("/ventaservicio/{id_vser}")
	public String actualizarVentaServicio(@PathVariable Long id_vser,@ModelAttribute("ventaservicio") VentaServicios ventaservicios, Model modelo) {
		
		VentaServicios ventasExistente = ventasdao.obtenerVentaSporId(id_vser);
		ventasExistente.setId_vser(id_vser);
		ventasExistente.setNom(ventaservicios.getNom());
		ventasExistente.setInfo(ventaservicios.getInfo());
		ventasExistente.setVal(ventaservicios.getVal());
		
		ventasdao.actualizarVentaServicio(ventaservicios);
		
		return "redirect:/ventaservicio";
	}
	
	@GetMapping("/ventaservicio/{id_vser}")
	public String eliminarVentaServicio(@PathVariable Long id_vser) {
		ventasdao.eliminarVentaServicio(id_vser);
		return "redirect:/ventaservicio";
	}
}
