package com.secondpawshop.init.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.secondpawshop.init.entity.view.VistaIdCarro;

@Repository
public interface IdCarroRepository extends JpaRepository <VistaIdCarro, String> {
	
	@Query (value = "SELECT IDVENTA FROM VISTAIDCARRO WHERE IDUSUARIOCOMPRADOR = :idUsuarioComprador", nativeQuery = true)
	String getIdCarro(@Param("idUsuarioComprador")String idUsuarioComprador);

}
