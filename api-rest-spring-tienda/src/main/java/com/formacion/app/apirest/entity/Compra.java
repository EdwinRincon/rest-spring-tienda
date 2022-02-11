package com.formacion.app.apirest.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name="compras")

public class Compra implements Serializable {

	/**
	 * 
	 */
	@OneToOne
	private Articulo articulo;
	
	private static final long serialVersionUID = 1L;
	private Date fecha;
	private int unidades;
	
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public Articulo getArticulo() {
		return articulo;
	}
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	
	
	
}
