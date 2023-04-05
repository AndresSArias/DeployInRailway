package com.secondpawshop.init.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.secondpawshop.init.entity.Producto;
import com.secondpawshop.init.entity.ProductoLlaveCompuesta;

@Repository
public interface ProductoRepository extends JpaRepository <Producto, ProductoLlaveCompuesta>{
	
	@Query (value = "INSERT INTO PRODUCTO (idUsuarioFK,nombre,categoria,descripcion,cantidad,precio,imagen,estado)"
			+" VALUES (:idUsuarioFK,:nombre,:categoria,:descripcion,:cantidad,:precio, :imagen,'VERIFICANDO')"
			,nativeQuery = true)
	void addProduct (String idUsuarioFK, String nombre, String categoria, String descripcion, int cantidad, int precio, String imagen);
	
	@Query (value = "SELECT * FROM PRODUCTO WHERE ESTADO = 'PUBLICADO'",nativeQuery = true)
	List<Producto> getProductoPublicado();
	
	@Query (value = "SELECT * FROM PRODUCTO WHERE ESTADO = 'VERIFICANDO'",nativeQuery = true)
	List<Producto> geProductoVerificando();
	 /*
	@Modifying
	@Query("UPDATE PRODUCTO P SET ESTADO = 'PUBLICADO' WHERE P.IDUSUARIOFK = :idUsuarioFK AND NOMBRE = :nombre")
	void actualizarProducto (@Param("idUsuarioFK") String idUsuarioFK, @Param("nombre") String nombre);
	*/

	default void actualizarProducto(ProductoLlaveCompuesta llave) {
	    Optional<Producto> productoOptional = this.findById(llave);
	    if (productoOptional.isPresent()) {
	        Producto producto = productoOptional.get();
	        producto.setEstado("PUBLICADO");
	        this.save(producto);
	    }
	}

	
	
}
