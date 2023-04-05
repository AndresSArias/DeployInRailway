package com.secondpawshop.init.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.secondpawshop.init.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, String>{
	
	Optional<Usuario> findByIdUsuario (String idUsuario);
	
	@Query (value = "SELECT * FROM usuario", nativeQuery = true)
	List<Usuario> getUsuarios();
	
}
