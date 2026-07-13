package com.back.cd.back.cd.Modelo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.back.cd.back.cd.Modelo.listaProveedores;



@Repository
public interface listaProveedoresRepository extends JpaRepository<listaProveedores, Integer>{
<<<<<<< HEAD
=======

>>>>>>> de2bde74bea64f6a473853288f894b84a3b4a7ef
	@Query(value = ""
			+ "truncate matriz_cd.lista_proveedores",
			nativeQuery = true)
		void Truncarlistaproveedores() ;
<<<<<<< HEAD
=======
	

>>>>>>> de2bde74bea64f6a473853288f894b84a3b4a7ef
}


