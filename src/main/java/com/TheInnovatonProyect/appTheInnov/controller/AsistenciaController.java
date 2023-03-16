package com.TheInnovatonProyect.appTheInnov.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.TheInnovatonProyect.appTheInnov.modelo.Asistencia;
import com.TheInnovatonProyect.appTheInnov.repository.AsistenciaRepository;

@Controller
public class AsistenciaController {

	@Autowired
	private AsistenciaRepository asistenciaRepository;
	
	@GetMapping("/asistencia")
	public String listarAsistencia(Model modelo) {
		List<Asistencia> listarAsistencia = asistenciaRepository.findAll();
		modelo.addAttribute("listarAsistencia", listarAsistencia);
		return "asistencia";
	}
	
	@GetMapping("/asistencia/nuevo")
	public String crearAsistencia(Model modelo) {
		modelo.addAttribute("asistencia", new Asistencia());
		return "crear_asistencia";
	}
	
	@PostMapping("/asistencia/guardar")
	public String guardarAsistencia(Asistencia asistencia) {
		asistenciaRepository.save(asistencia);
		return "redirect:/asistencia";
}
	
}
