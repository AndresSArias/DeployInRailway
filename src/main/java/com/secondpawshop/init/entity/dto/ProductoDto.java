package com.secondpawshop.init.entity.dto;


public class ProductoDto {
	
	private String idUsuarioFK;
	private String nombre;
	private String categoria;
	private String descripcion;
	private int cantidad;
	private int precio;
	private String imagen;
	
	public ProductoDto () {
		
	}

	public ProductoDto(String idUsuarioFK, String nombre, String categoria, String descripcion, int cantidad,
			int precio, String imagen) {
		super();
		this.idUsuarioFK = idUsuarioFK;
		this.nombre = nombre;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.precio = precio;
		this.imagen = imagen;
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
}
