package com.back.cd.back.cd.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.back.cd.back.cd.Modelo.socs_log_modelo;
import com.back.cd.back.cd.Modelo.Repositorio.socsProjection;
import com.back.cd.back.cd.Modelo.Repositorio.socsRepository;
import com.back.cd.back.cd.Modelo.Repositorio.socs_log_repositorio;

@RestController
@RequestMapping("/imp")
@CrossOrigin
public class controller {
	@Autowired
    private socsRepository socsRepository;
	@Autowired
	private socs_log_repositorio socs_log_repositorio;
	
	@GetMapping("/socs")
//	public List<socsProjection> verTabla() {
//	    return Service.getTablaSocs();
//	}
	public List<socsProjection> getTabla(@RequestParam("usuario") String usuario) {
		System.out.println(">>> Usuario recibido: [" + usuario + "]");
	    if ("prueba".equalsIgnoreCase(usuario)) {
	        return socsRepository.obtenerDataTabla(usuario);
	    }
	    return socsRepository.obtenerDataTabla(usuario);
    }
	
	@GetMapping("/log-all")
	public List<socs_log_modelo> obtenerTodosLosLogs() {
	    return socs_log_repositorio.findAll();
	}
	
	@PutMapping("/guardar")
	public ResponseEntity<?> guardarOActualizar(@RequestBody socs_log_modelo socs_log_modelo) {
        try {
            socs_log_modelo guardado = socs_log_repositorio.save(socs_log_modelo);
            return ResponseEntity.ok(guardado);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }
	
}