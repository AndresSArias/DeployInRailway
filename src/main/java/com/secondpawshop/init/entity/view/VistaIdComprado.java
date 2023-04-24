package com.secondpawshop.init.entity.view;

import org.springframework.data.annotation.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "VISTAIDCOMPRADO")
@Immutable
public class VistaIdComprado {
	@Id
	@Column(name = "IDVENTA")
	private String idventa;
	
	@Column(name = "IDUSUARIOCOMPRADOR")
    private String idusuariocomprador;
	
	public VistaIdComprado() {
		// TODO Auto-generated constructor stub
	}

	public VistaIdComprado(String idventa, String idusuariocomprador) {
		super();
		this.idventa = idventa;
		this.idusuariocomprador = idusuariocomprador;
	}

	public String getIdventa() {
		return idventa;
	}

	public void setIdventa(String idventa) {
		this.idventa = idventa;
	}

	public String getIdusuariocomprador() {
		return idusuariocomprador;
	}

	public void setIdusuariocomprador(String idusuariocomprador) {
		this.idusuariocomprador = idusuariocomprador;
	}
	
}
