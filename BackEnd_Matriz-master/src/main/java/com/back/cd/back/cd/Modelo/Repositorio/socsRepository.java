package com.back.cd.back.cd.Modelo.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import com.back.cd.back.cd.Modelo.socs;
import com.back.cd.back.cd.Modelo.Soc_Modelo;

@Repository
public interface socsRepository extends JpaRepository<Soc_Modelo, Integer> {
	@Query(value = "SELECT DISTINCT " +
            "s.asistentepos AS usuario, " +
            "s.colocador AS colocador, " +
            "s.no_de_proveedor AS noProveedor, " +
            "lp.supplier AS nombreProveedor, " +
            "s.foliott AS noPo, " +
            "s.nooc AS noNl, " +
            "s.status_problema AS statusProblema, " +
            "s.unidad_de_negocio AS unidadDeNegocio, " +
            "c.gte_responsable_bu AS gerente, " +
            "s.rea AS rea, " +
            "s.fecha_de_emisionoc AS fechaEmision, " +
            "ld.autorizacionPrevia AS autorizacionPrevia, "+
            "s.fecha_de_emisionoc AS fechaInicial, " +
            "s.fecha_de_reciboactrlpos AS reciboctrlpos , "+
            "s.observaciones AS observaciones, " +
            "s.envio_de_laocal_proveedoreoc AS enviada, "+
            "ld.numero_reimp AS numero, " +
            "ld.comentarios_doc AS comentarios, " +
            "COALESCE(ld.status_reimp, 'Abierta') AS statusre, " +
            "ld.fefi_plan AS fefi, " +
            "ld.comments_plan AS comments, " +
            "ld.fef_compras AS fef " +
            "ld.comentarios_compras AS com, " +
            "FROM socs s " + 
            "LEFT JOIN contactos c ON s.unidad_de_negocio = c.unidad_de_negocio " +
            "LEFT JOIN lista_proveedores lp ON s.no_de_proveedor = lp.acreedor " +
            "LEFT JOIN socs_log ld ON s.foliott = ld.no_po " + 
            "WHERE :usuario = 'prueba' OR TRIM(s.asistentepos) = :usuario", 
            nativeQuery = true)
    List<socsProjection> obtenerDataTabla(@Param("usuario") String usuario);
}