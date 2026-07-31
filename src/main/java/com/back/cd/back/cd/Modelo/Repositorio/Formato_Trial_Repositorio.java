package com.back.cd.back.cd.Modelo.Repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.cd.back.cd.Modelo.Formato_Trial_Modelo;

@Repository
public interface Formato_Trial_Repositorio extends JpaRepository<Formato_Trial_Modelo, Long>{
	Optional<Formato_Trial_Modelo> findByFolio(String folio);
}