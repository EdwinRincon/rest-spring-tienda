package com.formacion.app.apirest.entity;


	import java.io.Serializable;
	import java.util.Date;
import java.util.List;

import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
import javax.persistence.OneToMany;

	import javax.persistence.Table;


	@Entity
	@Table( name="clientes")
	public class Cliente implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@OneToMany
		private List<Compra> compras;
		@Id
		@GeneratedValue(strategy= GenerationType.IDENTITY)
		private long codCliente;
		@Column(nullable = false)
		private String nombre, apellidos, empresa, puesto,cp,Provincia;
		
		private int telefono;
		@Column(nullable = false)
		private Date fechaNacimiento;
		
		
		public long getCodCliente() {
			return codCliente;
		}
		public void setCodCliente(long codCliente) {
			this.codCliente = codCliente;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getApellidos() {
			return apellidos;
		}
		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}
		public String getEmpresa() {
			return empresa;
		}
		public void setEmpresa(String empresa) {
			this.empresa = empresa;
		}
		public String getPuesto() {
			return puesto;
		}
		public void setPuesto(String puesto) {
			this.puesto = puesto;
		}
		public String getCp() {
			return cp;
		}
		public void setCp(String cp) {
			this.cp = cp;
		}
		public String getProvincia() {
			return Provincia;
		}
		public void setProvincia(String provincia) {
			Provincia = provincia;
		}
		public Date getFechaNacimiento() {
			return fechaNacimiento;
		}
		public void setFechaNacimiento(Date fechaNacimiento) {
			this.fechaNacimiento = fechaNacimiento;
		}
		public int getTelefono() {
			return telefono;
		}
		public void setTelefono(int telefono) {
			this.telefono = telefono;
		}
		public List<Compra> getCompras() {
			return compras;
		}
		public void setCompras(List<Compra> compras) {
			this.compras = compras;
		}
		
		
	
	
}