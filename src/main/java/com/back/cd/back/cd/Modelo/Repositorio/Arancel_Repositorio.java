package com.back.cd.back.cd.Modelo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.back.cd.back.cd.Modelo.Arancel_Modelo;

@Repository
public interface Arancel_Repositorio extends JpaRepository<Arancel_Modelo, Long>{
	@Query(value = ""
			+ "truncate matriz_cd.arancel",
			nativeQuery = true)
		void Truncararancel() ;
}
