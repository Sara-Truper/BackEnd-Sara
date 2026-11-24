package com.back.cd.back.cd.Controller;

import org.springframework.http.MediaType;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.back.cd.back.cd.Modelo.Formato_Trial_Modelo;
import com.back.cd.back.cd.Modelo.Repositorio.Formato_Trial_Repositorio;

@RestController
@RequestMapping("/importaciones/trialorder")
@CrossOrigin
public class Formato_Trial_Controller {
	@Autowired
	private Formato_Trial_Repositorio trial_Repositorio;
	
	@PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody Formato_Trial_Modelo trial) {
        try {
        	if(trial.getId()== null && (trial.getFolio()==null || trial.getFolio().isEmpty() || trial_Repositorio.existsByFolio(trial.getFolio()))) {
        		String folioDisp=siguienteFolio(trial.getBu()).getBody();
        		trial.setFolio(folioDisp);
        	}
            Formato_Trial_Modelo guardado = trial_Repositorio.save(trial);
            /*if (guardado.getFolio() == null || guardado.getFolio().isEmpty()) {
                String folioAutogenerado = "TRIAL-" + String.format("%04d", guardado.getId());
                
                guardado.setFolio(folioAutogenerado);
                guardado = trial_Repositorio.save(guardado);
            }*/
            return ResponseEntity.ok(guardado); 
        }catch(Exception e){
        	e.printStackTrace();
            return ResponseEntity.badRequest().body("Error al guardar: " + e.getMessage());
        }
    }
	
	@GetMapping("/buscar/{folio}")
    public ResponseEntity<Formato_Trial_Modelo> buscarPorFolio(@PathVariable String folio) {
        return trial_Repositorio.findByFolio(folio)
        		.map(registro -> ResponseEntity.ok().body(registro))//encuent
                .orElse(ResponseEntity.notFound().build()); //error 404 no encontrado
    }
    
    @GetMapping("/siguiente-folio")
    public ResponseEntity<String> siguienteFolio(@RequestParam(required=false) String bu){
        boolean esProvAlternos="Proveedores alternos".equalsIgnoreCase(bu!=null ? bu.trim() : "");
        String pref=esProvAlternos ? "PA-TRIAL-" : "TRIAL-";
    	String ultimoFolio=trial_Repositorio.findTopByFolioStartingWithOrderByIdDesc(pref).map(Formato_Trial_Modelo::getFolio)//ref a metodo clase::metodo instancia ambda
    			.filter(f-> f!=null && f.startsWith(pref)).orElse(pref+"0000");;
    	String partes=ultimoFolio.replace(pref, "");
    	int numeroActual=Integer.parseInt(partes);
    	String siguiente=String.format("%s%04d",pref, numeroActual+1);
    	return ResponseEntity.ok(siguiente);
    }
	
	@GetMapping("/listar")
    public ResponseEntity<List<Formato_Trial_Modelo>> listarTodos() {
        List<Formato_Trial_Modelo> lista = trial_Repositorio.findAll();
        return ResponseEntity.ok(lista);
    }
	
	@GetMapping(value = "/imagen/tipo-cambio", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> obtenerImagen() throws IOException{
		Path ruta=Paths.get("\\\\cernotes\\Publico\\Z_FormatoTEST\\TIPO_C\\Imagen1.png");
        byte[] imagenBytes=Files.readAllBytes(ruta);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(imagenBytes);
	}
}
