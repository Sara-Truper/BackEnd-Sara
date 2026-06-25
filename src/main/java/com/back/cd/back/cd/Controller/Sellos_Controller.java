package com.back.cd.back.cd.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.cd.back.cd.Modelo.sellos_Modelo;
import com.back.cd.back.cd.Modelo.Repositorio.Sellos_Repositorio;

@RestController
@RequestMapping("/importaciones/trialorder")
@CrossOrigin(origins = "*")
public class Sellos_Controller {
	@Autowired
	private Sellos_Repositorio sellos_Repositorio;
	
	@GetMapping("/sellosall") 
	public List<sellos_Modelo> listarSellos(){
		return sellos_Repositorio.findAll();
	}
	
}
