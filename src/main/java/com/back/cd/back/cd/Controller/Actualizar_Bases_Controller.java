package com.back.cd.back.cd.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.cd.back.cd.Modelo.Arancel_Modelo;
import com.back.cd.back.cd.Modelo.codigos;
import com.back.cd.back.cd.Modelo.precios;
import com.back.cd.back.cd.Modelo.Repositorio.Arancel_Repositorio;
import com.back.cd.back.cd.Modelo.Repositorio.codigosRepository;
import com.back.cd.back.cd.Modelo.Repositorio.preciosRepository;

@RestController
@CrossOrigin
@RequestMapping("/importaciones/actualizarbases")
public class Actualizar_Bases_Controller {
	@Autowired
	private service mService;
	@Autowired
	private codigosRepository CodigosRepository;
	@Autowired
	private preciosRepository preciosRepository;
	@Autowired
	private Arancel_Repositorio arancel_Repositorio;
	
	@PostMapping("arancel")
	public ResponseEntity<Map<String, Object>> arancel(){
		Map<String, Object> respuesta=new HashMap<>();
		try {
            mService.actualizarArancel();
            respuesta.put("message", "Tabla Arancel actualizada con éxito");
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            e.printStackTrace();
            respuesta.put("message", "Error al actualizar tabla: " + e.getMessage());
            return ResponseEntity.internalServerError().body(respuesta);
        }
	}
	
	@GetMapping("/arancel")
	public List<Arancel_Modelo> aranceles(){
		return arancel_Repositorio.findAll();
	}
	
	@PostMapping("fabricas")
	public ResponseEntity<Map<String, Object>> fab(){
		Map<String, Object> respuesta=new HashMap<>();
		try {
            mService.actualizarFabricas();
            respuesta.put("message", "Tabla Fabricas actualizada con éxito");
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            e.printStackTrace();
            respuesta.put("message", "Error al actualizar tabla: " + e.getMessage());
            return ResponseEntity.internalServerError().body(respuesta);
        }
	}
	
	@PostMapping("/actualizar")
    public ResponseEntity<Map<String, Object>> actualizar() {
		Map<String, Object> respuesta = new HashMap<>();
        try {
            mService.actualizarProveedores();
            mService.actualizarDirectos();
            mService.actualizarPrecios();
            //mService.actualizarPool();
            respuesta.put("message", "Tablas (lista_proveedores, directos , Precios)  actualizadas con éxito");
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            e.printStackTrace();
            respuesta.put("message", "Error al actualizar tablas: " + e.getMessage());
            return ResponseEntity.internalServerError().body(respuesta);
        }
    }
	
	@PostMapping("/pool")
	public ResponseEntity<Map<String, Object>> pool(){
		Map<String, Object> respuesta = new HashMap<>();
        try {
            mService.actualizarPool();
            respuesta.put("message", "Tabla Pool actualizada con éxito");
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            e.printStackTrace();
            respuesta.put("message", "Error al actualizar tabla: " + e.getMessage());
            return ResponseEntity.internalServerError().body(respuesta);
        }
	}
	
	@PostMapping("/actualizar2")
	public ResponseEntity<Map<String, Object>> contactos(){ 
		Map<String, Object> respuesta = new HashMap<>();
        try {
            mService.actualizarContactos();
            mService.actualizarWksh();
            mService.actualizarCodigos();
            respuesta.put("message", "Tablas (contactos, mksh, codigos) actualizadas con éxito");
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            e.printStackTrace();
            respuesta.put("message", "Error al actualizar tablas: " + e.getMessage());
            return ResponseEntity.internalServerError().body(respuesta);
        }
	}
	
	@GetMapping("/codigosall")
	public List<codigos> listarCodigos(){
		return CodigosRepository.findAll();
	}
	
	@GetMapping("/preciosall")
	public List<precios> listarPrecios(){
		return preciosRepository.findAll();
	}
}