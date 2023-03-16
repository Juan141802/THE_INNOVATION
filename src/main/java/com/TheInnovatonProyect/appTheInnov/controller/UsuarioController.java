package com.TheInnovatonProyect.appTheInnov.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TheInnovatonProyect.appTheInnov.facadeImpl.Roldao;

import com.TheInnovatonProyect.appTheInnov.facadeImpl.UsuariosSesiondao;
import com.TheInnovatonProyect.appTheInnov.modelo.Rol;

import com.TheInnovatonProyect.appTheInnov.modelo.UsuariosSesion;


@Controller

public class UsuarioController {
	
	@Autowired
	private UsuariosSesiondao usuariodao;
	 
	@Autowired
	private Roldao rolDao;
	
	
	
	@GetMapping("/usu")
	public String allUsuarios(Model modelo) {
    List<UsuariosSesion> lstUsu = this.usuariodao.listarUsuarios();
	List<Rol> lstRol = this.rolDao.encontrarTodo();
	modelo.addAttribute("listaU", lstUsu);
	modelo.addAttribute("lstRol", lstRol);

		return "index";
	}
	
	@PostMapping("/usu/guardar")
	public String recibeRol(@ModelAttribute("usuario") UsuariosSesion usuario) {
		usuariodao.crear(usuario);
		return "redirect:/usu";
	}
	
	@GetMapping("/usu/editar/{id}")
	public String asignaRol(@PathVariable("id") Long id, Model modelo) {
		List<Rol> lstRol = this.rolDao.encontrarTodo();
		UsuariosSesion usuario = usuariodao.encontrarId(id);
		modelo.addAttribute("usuario", usuario);
		modelo.addAttribute("lstRol", lstRol);
		return "editar_usuario";
	}
}
