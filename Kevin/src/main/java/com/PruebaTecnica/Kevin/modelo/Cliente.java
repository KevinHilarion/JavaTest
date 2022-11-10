package com.PruebaTecnica.Kevin.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer Numero_documento;
	
	@Column(name="Nombre", nullable = false)
	private  String Nombre;
	
	@Column(name="Apellido", nullable = false)
	private String Apellido;
	
	@Column(name="Fecha_Nacimiento", nullable = false)
	private String Fecha_Nacimiento;
	
	@Column(name="Ciudad", nullable = false)
	private String Ciudad;
	
	@Column(name="Correo", nullable = false)
	private String Correo;
	
	@Column(name="Telefono", nullable = false)
	private String Telefono;
	
	@Column(name="Ocupacion", nullable = false)
	private String Ocupacion;
	
	/*Getters and Setters*/
	
	public Integer getNumero_documento() {
		return Numero_documento;
	}

	public void setNumero_documento(Integer numero_documento) {
		Numero_documento = numero_documento;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getFecha_Nacimiento() {
		return Fecha_Nacimiento;
	}

	public void setFecha_Nacimiento(String fecha_Nacimiento) {
		Fecha_Nacimiento = fecha_Nacimiento;
	}

	public String getCiudad() {
		return Ciudad;
	}

	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getOcupacion() {
		return Ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		Ocupacion = ocupacion;
	}
	
	/*Constructor*/
	
	
	
	

}
