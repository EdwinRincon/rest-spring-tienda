package com.formacion.app.apirest.entity;


	import java.io.Serializable;
	import java.util.Date;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.PrePersist;
	import javax.persistence.Table;
	import javax.persistence.Temporal;
	import javax.persistence.TemporalType;

	@Entity
	@Table( name="clientes")
	public class Clientes implements Serializable{

		@Id
		@GeneratedValue(strategy= GenerationType.IDENTITY)
		private long codCliente;
		@Column(nullable = false)
		private String nombre, apellidos, empresa, puesto,CP,Provincia;
		
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
		public String getCP() {
			return CP;
		}
		public void setCP(String cP) {
			CP = cP;
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
		
		
	
	
}