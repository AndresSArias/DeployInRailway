package com.secondpawshop.init.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "venta")
public class Venta {
    @EmbeddedId
    private VentaId id;
    
   
    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "NOMBREPRODUCTO", referencedColumnName = "NOMBRE", nullable = false),
            @JoinColumn(name = "IDUSUARIOPROPETARIO", referencedColumnName = "IDUSUARIOFK", nullable = false)
    })
    private Producto producto;
    
    
    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDUSUARIOCOMPRADOR", nullable = false)
    private Usuario usuario;

    @Column(name = "CANTIDADACOMPRAR", nullable = false)
    private int cantidadacomprar;

    @Column(name = "PRECIOTOTAL", nullable = false)
    private int preciototal;

    @Column(name = "ESTADO", nullable = false, length = 50)
    private String estado;

    public Venta() {
	
	}

    public Venta(VentaId id, Producto producto, Usuario usuario, int cantidadacomprar, int preciototal, String estado) {
		super();
		this.id = id;
		this.producto = producto;
		this.usuario = usuario;
		this.cantidadacomprar = cantidadacomprar;
		this.preciototal = preciototal;
		this.estado = estado;
	}



	public VentaId getId() {
        return id;
    }

    public void setId(VentaId id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Usuario getIdusuariocomprador() {
        return usuario;
    }

    public void setIdusuariocomprador(Usuario idusuariocomprador) {
        this.usuario = idusuariocomprador;
    }

    public Integer getCantidadacomprar() {
        return cantidadacomprar;
    }

    public void setCantidadacomprar(Integer cantidadacomprar) {
        this.cantidadacomprar = cantidadacomprar;
    }

    public Integer getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(Integer preciototal) {
        this.preciototal = preciototal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}