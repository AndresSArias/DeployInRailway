package com.secondpawshop.init.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class VentaId implements Serializable {
    private static final long serialVersionUID = 32800221983482738L;
    
    @Column(name = "IDVENTA", nullable = false, length = 50)
    private String idventa;

    @Column(name = "IDUSUARIOPROPETARIO", nullable = false, length = 50)
    private String idusuariopropetario;

    @Column(name = "NOMBREPRODUCTO", nullable = false, length = 50)
    private String nombreproducto;

    @Column(name = "IDUSUARIOCOMPRADOR", nullable = false, length = 50)
    private String idusuariocomprador;

    public VentaId ()  {
    	
    }
    
    public VentaId(String idventa, String idusuariopropetario, String nombreproducto,
			String idusuariocomprador) {
		super();
		this.idventa = idventa;
		this.idusuariopropetario = idusuariopropetario;
		this.nombreproducto = nombreproducto;
		this.idusuariocomprador = idusuariocomprador;
	}



	public String getIdventa() {
        return idventa;
    }

    public void setIdventa(String idventa) {
        this.idventa = idventa;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        VentaId entity = (VentaId) o;
        return Objects.equals(this.idventa, entity.idventa) &&
                Objects.equals(this.idusuariopropetario, entity.idusuariopropetario) &&
                Objects.equals(this.idusuariocomprador, entity.idusuariocomprador) &&
                Objects.equals(this.nombreproducto, entity.nombreproducto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idventa, idusuariopropetario, idusuariocomprador, nombreproducto);
    }

}