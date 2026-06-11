package com.back.cd.back.cd.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.cd.back.cd.Modelo.Repositorio.socsProjection;
import com.back.cd.back.cd.Modelo.Repositorio.socsRepository;

@Service
public class service {
	@Autowired
	private socsRepository socsRepository;
	
	public List<socsProjection> listarRegistros(String username) {
	    return socsRepository.obtenerDataTabla(username);
	}
}

