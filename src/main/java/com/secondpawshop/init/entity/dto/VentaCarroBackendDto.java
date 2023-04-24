package com.secondpawshop.init.entity.dto;

public class VentaCarroBackendDto {
	
	private String idusuariopropetario;
	private String nombreproducto;
	private String idusuariocomprador;
	
	public VentaCarroBackendDto() {
		// TODO Auto-generated constructor stub
	}

	public VentaCarroBackendDto(String idusuariopropetario, String nombreproducto, String idusuariocomprador) {
		super();
		this.idusuariopropetario = idusuariopropetario;
		this.nombreproducto = nombreproducto;
		this.idusuariocomprador = idusuariocomprador;
	}

	public String getIdusuariopropetario() {
		return idusuariopropetario;
	}

	public void setIdusuariopropetario(String idusuariopropetario) {
		this.idusuariopropetario = idusuariopropetario;
	}

	public String getNombreproducto() {
		return nombreproducto;
	}

	public void setNombreproducto(String nombreproducto) {
		this.nombreproducto = nombreproducto;
	}

	public String getIdusuariocomprador() {
		return idusuariocomprador;
	}

	public void setIdusuariocomprador(String idusuariocomprador) {
		this.idusuariocomprador = idusuariocomprador;
	}
	
	
}
