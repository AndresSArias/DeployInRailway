package com.secondpawshop.init.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.secondpawshop.init.service.ProductService;
import com.secondpawshop.init.entity.PRODUCTO;
import com.secondpawshop.init.entity.ProductoId;
import com.secondpawshop.init.entity.dto.ProductoDto;
import com.secondpawshop.init.entity.dto.ProductoFullDto;

@RestController
@CrossOrigin
public class productoController {
	
	final private ProductService productoService;
	
	public productoController (ProductService productoService) {
		this.productoService = productoService;
	}
	
	@GetMapping("/Producto/Publicado")
	public List <ProductoFullDto> getProductosPublicados (){
		return productoService.getProductoPublicado();
	}
	
	@GetMapping("/Producto/Verificando")
	public List <ProductoFullDto> getProductoVerificando (){
		return productoService.getProductoVerificando();
	}
	
	@PostMapping("/Producto/Crear")
	public ResponseEntity<PRODUCTO> crearProducto (@RequestBody ProductoDto p ){
		return new ResponseEntity<>(productoService.crearProducto(p), HttpStatus.CREATED);
	}
	
	@GetMapping("/Producto/{categoria}")
	public List <ProductoFullDto> getProductFromCategory (@PathVariable ("categoria")String categoria){
		return productoService.getProductFromCategory(categoria);
	}
	
	@PostMapping("/Producto")
	public ResponseEntity<ProductoDto> getProducto(@RequestBody ProductoId llaveCompuesta) {
		ProductoDto cliente = productoService.findByIdUsuarioFKAndNombre(llaveCompuesta);
		return new ResponseEntity<ProductoDto>(cliente, HttpStatus.OK);
	}
	
	@PutMapping("/Producto/VerificandoToPublicado")
	public ResponseEntity<Void> actualizarProducto(@RequestBody ProductoId llaveCompuesta) {		
		productoService.actualizarProducto(llaveCompuesta);
	    return ResponseEntity.noContent().build();
	}	
	
	@DeleteMapping("Producto/Eliminar/{idUsuarioFK}/{nombre}")
    public void eliminarProducto(@PathVariable("idUsuarioFK") String idUsuarioFK, @PathVariable("nombre") String nombre) {
        productoService.eliminarProducto(idUsuarioFK, nombre);
    }
}
