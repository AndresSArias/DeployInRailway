package com.secondpawshop.init.entity.view;

import org.springframework.data.annotation.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "VISTACARRO")
@Immutable
public class ViewCarrito {
	
	@Id
	@Column (name = "IMAGEN")
	private String imagen;
	@Column (name = "NOMBRE")
	private String nombreproducto;
	@Column (name = "CANTIDADACOMPRAR")
	private int cantidadacomprar;
	@Column (name = "PRECIO")
	private int precio;
	@Column (name = "PRECIOTOTAL")
	private int preciototal;
	@Column (name = "IDUSUARIOPROPETARIO")
	private String idUsuarioPropietario;
	@Column (name = "IDUSUARIOCOMPRADOR")
	private String idUsuarioComprador;
	
	public ViewCarrito() {
	}

	public ViewCarrito(String imagen, String nombreproducto, int cantidadacomprar, int precio, int preciototal,
			String idUsuarioPropietario, String idUsuarioComprador) {
		super();
		this.imagen = imagen;
		this.nombreproducto = nombreproducto;
		this.cantidadacomprar = cantidadacomprar;
		this.precio = precio;
		this.preciototal = preciototal;
		this.idUsuarioPropietario = idUsuarioPropietario;
		this.idUsuarioComprador = idUsuarioComprador;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getNombreproducto() {
		return nombreproducto;
	}

	public void setNombreproducto(String nombreproducto) {
		this.nombreproducto = nombreproducto;
	}

	public int getCantidadacomprar() {
		return cantidadacomprar;
	}

	public void setCantidadacomprar(int cantidadacomprar) {
		this.cantidadacomprar = cantidadacomprar;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getPreciototal() {
		return preciototal;
	}

	public void setPreciototal(int preciototal) {
		this.preciototal = preciototal;
	}

	public String getIdUsuarioPropietario() {
		return idUsuarioPropietario;
	}

	public void setIdUsuarioPropietario(String idUsuarioPropietario) {
		this.idUsuarioPropietario = idUsuarioPropietario;
	}

	public String getIdUsuarioComprador() {
		return idUsuarioComprador;
	}

	public void setIdUsuarioComprador(String idUsuarioComprador) {
		this.idUsuarioComprador = idUsuarioComprador;
	}
	
}
