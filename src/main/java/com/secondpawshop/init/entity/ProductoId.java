package com.secondpawshop.init.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductoId implements Serializable {
	
    private static final long serialVersionUID = 4952362622210618567L;
    
    @Column(name = "IDUSUARIOFK", nullable = false, length = 15)
    public String idUsuarioFK;
    
    @Column(name = "NOMBRE", nullable = false, length = 50)
    public String nombre;    
    
    public ProductoId() {
	
	}

    public ProductoId(String idUsuariofk, String nombre) {
		super();
		this.idUsuarioFK = idUsuariofk;
		this.nombre = nombre;
	}

	public String getIdUsuariofk() {
		return idUsuarioFK;
	}

	public void setIdUsuariofk(String idUsuariofk) {
		this.idUsuarioFK = idUsuariofk;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductoId entity = (ProductoId) o;
        return Objects.equals(this.idUsuarioFK, entity.idUsuarioFK) &&
                Objects.equals(this.nombre, entity.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuarioFK, nombre);
    }

}