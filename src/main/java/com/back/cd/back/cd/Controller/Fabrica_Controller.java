package com.back.cd.back.cd.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.back.cd.back.cd.Modelo.Repositorio.Fabricas_Repositorio;

@RestController
@RequestMapping("/importaciones/formatos")
@CrossOrigin

public class Fabrica_Controller {

	@Autowired
	private Fabricas_Repositorio fabricas_Repositorio;
	
	@GetMapping("/fabricas/{noSap}")
    public ResponseEntity<List<String>> obtenerFabricasPorProveedor(@PathVariable("noSap") String noSap) {
        List<String> fabricas = fabricas_Repositorio.findFabricasByProveedor(noSap);
        return ResponseEntity.ok(fabricas);
    }

    @GetMapping("/fabricas/nombre")
    public ResponseEntity<String> obtenerNombreFabrica(@RequestParam("noSap") String noSap, @RequestParam("sapFabrica") String sapFabrica) {
        String nombre = fabricas_Repositorio.findNombreFabrica(noSap, sapFabrica);
        return ResponseEntity.ok(nombre != null ? nombre : "");
    }

	
}
