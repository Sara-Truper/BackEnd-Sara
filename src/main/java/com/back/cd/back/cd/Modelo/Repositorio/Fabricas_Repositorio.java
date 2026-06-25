package com.back.cd.back.cd.Modelo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.back.cd.back.cd.Modelo.Fabricas_Modelo;

@Repository
public interface Fabricas_Repositorio extends JpaRepository<Fabricas_Modelo, Long>{
	@Query(value = ""
			+ "truncate matriz_cd.fabricas",
			nativeQuery = true)
		void Truncarfabricas() ;
}
