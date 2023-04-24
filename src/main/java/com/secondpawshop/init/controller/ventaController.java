package com.secondpawshop.init.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.secondpawshop.init.entity.ProductoId;
import com.secondpawshop.init.entity.Venta;
import com.secondpawshop.init.entity.VentaId;
import com.secondpawshop.init.entity.dto.UsuarioDto;
import com.secondpawshop.init.entity.dto.VentaCarroBackendDto;
import com.secondpawshop.init.entity.dto.VentaCarroDto;
import com.secondpawshop.init.entity.dto.VentaDto;
import com.secondpawshop.init.entity.dto.VentaHistorialDto;
import com.secondpawshop.init.service.VentaService;

@RestController
@CrossOrigin
public class ventaController {
	
	final private VentaService ventaService;

	public ventaController(VentaService ventaService) {
		this.ventaService = ventaService;
	}
	
	@PostMapping("/Venta/AgregarAlCarro")
	public ResponseEntity<Venta> agregarAlCarro (@RequestBody VentaDto venta ){
		
		return new ResponseEntity<>(ventaService.agregarAlCarro(venta), HttpStatus.CREATED);
	}
	

	
	@PutMapping("/Venta/Carro/Cancelar")
	public ResponseEntity<Void> actualizarProducto(@RequestBody VentaCarroBackendDto VentaCancelarCarroDto) {		
		ventaService.cancelarProductoEnCarrito(VentaCancelarCarroDto);
	    return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/Venta/Carro/Comprar")
	public ResponseEntity<Void> comprarProductos(@RequestBody VentaCarroBackendDto VentaComprarCarroDto) {		
		ventaService.comprarProductoEnCarrito(VentaComprarCarroDto);
	    return ResponseEntity.noContent().build();
	}
	
	@GetMapping ("/Venta/Carro/{idUsuario}")
	public List <VentaCarroDto> getHistorial(@PathVariable String idUsuario){
		return ventaService.getCarro(idUsuario);
	}
	
}
