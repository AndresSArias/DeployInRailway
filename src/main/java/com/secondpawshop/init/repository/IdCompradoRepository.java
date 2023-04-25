package com.secondpawshop.init.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.secondpawshop.init.entity.view.VistaIdComprado;

@Repository
public interface IdCompradoRepository extends JpaRepository <VistaIdComprado, String> {
	
	@Query (value = "SELECT IDVENTA FROM vistaidcarro WHERE IDUSUARIOCOMPRADOR = :idUsuarioComprador", nativeQuery = true)
	String getIdComprado(@Param("idUsuarioComprador")String idUsuarioComprador);

}