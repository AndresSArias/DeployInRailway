package com.secondpawshop.init.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table (name = "venta")
@IdClass (VentaLlaveCompuesta.class)
public class Venta {
	
	@Id
	@Column (name = "IDVENTA")
	private String idVenta;
	
	@Id
	@Column (name = "IDUSUARIOPROPETARIO")
	private String idUsuarioPropetario;
	
	@Id
	@Column (name = "NOMBREPRODUCTO")
	private String nombreProducto;
	
	@Id
	@Column (name = "IDUSUARIOCOMPRADOR")
	private String idUsuarioComprador;
	
	@Column (name = "CANTIDADACOMPRAR")
	private String cantidadAComprar;

	@Column (name = "ESTADO")
	private String estado;
	
	public Venta () {
		
	}

	public Venta(String idVenta, String idUsuarioPropetario, String nombreProducto, String idUsuarioComprador,
			String cantidadAComprar, String estado) {
		super();
		this.idVenta = idVenta;
		this.idUsuarioPropetario = idUsuarioPropetario;
		this.nombreProducto = nombreProducto;
		this.idUsuarioComprador = idUsuarioComprador;
		this.cantidadAComprar = cantidadAComprar;
		this.estado = estado;
	}

	public String getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(String idVenta) {
		this.idVenta = idVenta;
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

	public String getCantidadAComprar() {
		return cantidadAComprar;
	}

	public void setCantidadAComprar(String cantidadAComprar) {
		this.cantidadAComprar = cantidadAComprar;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}