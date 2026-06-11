package com.back.cd.back.cd.Modelo.Repositorio;

import java.sql.Date;

public interface socsProjection {
    String getUsuario();
    String getColocador();
    Integer getNoProveedor();
    String getNombreProveedor();
    Integer getNoPo();
    Integer getNoNl();
    String getStatusProblema();
    String getUnidadDeNegocio();
    String getGerente();
    String getRea();
    String getFechaEmision();
    Date getAutorizacionPrevia();
    Date getFechaInicial();
    Date getReciboctrlpos();
    String getObservaciones();
    Date getEnviada();
}