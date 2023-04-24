package com.secondpawshop.init.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.secondpawshop.init.repository.HistorialRepository;
//import com.secondpawshop.init.repository.HistorialRepository;
import com.secondpawshop.init.repository.UsuarioRepository;
import com.secondpawshop.init.entity.Usuario;
import com.secondpawshop.init.entity.dto.UsuarioDto;
import com.secondpawshop.init.entity.dto.UsuarioLoginDto;
import com.secondpawshop.init.entity.dto.VentaHistorialDto;
import com.secondpawshop.init.entity.view.ViewHistorial;

@Service
public class UserService {
	
	final private UsuarioRepository usuarioRepository;
	final private HistorialRepository historialRepository;
	
	public UserService (UsuarioRepository usuarioRepository, HistorialRepository historialRepository) {
		this.usuarioRepository = usuarioRepository;
		this.historialRepository = historialRepository;
	}
	
	public List <Usuario> getUsers (){
		return usuarioRepository.getUsuarios();
	}
	
	public void save(Usuario cliente) {
		usuarioRepository.save(cliente);
	}
	
	public List<VentaHistorialDto> getHistorial (String idUsuario) {
		
		List<ViewHistorial> historial = historialRepository.getHistorial(idUsuario);
		List<VentaHistorialDto> historialDto = generarHistorialDto(historial);
		return historialDto;

	}
	
	private List<VentaHistorialDto> generarHistorialDto(List<ViewHistorial> historial) {
		
		List<VentaHistorialDto> historialDto = new ArrayList<VentaHistorialDto>();
		
		for (int i = 0; i < historial.size(); i++) {
			historialDto.add(new VentaHistorialDto (historial.get(i).getImagen(),historial.get(i).getNombre(), historial.get(i).getCategoria()
					,historial.get(i).getDescripcion(), historial.get(i).getCantidadAComprar(), historial.get(i).getPrecioTotal()));
		}
		
		return historialDto;
	}
	
	
	public Usuario getLogin (UsuarioLoginDto dataLogin) {
		
		Optional<Usuario> usuario = usuarioRepository.findById(dataLogin.getIdUsuario());
		if (usuario.isPresent()) {
			if (usuario.get().getContrasena().equals(dataLogin.getContrasena())){
				return usuario.get();
			}
		}
		return null;
	}

	public void actualizarUsuario(UsuarioDto usuarioActualizado) {
		usuarioRepository.actualizarUsuario(usuarioActualizado);
		
	}

	public Optional<Usuario> registrar(Usuario c) {
		return usuarioRepository.findById(c.getId());
	}

	public String getRole(String id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		if (usuario.isPresent()) {
			return usuario.get().getRol();
		}
		
		return null;
	}

	
	

	
	
	
	
	
	
}
