package com.secondpawshop.init.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.secondpawshop.init.repository.ProductoRepository;
import com.secondpawshop.init.repository.UsuarioRepository;
import com.secondpawshop.init.entity.Producto;
import com.secondpawshop.init.entity.ProductoId;
import com.secondpawshop.init.entity.Usuario;
import com.secondpawshop.init.entity.dto.ProductoDto;
import com.secondpawshop.init.entity.dto.ProductoFullDto;

@Service
public class ProductService {
	
	final private ProductoRepository productoRepository;
	final private UsuarioRepository repoUsuario;
	
	public ProductService (ProductoRepository productoRepository, UsuarioRepository repoUsuario) {
		this.productoRepository = productoRepository;
		this.repoUsuario = repoUsuario;
	}
	
	public List<ProductoFullDto> getProductoPublicado () {
		List<Producto> productos = productoRepository.getProductoPublicado();
		List<ProductoFullDto> productosDto = convertProductoToProductoDto(productos);
		
		return productosDto;
	}
	
	public List <ProductoFullDto> getProductoVerificando () {
		
		List<Producto> productos = productoRepository.getProductoVerificando();
		List<ProductoFullDto> productosDto = convertProductoToProductoDto(productos);
		
		return productosDto;
	}
	
	public Producto crearProducto(ProductoDto p) {
		ProductoId productoPk = new ProductoId(p.getIdUsuarioFK(), p.getNombre());
		Optional<Usuario> usuario = repoUsuario.findById(p.getIdUsuarioFK());
		Producto producto = new Producto(productoPk, usuario.get(), p.getCategoria(),  p.getDescripcion(), p.getCantidad(), p.getPrecio(),
				 p.getImagen(), "VERIFICANDO");
		
		productoRepository.save(producto);
		return producto;
	}
	
	public List<ProductoFullDto> getProductFromCategory (String categoria) {
		
		List<Producto> productos = productoRepository.getProductoFromCategoria(categoria);
		List<ProductoFullDto> productosDto = convertProductoToProductoDto(productos);
		
		return productosDto;
	}
	
	public ProductoDto findByIdUsuarioFKAndNombre(ProductoId llaveCompuesta) {
		
		Optional<Producto> producto = productoRepository.findById(llaveCompuesta);
		ProductoDto productoDto = new ProductoDto();
		if (producto.isPresent()) {
			productoDto = new ProductoDto(producto.get().getId().getIdUsuariofk(), producto.get().getId().getNombre(),producto.get().getCategoria()
					, producto.get().getDescripcion(), producto.get().getCantidad(), producto.get().getPrecio(), producto.get().getImagen());
		}
		return productoDto;
	}
	
	public void actualizarProducto(ProductoId llaveCompuesta) {
		System.out.print("Hola" + llaveCompuesta.getIdUsuariofk());
		Optional<Producto> producto = productoRepository.findById(llaveCompuesta);
		
		System.out.print("Hola" + producto.get().toString());
		if (producto.isPresent()) {
			productoRepository.actualizarProducto(llaveCompuesta);
		}
		
    }
	
	private List<ProductoFullDto> convertProductoToProductoDto(List<Producto> productos) {
		
		List<ProductoFullDto> productosDto = productos.stream().map(Producto -> new ProductoFullDto(Producto.getId().getIdUsuariofk(), Producto.getId().getNombre()
						, Producto.getCategoria(), Producto.getDescripcion(), Producto.getCantidad(), Producto.getPrecio()
						, Producto.getImagen(), Producto.getEstado())).collect(Collectors.toList());
		
		return productosDto;
	}
	
	public void eliminarProducto (String idUsuarioFK, String nombre) {
		ProductoId llaveCompuesta = new ProductoId(idUsuarioFK, nombre);
		Optional<Producto> producto = productoRepository.findById(llaveCompuesta);
		
		if (producto.isPresent()) {
			productoRepository.deleteById(llaveCompuesta);
		}
		
	}

}
