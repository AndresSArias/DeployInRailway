package com.secondpawshop.init.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.secondpawshop.init.entity.Usuario;
import com.secondpawshop.init.entity.Venta;
import com.secondpawshop.init.entity.VentaId;

import jakarta.transaction.Transactional;

import org.springframework.data.repository.query.Param;

@Repository
public interface VentaRepository extends JpaRepository <Venta, VentaId> {

	@Query (value = "INSERT INTO VENTA (idVenta,idUsuarioPropetario,nombreProducto,idUsuarioComprador,cantidadAComprar,precioTotal,estado)"
			+ " VALUES (:idVenta,:idUsuarioPropetario,:nombreProducto,:idUsuarioComprador,:cantidadAComprar,:precioTotal,'CARRO')"
			,nativeQuery = true)
	
	void addVenta (String idVenta, String idUsuarioPropetario, String nombreProducto, String idUsuarioComprador, int cantidadAComprar, int precioTotal);
}
