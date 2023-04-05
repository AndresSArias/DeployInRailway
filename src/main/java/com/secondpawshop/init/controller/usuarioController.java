package com.secondpawshop.init.controller;

import org.springframework.web.bind.annotation.RestController;

import com.secondpawshop.init.service.UserService;
import com.secondpawshop.init.entity.Usuario;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

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
	
	@GetMapping ("/prueba")
	public String getPrueba() {
		return "Hola Mundo deploy";
	}
}
