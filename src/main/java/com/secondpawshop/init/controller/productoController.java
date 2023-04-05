package com.secondpawshop.init.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.secondpawshop.init.service.ProductService;
import com.secondpawshop.init.entity.Producto;
import com.secondpawshop.init.entity.ProductoLlaveCompuesta;

@RestController
@CrossOrigin
public class productoController {
	
	final private ProductService productoService;
	
	public productoController (ProductService productoService) {
		this.productoService = productoService;
	}
	
	@GetMapping("/Producto/Publicado")
	public List <Producto> getProductosPublicados (){
		return productoService.getProductoPublicado();
	}

	@GetMapping("/Producto/Verificando")
	public List <Producto> geProductoVerificando (){
		return productoService.geProductoVerificando();
	}
	/*
	@PutMapping("/Producto/VerificandoToPublicado")
    public ResponseEntity<Void> actualizarCampo(@RequestBody String idUsuarioFK, @RequestBody String nombre) {
		productoService.actualizarProducto(idUsuarioFK, nombre);
        return ResponseEntity.noContent().build();
    }
	*/
	
	@PutMapping("/Producto/VerificandoToPublicado")
	public ResponseEntity<Void> actualizarProducto(@RequestBody ProductoLlaveCompuesta llaveCompuesta) {
		productoService.actualizarProducto(llaveCompuesta);
	    return ResponseEntity.noContent().build();
	}

}
