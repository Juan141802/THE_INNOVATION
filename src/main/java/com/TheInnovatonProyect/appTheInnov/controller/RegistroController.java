package com.TheInnovatonProyect.appTheInnov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.TheInnovatonProyect.appTheInnov.facade.IUsuariosSesion;

@Controller
public class RegistroController {
	
	
	
	@GetMapping("/login")
	public String iniciarSesion() {
		return "login";
	}
	
	@GetMapping("/")
	public String verPaginaInicio() {
		return "indexhtml";
	}

	
	@GetMapping("/error")
	public String error() {
		return "errores/error";
	}
}
