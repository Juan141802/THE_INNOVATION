package com.TheInnovatonProyect.appTheInnov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TheInnovatonProyect.appTheInnov.dto.UsuarioSRegistroDTO;
import com.TheInnovatonProyect.appTheInnov.facade.IUsuariosSesion;
import com.TheInnovatonProyect.appTheInnov.facadeImpl.UsuariosSesiondao;
import com.TheInnovatonProyect.appTheInnov.modelo.UsuariosSesion;

@Controller
@RequestMapping("/registro")
public class UsuarioSesionController {
	
	@Autowired
	private UsuariosSesiondao iusuariosesion;
	
	
	
	@ModelAttribute("usuario")
	public UsuarioSRegistroDTO retornarNuevoUsuarioRegistroDTO() {
		return new UsuarioSRegistroDTO();
	}
	
	@GetMapping
	public String mostrarFormularioRegistro() {
		return "registro";
	}
	
	@PostMapping
	public String registrarCuentaUsuario(@ModelAttribute("usuario") UsuarioSRegistroDTO registroDTO) {
	    iusuariosesion.guardar(registroDTO);
	    return "redirect:/registro?exito";
	}
	@GetMapping("/usuario/editar/{id}")
	public String usuarioEdit(@PathVariable("id") Long id, Model modelo) {
		UsuariosSesion usuario = iusuariosesion.encontrarId(id);
		modelo.addAttribute("usuariossesion", usuario);
		return "asignarRoles";
	}

}
