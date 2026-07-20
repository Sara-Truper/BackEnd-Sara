package com.back.cd.back.cd.Modelo.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.back.cd.back.cd.Modelo.Matriz_Control_Documental_Modelo;
import com.back.cd.back.cd.Modelo.Tppm_Modelo;

public interface Tp_Pm_Repository extends JpaRepository<Tppm_Modelo, Long> {
	
	@Query(value = ""
			+ "truncate matriz_cd.tp_pm_tabla_revisados",
			nativeQuery = true)
		void Truncartppm() ;

	@Query(value = ""
			+ "SELECT * FROM matriz_cd.tp_pm_tabla_revisados where po = :po",
			nativeQuery = true)
	List<Tppm_Modelo> buscaTppm(@Param("po") Long po);	
}
