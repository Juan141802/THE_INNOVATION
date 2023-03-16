package com.TheInnovatonProyect.appTheInnov.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.TheInnovatonProyect.appTheInnov.modelo.Servicio;
import com.TheInnovatonProyect.appTheInnov.modelo.VentaServicios;
import com.TheInnovatonProyect.appTheInnov.repository.ServicioRepository;
import com.TheInnovatonProyect.appTheInnov.repository.VentaServicioRepository;

@Controller
public class ServicioController {
	
	@Autowired
	private ServicioRepository srepository;
	
	@Autowired
	private VentaServicioRepository vsrepository;
	
	@GetMapping("/servicios")
	public String listarServicios(Model modelo) {
		List<Servicio> listaServicio = srepository.findAll();
		List<VentaServicios> listaVentas = vsrepository.findAll();
		modelo.addAttribute("listaVentas", listaVentas);
		modelo.addAttribute("listaServicio", listaServicio);
		return "servicios";
	}
	
	@GetMapping("servicios/nuevo")
	public String crearServicio(Model modelo) {
		List<VentaServicios> listaVentas = vsrepository.findAll();
		modelo.addAttribute("servicio", new Servicio());
		modelo.addAttribute("listaVentas", listaVentas);
		return "crear_servicio";
	}
	
	@PostMapping("/servicios/guardar")
	public String guardarServicio(Servicio servicio) {
		srepository.save(servicio);
		return "redirect:/servicios";
	}
	
	@GetMapping("/servicios/editar/{id_serv}")
	public String editarServicio(@PathVariable("id_serv") Long id_serv, Model modelo) {
		Servicio servicio = srepository.findById(id_serv).get();
		modelo.addAttribute("servicio", servicio);
		
		List<VentaServicios> listaVentas = vsrepository.findAll();
		modelo.addAttribute("listaVentas", listaVentas);
		
		return "editar_servicio";
	}
	
	@GetMapping("/servicios/eliminar/{id_serv}")
    public String eliminarServicio(@PathVariable("id_serv") Long id_serv, Model modelo) {
    	srepository.deleteById(id_serv);
    	return "redirect:/servicios";
    }

}
