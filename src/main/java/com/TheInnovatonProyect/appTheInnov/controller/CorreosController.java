package com.TheInnovatonProyect.appTheInnov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TheInnovatonProyect.appTheInnov.facadeImpl.CorreosServ;
@Controller
public class CorreosController{
	
	  @Autowired
	    private CorreosServ correoserv;
	    
	    
	@GetMapping("/correos")
    public String index(){
        return "correo";
    }
	
	 @PostMapping("/sendMail")
	    public String sendMail(@RequestParam("name") String name, @RequestParam("mail") String mail, @RequestParam("subject") String subject, @RequestParam("body") String body){

	        String message = body +"\n\n Datos de contacto: " + "\nNombre: " + name + "\nE-mail: " + mail;
	        correoserv.sendMail(  "ivansanjuanez2@gmai.com" ,  mail ,subject,message);

	        return "correo";
	    }
	 
	 
}
