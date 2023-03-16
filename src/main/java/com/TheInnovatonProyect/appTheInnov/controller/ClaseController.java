package com.TheInnovatonProyect.appTheInnov.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.TheInnovatonProyect.appTheInnov.modelo.Clase;
import com.TheInnovatonProyect.appTheInnov.modelo.ProgramacionCurso;
import com.TheInnovatonProyect.appTheInnov.repository.ClaseRepository;
import com.TheInnovatonProyect.appTheInnov.repository.ProgramacionCursoRepository;

@Controller
public class ClaseController {
	
	@Autowired
	private ClaseRepository crepository;
	
	@Autowired
	private ProgramacionCursoRepository prepository;
	
	@GetMapping("/clases")
	public String listarClases(Model modelo) {
		List<Clase> listaClase = crepository.findAll();
		List<ProgramacionCurso> listaProgramacion = prepository.findAll();
		modelo.addAttribute("listaProgramacion", listaProgramacion);
		modelo.addAttribute("listaClase", listaClase);
		return "clases";
	}
	
	@GetMapping("/clases/nuevo")
	public String crearClase(Model modelo) {
		List<ProgramacionCurso> listaProgramacion = prepository.findAll();
		modelo.addAttribute("clase", new Clase());
		modelo.addAttribute("listaProgramacion", listaProgramacion);
		return "crear_clase";
	}
	
	@PostMapping("/clases/guardar")
	public String guardarClase(Clase clase) {
		crepository.save(clase);
		return "redirect:/clases";
	}
	
	@GetMapping("clases/editar/{id_clase}")
	public String editarClase(@PathVariable("id_clase") Long id_clase, Model modelo) {
		Clase clase = crepository.findById(id_clase).get();
		modelo.addAttribute("clase", clase);
		
		List<ProgramacionCurso> listaProgramacion = prepository.findAll();
		modelo.addAttribute("listaProgramacion", listaProgramacion);
		
		return "editar_clase";
	}
	
	@GetMapping("clases/eliminar/{id_clase}")
	public String eliminarClase(@PathVariable("id_clase") Long id_clase, Model modelo) {
	    crepository.deleteById(id_clase);
	    return "redirect:/clases";
	}

}
