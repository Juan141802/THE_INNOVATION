package com.TheInnovatonProyect.appTheInnov.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.TheInnovatonProyect.appTheInnov.modelo.CategoriaVehiculo;
import com.TheInnovatonProyect.appTheInnov.repository.CategoriaVehiculoRepository;

@Controller
public class CategoriaVehiculoController {
	
	@Autowired
	private CategoriaVehiculoRepository repository;
	
	@GetMapping("/categoriavehiculo")
	public String listarCategoriasV(Model modelo) {
		List<CategoriaVehiculo> listaCategorias = repository.findAll();
		modelo.addAttribute("listaCategorias", listaCategorias);
		return "categoriavehiculo";
	}
	
	@GetMapping("/categoriavehiculo/nuevo")
	public String crearCategoriaV(Model modelo) {
		modelo.addAttribute("categoriavehiculo", new CategoriaVehiculo());
		return "crear_categoriavehiculo";
	}
	
	@PostMapping("/categoriavehiculo/guardar")
	public String guardarCategoriaV(CategoriaVehiculo categoriavehiculo) {
		repository.save(categoriavehiculo);
		return "redirect:/categoriavehiculo";
	}
	
	@GetMapping("/categoriavehiculo/editar/{catv}")
	public String editCategoriaV(@PathVariable("id_catv") Long id_catv, Model modelo) {
		CategoriaVehiculo categoriavehiculo = repository.findById(id_catv).get();
		modelo.addAttribute("categoriavehiculo", categoriavehiculo);
		return "editar_categoriavehiculo";
	}

}
