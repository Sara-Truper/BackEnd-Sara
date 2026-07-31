package com.back.cd.back.cd.Modelo.Repositorio;

import java.util.List;
<<<<<<< HEAD
=======

import javax.transaction.Transactional;

>>>>>>> emma/master
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.back.cd.back.cd.Modelo.Arancel_Modelo;

@Repository
<<<<<<< HEAD
public interface Arancel_Repositorio extends JpaRepository<Arancel_Modelo, Long> {

    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE matriz_cd.arancel", nativeQuery = true)
    void Truncararancel();
=======
public interface Arancel_Repositorio extends JpaRepository<Arancel_Modelo, Long>{
		@Modifying
	    @Transactional
	    @Query(value = "TRUNCATE TABLE matriz_cd.arancel", nativeQuery = true)
	    void Truncararancel();
>>>>>>> emma/master

    @Query(value = "SELECT * FROM matriz_cd.arancel WHERE porcentaje <> 0", nativeQuery = true)
    List<Arancel_Modelo> arancelArribadeCero();
}
