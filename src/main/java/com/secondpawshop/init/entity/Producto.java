package com.secondpawshop.init.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table (name = "Producto")
@IdClass(ProductoLlaveCompuesta.class)
public class Producto {

	@Id
	@Column (name = "IDUSUARIOFK")
	private String idUsuarioFK;
	
	@Id
	@Column (name = "NOMBRE")
	private String nombre;
	
	@Column (name = "CATEGORIA")
	private String categoria;

	@Column (name = "DESCRIPCION")
	private String descripcion;
	
	@Column (name = "CANTIDAD")
	private int cantidad;
	
	@Column (name = "PRECIO")
	private int precio;
	
	@Column (name = "IMAGEN")
	private String imagen;
	
	@Column (name = "ESTADO")
	private String estado;
	
	public Producto () {
		
	}

	public Producto(String idUsuarioFK, String nombre, String categoria, String descripcion, int cantidad, int precio,
			String imagen, String estado) {
		super();
		this.idUsuarioFK = idUsuarioFK;
		this.nombre = nombre;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.precio = precio;
		this.imagen = imagen;
		this.estado = estado;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
