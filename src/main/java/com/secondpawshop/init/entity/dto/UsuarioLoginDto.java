package com.secondpawshop.init.entity.dto;

public class UsuarioLoginDto {
	
	private String idUsuario;
	private String contrasena;
	
	public UsuarioLoginDto() {
		
	}

	public UsuarioLoginDto(String idUsuario, String contrasena) {
		super();
		this.idUsuario = idUsuario;
		this.contrasena = contrasena;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
}
