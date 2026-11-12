package com.back.cd.back.cd.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.cd.back.cd.Modelo.Tppm_Modelo;
import com.back.cd.back.cd.Modelo.Repositorio.Tp_Pm_Repository;

@RestController
@RequestMapping("/importaciones/formatos")
@CrossOrigin
public class Tp_pm_Controller {

	@Autowired
	private Tp_Pm_Repository tp_Pm_Repository;
	
	@GetMapping("/tppm/{po}")
	public List<Tppm_Modelo> consultarPOs(@PathVariable("po") Long po ){
	    return tp_Pm_Repository.buscaTppm(po);		
	}
	
	@GetMapping("/tppm/material/{material}")
	public ResponseEntity<Tppm_Modelo> consultarPorMaterial(@PathVariable("material") Long material){
		return tp_Pm_Repository.findFirstByMaterial(material)
				.map(registro -> ResponseEntity.ok().body(registro))//encuent
                .orElse(ResponseEntity.notFound().build());
	}

}
