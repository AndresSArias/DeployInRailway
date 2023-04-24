package com.secondpawshop.init.entity.view;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Immutable;
@Entity
@Table (name = "VISTAHISTORIAL")
@Immutable
public class ViewHistorial {
	
	@Id
	@Column (name = "IMAGEN")
	private String imagen;
	
	@Column (name = "NOMBRE")
	private String nombre;

	@Column (name = "CATEGORIA")
	private String categoria;
	
	@Column (name = "DESCRIPCION")
	private String descripcion;
	
	@Column (name = "CANTIDADACOMPRAR")
	private int cantidadAComprar;
	
	@Column (name = "PRECIOTOTAL")
	private int precioTotal;
	
	@Column (name = "IDUSUARIOCOMPRADOR")
	private String idUsuarioComprador;
	
	public ViewHistorial() {
		
	}

	public ViewHistorial(String imagen, String nombre, String categoria, String descripcion, int cantidadAComprar,
			int precioTotal, String idUsuarioComprador) {
		super();
		this.imagen = imagen;
		this.nombre = nombre;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.cantidadAComprar = cantidadAComprar;
		this.precioTotal = precioTotal;
		this.idUsuarioComprador = idUsuarioComprador;
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

	public String getIdUsuarioComprador() {
		return idUsuarioComprador;
	}

	public void setIdUsuarioComprador(String idUsuarioComprador) {
		this.idUsuarioComprador = idUsuarioComprador;
	}
	
}
