package com.secondpawshop.init.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.secondpawshop.init.entity.PRODUCTO;
import com.secondpawshop.init.entity.ProductoId;

import jakarta.transaction.Transactional;

@Repository
public interface ProductoRepository extends JpaRepository <PRODUCTO, ProductoId>{
	
	@Query (value = "SELECT * FROM PRODUCTO WHERE ESTADO = 'PUBLICADO'",nativeQuery = true)
	List<PRODUCTO> getProductoPublicado();
	
	@Query (value = "SELECT * FROM PRODUCTO WHERE ESTADO = 'VERIFICANDO'",nativeQuery = true)
	List<PRODUCTO> getProductoVerificando();
	
	@Query (value = "SELECT * FROM PRODUCTO WHERE ESTADO = 'PUBLICADO' AND CATEGORIA =:categoria",nativeQuery = true)
	List<PRODUCTO> getProductoFromCategoria (String categoria);
	
	Optional<PRODUCTO> findById(ProductoId id);
	
	///////////////
	@Transactional
	@Modifying
	@Query("UPDATE Producto p SET p.estado = 'PUBLICADO' WHERE p.id = :productoId")
	void actualizarProducto(@Param("productoId") ProductoId productoId);

	///////////////
	
	@Query (value = "INSERT INTO PRODUCTO (idUsuarioFK,nombre,categoria,descripcion,cantidad,precio,imagen,estado)"
			+" VALUES (:idUsuarioFK,:nombre,:categoria,:descripcion,:cantidad,:precio, :imagen,'VERIFICANDO')"
			,nativeQuery = true)
	void addProduct (String idUsuarioFK, String nombre, String categoria, String descripcion, int cantidad, int precio, String imagen);
	
	
	 /*
	@Transactional
	@Modifying
	@Query("UPDATE PRODUCTO P SET ESTADO = 'PUBLICADO' WHERE P.IDUSUARIOFK = :idUsuarioFK AND NOMBRE = :nombre")
	void actualizarProducto (@Param("idUsuarioFK") String idUsuarioFK, @Param("nombre") String nombre);
	*/


	


	
	//Optional<Producto> findByIdUsuarioFKAndNombre(String idUsuarioFK, String nombre);
}
