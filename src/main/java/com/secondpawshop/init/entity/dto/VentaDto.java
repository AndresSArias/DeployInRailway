package com.secondpawshop.init.entity.dto;

public class VentaDto {
	
	private String idUsuarioPropetario;
	private String nombreProducto;
	private String idUsuarioComprador;
	private int cantidadAComprar;
	private int precioTotal;
	
	public VentaDto() {
		
	}

	public VentaDto(String idUsuarioPropetario, String nombreProducto, String idUsuarioComprador, int cantidadAComprar,
			int precioTotal) {
		super();
		this.idUsuarioPropetario = idUsuarioPropetario;
		this.nombreProducto = nombreProducto;
		this.idUsuarioComprador = idUsuarioComprador;
		this.cantidadAComprar = cantidadAComprar;
		this.precioTotal = precioTotal;
	}

	public String getIdUsuarioPropetario() {
		return idUsuarioPropetario;
	}

	public void setIdUsuarioPropetario(String idUsuarioPropetario) {
		this.idUsuarioPropetario = idUsuarioPropetario;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getIdUsuarioComprador() {
		return idUsuarioComprador;
	}

	public void setIdUsuarioComprador(String idUsuarioComprador) {
		this.idUsuarioComprador = idUsuarioComprador;
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
