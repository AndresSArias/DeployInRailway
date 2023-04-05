package com.secondpawshop.init.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.secondpawshop.init.repository.UsuarioRepository;
import com.secondpawshop.init.entity.Usuario;

@Service
public class UserService {
	
	final private UsuarioRepository usuarioRepository;
	
	public UserService (UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public List <Usuario> getUsers (){
		return usuarioRepository.getUsuarios();
	}
	
	
}
