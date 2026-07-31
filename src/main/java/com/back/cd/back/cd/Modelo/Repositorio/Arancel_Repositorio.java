package com.back.cd.back.cd.Modelo.Repositorio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.back.cd.back.cd.Modelo.Arancel_Modelo;
import com.back.cd.back.cd.Modelo.Tppm_Modelo;

@Repository
public interface Arancel_Repositorio extends JpaRepository<Arancel_Modelo, Long>{
		@Modifying
	    @Transactional
	    @Query(value = "TRUNCATE TABLE matriz_cd.arancel", nativeQuery = true)
	    void Truncararancel();

	@Query(value = ""
		    + "SELECT * FROM matriz_cd.arancel where porcentaje <> 0",
		    nativeQuery = true)
		List<Arancel_Modelo> arancelArribadeCero();
	
}