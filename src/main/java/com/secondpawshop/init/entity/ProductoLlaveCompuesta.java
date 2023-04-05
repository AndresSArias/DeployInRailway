package com.secondpawshop.init.entity;

public class ProductoLlaveCompuesta {
	String idUsuarioFK;
	String nombre;
	
	public ProductoLlaveCompuesta() {
		
	}
	
	public ProductoLlaveCompuesta(String idUsuarioFK, String nombre) {
		super();
		this.idUsuarioFK = idUsuarioFK;
		this.nombre = nombre;
	}

	public String getIdUsuarioFK() {
		return idUsuarioFK;
	}

	public void setIdUsuarioFK(String idUsuarioFK) {
		this.idUsuarioFK = idUsuarioFK;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
