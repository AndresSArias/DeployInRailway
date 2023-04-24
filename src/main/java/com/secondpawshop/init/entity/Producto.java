package com.secondpawshop.init.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {
    @EmbeddedId
    private ProductoId id;
    
    
    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDUSUARIOFK", nullable = false)
    private Usuario usuario;

    @Column(name = "CATEGORIA", nullable = false, length = 10)
    private String categoria;

    @Column(name = "DESCRIPCION", nullable = false, length = 200)
    private String descripcion;

    @Column(name = "CANTIDAD", nullable = false)
    private int cantidad;

    @Column(name = "PRECIO", nullable = false)
    private int precio;

    @Column(name = "IMAGEN", nullable = false, length = 200)
    private String imagen;

    @Column(name = "ESTADO", nullable = false, length = 15)
    private String estado;
    
    public Producto() {
	
	}

	public Producto(ProductoId id, Usuario usuario, String categoria, String descripcion, int cantidad, int precio,
			String imagen, String estado) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.precio = precio;
		this.imagen = imagen;
		this.estado = estado;
	}

	public ProductoId getId() {
		return id;
	}

	public void setId(ProductoId id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}