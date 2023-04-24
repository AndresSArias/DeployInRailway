package com.secondpawshop.init.entity.dto;

public class VentaHistorialDto {
	
	private String imagen;
	private String nombre;
	private String categoria;
	private String descripcion;
	private int cantidadAComprar;
	private int precioTotal;
	
	public VentaHistorialDto() {
		
	}

	public VentaHistorialDto(String imagen, String nombre, String categoria, String descripcion,
			int cantidadAComprar, int precioTotal) {
		super();
		this.imagen = imagen;
		this.nombre = nombre;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.cantidadAComprar = cantidadAComprar;
		this.precioTotal = precioTotal;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
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

	public int getCantidadAComprar() {
		return cantidadAComprar;
	}

	public void setCantidadAComprar(int cantidadAComprar) {
		this.cantidadAComprar = cantidadAComprar;
	}

	public int getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(int precioTotal) {
		this.precioTotal = precioTotal;
	}
	
}
