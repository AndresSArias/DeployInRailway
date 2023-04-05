package com.secondpawshop.init.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "USUARIO")
public class Usuario {
	
	@Id
	@Column (name = "IDUSUARIO")
	private String idUsuario;
	
	@Column (name = "NOMBRE")
	private String nombre;
	
	@Column (name = "APELLIDO")
	private String apellido;
	
	@Column (name = "CORREO")
	private String correo;
	
	@Column (name = "CELULAR")
	private String celular;
	
	@Column (name = "DIRECCION")
	private String direccion;
	
	@Column (name = "CONTRASENA")
	private String contrasena;
	
	@Column (name = "ROL")
	private String rol;
	
	public Usuario () {
		
	}

	public Usuario(String idUsuario, String nombre, String apellido, String correo, String celular, String direccion,
			String contrasena, String rol) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.celular = celular;
		this.direccion = direccion;
		this.contrasena = contrasena;
		this.rol = rol;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
		

}
