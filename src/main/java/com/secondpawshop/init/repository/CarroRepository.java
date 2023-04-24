package com.secondpawshop.init.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.secondpawshop.init.entity.view.ViewCarrito;


@Repository
public interface CarroRepository extends JpaRepository <ViewCarrito, String> {
		
	@Query (value = "SELECT * FROM VISTACARRO WHERE IDUSUARIOCOMPRADOR = :idUsuarioComprador", nativeQuery = true)
	List <ViewCarrito> getCarro(@Param("idUsuarioComprador")String idUsuarioComprador);
	
}
