package com.TheInnovatonProyect.appTheInnov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.TheInnovatonProyect.appTheInnov.facadeImpl.Sededao;
import com.TheInnovatonProyect.appTheInnov.modelo.Sede;


@Controller
public class SedeController {
	
	@Autowired
	private Sededao sededao;
	
	@GetMapping("/sede")
	public String listarSede(Model modelo) {
		modelo.addAttribute("sede", sededao.listarSede());
		return "sede";
	}
	
	@GetMapping("/sede/nuevo")
	public String crearSede(Model modelo) {
		Sede sede = new Sede();
		modelo.addAttribute("sede", sede);
		return "crear_sede";
	}
	
	@PostMapping("/sede")
	public String guardarSede(@ModelAttribute("sede") Sede sede) {
		sededao.guardarSede(sede);
		return "redirect:/sede";
	}
	
	@GetMapping("/sede/editar/{id_sede}")
	public String editarSede(@PathVariable Long id_sede, Model modelo) {
		modelo.addAttribute("sede", sededao.obtenerSedeporId(id_sede));
		return "editar_sede";
	}
	
	@PostMapping("/sede/{id_sede}")
	public String actualizarSede(@PathVariable Long id_sede,@ModelAttribute("sede") Sede sede, Model modelo) {
		
		Sede sedeExistente = sededao.obtenerSedeporId(id_sede);
		sedeExistente.setId_sede(id_sede);
		sedeExistente.setBar(sede.getBar());
		
		sededao.actualizarSede(sedeExistente);
		
		return "redirect:/sede";
	}
	
	@GetMapping("sede/{id_sede}")
	public String eliminarSede(@PathVariable Long id_sede) {
		sededao.eliminarSede(id_sede);
		return "redirect:/sede";
	}
	
	

}
