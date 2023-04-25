package com.secondpawshop.init.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.secondpawshop.init.entity.Producto;
import com.secondpawshop.init.entity.ProductoId;

import jakarta.transaction.Transactional;

@Repository
public interface ProductoRepository extends JpaRepository <Producto, ProductoId>{
	
	@Query (value = "SELECT * FROM producto WHERE ESTADO = 'PUBLICADO'",nativeQuery = true)
	List<Producto> getProductoPublicado();
	
	@Query (value = "SELECT * FROM producto WHERE ESTADO = 'VERIFICANDO'",nativeQuery = true)
	List<Producto> getProductoVerificando();
	
	@Query (value = "SELECT * FROM producto WHERE ESTADO = 'PUBLICADO' AND CATEGORIA =:categoria",nativeQuery = true)
	List<Producto> getProductoFromCategoria (String categoria);
	
	Optional<Producto> findById(ProductoId id);

	
	@Query (value = "INSERT INTO producto (idUsuarioFK,nombre,categoria,descripcion,cantidad,precio,imagen,estado)"
			+" VALUES (:idUsuarioFK,:nombre,:categoria,:descripcion,:cantidad,:precio, :imagen,'VERIFICANDO')"
			,nativeQuery = true)
	void addProduct (String idUsuarioFK, String nombre, String categoria, String descripcion, int cantidad, int precio, String imagen);
	
	
}
