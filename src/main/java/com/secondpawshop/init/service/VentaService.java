package com.secondpawshop.init.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.secondpawshop.init.entity.Producto;
import com.secondpawshop.init.entity.ProductoId;
import com.secondpawshop.init.entity.Usuario;
import com.secondpawshop.init.entity.Venta;
import com.secondpawshop.init.entity.VentaId;
import com.secondpawshop.init.entity.dto.VentaCarroBackendDto;
import com.secondpawshop.init.entity.dto.VentaCarroDto;
import com.secondpawshop.init.entity.dto.VentaDto;
import com.secondpawshop.init.entity.dto.VentaHistorialDto;
import com.secondpawshop.init.entity.view.ViewCarrito;
import com.secondpawshop.init.entity.view.ViewHistorial;
import com.secondpawshop.init.repository.CarroRepository;
import com.secondpawshop.init.repository.IdCarroRepository;
import com.secondpawshop.init.repository.IdCompradoRepository;
import com.secondpawshop.init.repository.ProductoRepository;
import com.secondpawshop.init.repository.UsuarioRepository;
import com.secondpawshop.init.repository.VentaRepository;
@Service
public class VentaService {
	
	final private VentaRepository ventaRepository;
	final private ProductoRepository repoProducto;
	final private UsuarioRepository repoUsuario;
	final private IdCarroRepository repoIdCarro;
	final private IdCompradoRepository repoIdComprado;
	final private CarroRepository	repoCarro;
	public VentaService(VentaRepository ventaRepository, ProductoRepository repoProducto, UsuarioRepository repoUsuario, IdCarroRepository repoIdCarro, IdCompradoRepository repoIdComprado, CarroRepository repoCarro) {
		this.ventaRepository = ventaRepository;
		this.repoProducto = repoProducto;
		this.repoUsuario = repoUsuario;
		this.repoIdCarro = repoIdCarro;
		this.repoIdComprado = repoIdComprado;
		this.repoCarro = repoCarro;
	}

	public Venta agregarAlCarro(VentaDto ventaDto) {
		
		VentaId id = new VentaId(traerIdVenta(ventaDto.getIdUsuarioComprador()), ventaDto.getIdUsuarioPropetario(),ventaDto.getNombreProducto(),
				ventaDto.getIdUsuarioComprador());
		
		ProductoId productoId = new ProductoId(ventaDto.getIdUsuarioPropetario(), ventaDto.getNombreProducto());
		Optional<Producto> producto = repoProducto.findById(productoId);
		
		Optional<Usuario> usuario = repoUsuario.findById(ventaDto.getIdUsuarioComprador());
		
		Venta venta = new Venta(id,  producto.get(),  usuario.get(), ventaDto.getCantidadAComprar(), ventaDto.getPrecioTotal(), "CARRO");
		
		ventaRepository.save(venta);
		
		return venta;
	}
	
	private String traerIdVenta(String idUsuarioComprador) {
		
		String idVenta = repoIdCarro.getIdCarro(idUsuarioComprador);
		
		if (idVenta == null) {
			idVenta = repoIdComprado.getIdComprado(idUsuarioComprador);
			
			if (idVenta == null) {
				idVenta = "1";
			}else {
				idVenta = ""+ (Integer. parseInt(idVenta)+1);
			}
			
			
		}
		return idVenta;
	}

	public void cancelarProductoEnCarrito(VentaCarroBackendDto ventaCancelarCarroDto) {
		
		String IdVenta = repoIdCarro.getIdCarro(ventaCancelarCarroDto.getIdusuariocomprador());
		
		VentaId id = new VentaId (IdVenta, ventaCancelarCarroDto.getIdusuariopropetario(), ventaCancelarCarroDto.getNombreproducto(),ventaCancelarCarroDto.getIdusuariocomprador());
		
		Optional<Venta> ventaOptional = ventaRepository.findById(id);
		
		if (ventaOptional.isPresent()) {
	        Venta venta = ventaOptional.get();
	        venta.setEstado("CANCELADO");
	        ventaRepository.save(venta);
	    }
	}

	public void comprarProductoEnCarrito(VentaCarroBackendDto ventaComprarCarroDto) {
		
		String IdVenta = repoIdCarro.getIdCarro(ventaComprarCarroDto.getIdusuariocomprador());
		
		VentaId id = new VentaId (IdVenta, ventaComprarCarroDto.getIdusuariopropetario(), ventaComprarCarroDto.getNombreproducto()
				,ventaComprarCarroDto.getIdusuariocomprador());
		
		Optional<Venta> ventaOptional = ventaRepository.findById(id);
		
		if (ventaOptional.isPresent()) {
	        Venta venta = ventaOptional.get();
	        venta.setEstado("COMPRADO");
	        ventaRepository.save(venta);
	    }
	}

	public List<VentaCarroDto> getCarro(String idUsuario) {
		List<ViewCarrito> carro = repoCarro.getCarro(idUsuario);
		List<VentaCarroDto> carroDto = generarHistorialDto(carro);
		return carroDto;
	}

	private List<VentaCarroDto> generarHistorialDto(List<ViewCarrito> carro) {
		
		List<VentaCarroDto> carroDto = new ArrayList<VentaCarroDto>();
		
		for (int i = 0; i < carro.size(); i++) {
			carroDto.add(new VentaCarroDto (carro.get(i).getImagen(),carro.get(i).getNombreproducto(), carro.get(i).getCantidadacomprar()
					,carro.get(i).getPrecio(), carro.get(i).getPreciototal(),carro.get(i).getIdUsuarioPropietario()));
		}
		
		return carroDto;
	}
	
}
