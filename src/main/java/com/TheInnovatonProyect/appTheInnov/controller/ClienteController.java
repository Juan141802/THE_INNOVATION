package com.TheInnovatonProyect.appTheInnov.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.TheInnovatonProyect.appTheInnov.modelo.Asistencia;

import com.TheInnovatonProyect.appTheInnov.modelo.Cliente;

import com.TheInnovatonProyect.appTheInnov.repository.AsistenciaRepository;
import com.TheInnovatonProyect.appTheInnov.repository.ClienteRepository;

@Controller
public class ClienteController {

	@Autowired
	private ClienteRepository clienterepository;
	
	@Autowired
	private AsistenciaRepository asisRepository;

	@GetMapping("/cliente")
	public String listaCliente(Model modelo) {
		List<Cliente> listaCliente = clienterepository.findAll();
		modelo.addAttribute("listaCliente", listaCliente);
		return "clientes";
	}
	
	@GetMapping("/cliente/nuevo")
	public String crearVehiculo(Model modelo) {
		List<Asistencia> listarAsistencia = asisRepository.findAll();
		
		modelo.addAttribute("cliente", new Cliente());
		modelo.addAttribute("listarAsistencia", listarAsistencia);
		return "crear_clientes";
	}
	@PostMapping("/cliente/guardar")
	public String guardarCliente(Cliente cliente) {
		clienterepository.save(cliente);
		return "redirect:/cliente";
	}
	
	@GetMapping("/cliente/editar/{id_cliente}")
	public String editarcliente(@PathVariable("id_cliente") Long id_cliente, Model modelo) {
		Cliente cliente =clienterepository.findById(id_cliente).get();
		modelo.addAttribute("cliente", cliente);		
		
        List<Asistencia> listarAsistencia =asisRepository.findAll();	
		modelo.addAttribute("listarAsistencia",listarAsistencia);
		
		return "editar_cliente";
	}
	@GetMapping("/cliente/eliminar/{id_cliente}")
	public String eliminarcliente(@PathVariable("id_cliente") Long id_cliente, Model modelo) {
		clienterepository.deleteById(id_cliente);
		return "redirect:/cliente";
	}
	
}
