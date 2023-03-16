package com.TheInnovatonProyect.appTheInnov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	@GetMapping("/Visad")
	public String VerpaginaAmin() {
		return "Admin";
	}
	
}
