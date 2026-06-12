package com.back.cd.back.cd.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="buffer")
public class buffer_Modelo {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String planeador;
	private String proveedor;
	private int codigo;
	private String descripcion;
	private int codigo_maquina;
	private String clave_maquina;
	private String c_e;
	private float daily_mrp_sale;
	private int var_sales_fcstm;
	private int var_sales_4weeks;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPlaneador() {
		return planeador;
	}
	public void setPlaneador(String planeador) {
		this.planeador = planeador;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCodigo_maquina() {
		return codigo_maquina;
	}
	public void setCodigo_maquina(int codigo_maquina) {
		this.codigo_maquina = codigo_maquina;
	}
	public String getClave_maquina() {
		return clave_maquina;
	}
	public void setClave_maquina(String clave_maquina) {
		this.clave_maquina = clave_maquina;
	}
	public String getC_e() {
		return c_e;
	}
	public void setC_e(String c_e) {
		this.c_e = c_e;
	}
	public float getDaily_mrp_sale() {
		return daily_mrp_sale;
	}
	public void setDaily_mrp_sale(float daily_mrp_sale) {
		this.daily_mrp_sale = daily_mrp_sale;
	}
	public int getVar_sales_fcstm() {
		return var_sales_fcstm;
	}
	public void setVar_sales_fcstm(int var_sales_fcstm) {
		this.var_sales_fcstm = var_sales_fcstm;
	}
	public int getVar_sales_4weeks() {
		return var_sales_4weeks;
	}
	public void setVar_sales_4weeks(int var_sales_4weeks) {
		this.var_sales_4weeks = var_sales_4weeks;
	}
}


