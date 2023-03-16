package com.TheInnovatonProyect.appTheInnov.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.TheInnovatonProyect.appTheInnov.facadeImpl.FileServicedao;

@Controller
@RequestMapping("/admin")
public class FileRestController {
	
	@Autowired
	private FileServicedao fileservicedao;
	
	@PostMapping("/upload")	
	public String uploadFile(@Validated @RequestParam(value = "files") List<MultipartFile> files) {
		try {
			fileservicedao.save(files);
			return "redirect:/sede?exito";
		} catch (Exception e) {
			return "redirect:/sede?fallo";
		}
	}

}
