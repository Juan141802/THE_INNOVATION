package com.TheInnovatonProyect.appTheInnov.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.TheInnovatonProyect.appTheInnov.modelo.CategoriaVehiculo;
import com.TheInnovatonProyect.appTheInnov.modelo.Vehiculo;
import com.TheInnovatonProyect.appTheInnov.repository.CategoriaVehiculoRepository;
import com.TheInnovatonProyect.appTheInnov.repository.VehiculoRepository;

@Controller
public class VehiculoController {
	
	@Autowired
    private VehiculoRepository repository;
	
	@Autowired
	private CategoriaVehiculoRepository catvrepository;
	
	@GetMapping("/vehiculos")
	public String listarVehiculos(Model modelo) {
		List<Vehiculo> listaVehiculos = repository.findAll();
		modelo.addAttribute("listaVehiculos", listaVehiculos);
		return "vehiculos";
	}
	
	@GetMapping("/vehiculos/nuevo")
	public String crearVehiculo(Model modelo) {
		List<CategoriaVehiculo> listaCategorias = catvrepository.findAll();
		
		modelo.addAttribute("vehiculo", new Vehiculo());
		modelo.addAttribute("listaCategorias", listaCategorias);
		return "crear_vehiculo";
	}
	
	@PostMapping("/vehiculos/guardar")
	public String guardarVehiculo(Vehiculo vehiculo) {
		repository.save(vehiculo);
		return "redirect:/vehiculos";
	}
	
	@GetMapping("/vehiculos/editar/{id_vehi}")
	public String editarVehiculo(@PathVariable("id_vehi") Long id_vehi, Model modelo) {
		Vehiculo vehiculo = repository.findById(id_vehi).get();
		modelo.addAttribute("vehiculo", vehiculo);		
		
        List<CategoriaVehiculo> listaCategorias = catvrepository.findAll();	
		modelo.addAttribute("listaCategorias", listaCategorias);
		
		return "editar_vehiculo";
	}
	
	@GetMapping("/vehiculos/eliminar/{id_vehi}")
	public String eliminarVehiculo(@PathVariable("id_vehi") Long id_vehi, Model modelo) {
		repository.deleteById(id_vehi);
		return "redirect:/vehiculos";
	}
	
}
