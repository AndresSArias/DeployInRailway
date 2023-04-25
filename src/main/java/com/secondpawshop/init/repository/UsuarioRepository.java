package com.secondpawshop.init.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.secondpawshop.init.entity.PRODUCTO;
import com.secondpawshop.init.entity.Usuario;
import com.secondpawshop.init.entity.dto.UsuarioDto;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, String>{
	
	@Query (value = "SELECT * FROM usuario", nativeQuery = true)
	List<Usuario> getUsuarios();


	default void actualizarUsuario(UsuarioDto usuarioActualizado) {
		
		Optional<Usuario> usuarioOptional = this.findById(usuarioActualizado.getIdUsuario());
	    if (usuarioOptional.isPresent()) {
	        Usuario usuario = usuarioOptional.get();
	        usuario.setNombre(usuarioActualizado.getNombre());
	        usuario.setApellido(usuarioActualizado.getApellido());
	        usuario.setCorreo(usuarioActualizado.getCorreo());
	        usuario.setCelular(usuarioActualizado.getCelular());
	        usuario.setDireccion(usuarioActualizado.getDireccion());
	        this.save(usuario);
	    }
		
	}

	
	
}
