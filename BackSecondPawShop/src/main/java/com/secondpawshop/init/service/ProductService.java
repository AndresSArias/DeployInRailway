package com.secondpawshop.init.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.secondpawshop.init.repository.ProductoRepository;
import com.secondpawshop.init.entity.Producto;
import com.secondpawshop.init.entity.ProductoLlaveCompuesta;

@Service
public class ProductService {
	
	final private ProductoRepository productoRepository;
	
	public ProductService (ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}
	
	public List <Producto> getProductoPublicado () {
		return productoRepository.getProductoPublicado();
	}

	public List <Producto> geProductoVerificando () {
		return productoRepository.geProductoVerificando();
	}
	
	public void actualizarProducto(ProductoLlaveCompuesta llaveCompuesta) {
		productoRepository.actualizarProducto(llaveCompuesta);
    }
	

	
}
