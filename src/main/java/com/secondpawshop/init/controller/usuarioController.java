package com.secondpawshop.init.controller;

import org.springframework.web.bind.annotation.RestController;

import com.secondpawshop.init.service.UserService;
import com.secondpawshop.init.entity.ProductoId;
import com.secondpawshop.init.entity.Usuario;
import com.secondpawshop.init.entity.dto.UsuarioDto;
import com.secondpawshop.init.entity.dto.UsuarioLoginDto;
import com.secondpawshop.init.entity.dto.VentaHistorialDto;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin
public class usuarioController {
	final private UserService usuarioService;
	
	public usuarioController (UserService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@GetMapping ("/Usuarios")
	public List <Usuario> getUsuarios(){
		return usuarioService.getUsers();
	}
	
	@PostMapping("/Usuario/registrar")
	public ResponseEntity<Usuario> save(@RequestBody UsuarioDto c) {
		
		Usuario cliente = new Usuario (c.getIdUsuario(), c.getNombre(), c.getApellido()
				,c.getCorreo(),c.getCelular(), c.getDireccion(),c.getContrasena(), "CLIENTE");
		Optional<Usuario> usuario = usuarioService.registrar(cliente);
		if (usuario.isPresent()) {
			return new ResponseEntity<>(HttpStatus.CONFLICT );
		}else {
			usuarioService.save(cliente);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}

		
	}
	
	@PostMapping("/Usuario/login")
	public Usuario getCredencial (@RequestBody UsuarioLoginDto dataLogin) {
		return usuarioService.getLogin(dataLogin);
	}
	
	@GetMapping ("/Usuario/Historial/{idUsuario}")
	public List <VentaHistorialDto> getHistorial(@PathVariable String idUsuario){
		return usuarioService.getHistorial(idUsuario);
	}
	
	@GetMapping ("/Usuario/getRole/{id}")
	public ResponseEntity<String> getRole (@PathVariable String id){
		String role = usuarioService.getRole(id);
		if (role == null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}else {
			return new ResponseEntity<>(role, HttpStatus.OK);
		}
		
	}
	
	/////
	@GetMapping ("/prueba")
	public String getPrueba() {
		return "Hola Mundo deploy";
	}
	
	
	
	
	
	@PutMapping("/Usuario/Actualizar")
	public ResponseEntity<Void> actualizarUsuario(@RequestBody UsuarioDto usuarioActualizado) {
		usuarioService.actualizarUsuario(usuarioActualizado);
	    return ResponseEntity.noContent().build();
	}
	
	
	
}
