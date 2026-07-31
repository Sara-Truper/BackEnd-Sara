package com.back.cd.back.cd.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="formato_revisados")
@AllArgsConstructor
@NoArgsConstructor
public class Revisados_Modelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private	String unidad_de_negocio;
	private String responsable;
	private String tiporev;
	private String contenido;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUnidad_de_negocio() {
		return unidad_de_negocio;
	}
	public void setUnidad_de_negocio(String unidad_de_negocio) {
		this.unidad_de_negocio = unidad_de_negocio;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setRespondsable(String respondsable) {
		this.responsable = respondsable;
	}
	public String getTiporev() {
		return tiporev;
	}
	public void setTiporev(String tiporev) {
		this.tiporev = tiporev;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	
}
