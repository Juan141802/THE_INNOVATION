package com.TheInnovatonProyect.appTheInnov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.TheInnovatonProyect.appTheInnov.facadeImpl.CategoriaCursodao;
import com.TheInnovatonProyect.appTheInnov.modelo.CategoriaCurso;

@Controller
public class CategoriaCursoController {
	
	@Autowired
	private CategoriaCursodao categoriadao;
	
	@GetMapping("/categoriacurso")
	public String listarCategoria(Model modelo) {
		modelo.addAttribute("categoriacurso", categoriadao.listarCategoria());
		return "categoriacurso";
	}
	
	@GetMapping("/categoriacurso/nuevo")
	public String crearCategoria(Model modelo) {
		CategoriaCurso categoriacurso = new CategoriaCurso();
		modelo.addAttribute("categoriacurso", categoriacurso);
		return "crear_categoria";
	}
	
	@PostMapping("/categoriacurso")
	public String guardarCategoria(@ModelAttribute("categoriacurso") CategoriaCurso categoriacurso) {
		categoriadao.guardarCategoria(categoriacurso);
		return "redirect:/categoriacurso";
	}
	
	@GetMapping("/categoriacurso/editar/{id_cat}")
	public String editarCategoria(@PathVariable Long id_cat, Model modelo) {
		modelo.addAttribute("categoriacurso", categoriadao.obtenerCategoriaporId(id_cat));
		return "editar_categoria";
	}
	
	@PostMapping("/categoriacurso/{id_cat}")
	public String actualizarCategoria(@PathVariable Long id_cat,@ModelAttribute("categoriacurso") CategoriaCurso categoriacurso, Model modelo) {
		
		CategoriaCurso categoriaExistente = categoriadao.obtenerCategoriaporId(id_cat);
		categoriaExistente.setId_cat(id_cat);
		categoriaExistente.setNom(categoriacurso.getNom());
		categoriaExistente.setVal(categoriacurso.getVal());
		
		categoriadao.actualizarCategoria(categoriacurso);
		
		return "redirect:/categoriacurso";
	}
	
	@GetMapping("/categoriacurso/{id_cat}")
	public String eliminarCategoria(@PathVariable Long id_cat) {
		categoriadao.eliminarCategoria(id_cat);
		return "redirect:/categoriacurso";
	}

}
