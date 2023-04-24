package com.secondpawshop.init.entity.dto;

public class VentaCarroDto {
	
	private String imagen;
	private String nombreproducto;
	private int cantidadacomprar;
	private int precio;
	private int preciototal;
	private String idUsuarioPropietario;
	
	public VentaCarroDto() {
		
	}

	public VentaCarroDto(String imagen, String nombreproducto, int cantidadacomprar, int precio, int preciototal,
			String idUsuarioPropietario) {
		super();
		this.imagen = imagen;
		this.nombreproducto = nombreproducto;
		this.cantidadacomprar = cantidadacomprar;
		this.precio = precio;
		this.preciototal = preciototal;
		this.idUsuarioPropietario = idUsuarioPropietario;
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

	
	
}
