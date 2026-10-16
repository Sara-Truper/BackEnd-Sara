package com.back.cd.back.cd.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.poi.ss.usermodel.DataFormatter; //formateador de datos de la clase apache.poi hssf
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.back.cd.back.cd.Modelo.MailDTO;

@Service
public class MailSoc_Log_Service {
	@Autowired
	private JavaMailSender mailSender;
	
	private static final String rutaProv="\\\\TFSJIL01\\Planeacion_Control_Documental\\Contacto de Proveedores.xlsx";
	public List<MailDTO> correos(List<Map<String, Object>> filas){
		//agrupar filas por proveedor //collect agrupa elementos en una estructura de datos 
		Map<String, List<Map<String, Object>>> agrupados=filas.stream().collect(Collectors.groupingBy(f-> String.valueOf(f.getOrDefault("no_de_proveedor", "")).trim()));
		List<MailDTO> borrador=new ArrayList<>();
		for(Map.Entry<String, List<Map<String, Object>>> entry : agrupados.entrySet()) {
            String noProv = entry.getKey();
            List<Map<String, Object>> pos=entry.getValue();
            if(noProv.isEmpty()) continue;
            Map<String, Object> primeraFila = pos.get(0);
            String nombreProveedor=String.valueOf(primeraFila.getOrDefault("nombreProveedor", ""));
            //String po=String.valueOf(primeraFila.getOrDefault("nopo", ""));
            List<String> poUicas=pos.stream().map(p->{
            	String nopo=String.valueOf(p.getOrDefault("nopo", ""));
            	return nopo;
            }).distinct().collect(Collectors.toList());
            String cadenaPo=String.join(", ", poUicas);
            String correoProveedor=ObtenerCorreoProv(noProv);
            if(correoProveedor==null || correoProveedor.trim().isEmpty()) {
            	correoProveedor="srodriguezg@truper.com";
            }
            MailDTO dto=new MailDTO();
            dto.setNoProveedor(noProv);
            dto.setNombreProveedor(nombreProveedor);
            dto.setTo(correoProveedor);
            dto.setAsunto("noPOs: " + cadenaPo);
            dto.setTexto("Prueba proveedor: " + nombreProveedor);
            borrador.add(dto);
		}
		return borrador;
	}
	
	public List<MailDTO> enviarCorreo(List<Map<String, Object>> filas) {
        List<MailDTO> borradores = correos(filas);
		for(MailDTO dto:borradores) {
			try {
			MimeMessage mensaje=mailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(mensaje, true, "UTF-8");
			helper.setFrom("srodriguezg@truper.com");
			if (dto.getTo() != null) {
			    helper.setTo(dto.getTo().replace("; ", ","));
			}
			//helper.setCc(dto.getCc().split(";"));
			helper.setSubject(dto.getAsunto());
			helper.setText(dto.getTexto(),false); //true si se usa html
			mailSender.send(mensaje);
			}catch(Exception e ) {
				System.err.println("Error al enviar correo a " + dto.getTo() + ": " + e.getMessage());
                e.printStackTrace();
			}
		}return borradores;
	}
	
	private String ObtenerCorreoProv(String noPrvBusqueda){
		File file= new File(rutaProv);
		try (FileInputStream fis = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(fis)) {
        Sheet sheet = workbook.getSheetAt(0);
        DataFormatter formatter = new DataFormatter(); //formateado para mostar exactamente lo del excel 
        for (Row row : sheet) {
            if (row.getCell(0) != null){
                String valProv = formatter.formatCellValue(row.getCell(0)).trim();
                if (valProv.equalsIgnoreCase(noPrvBusqueda)) {
                    return (row.getCell(2))!= null ? formatter.formatCellValue(row.getCell(2)).trim(): "";
                }
            }
        }
        } catch (Exception e) {System.err.println("Error: " + e.getMessage());}
        return "";
    }
}
