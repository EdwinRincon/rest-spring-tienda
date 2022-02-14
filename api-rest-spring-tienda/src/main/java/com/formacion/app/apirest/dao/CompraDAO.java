package com.formacion.app.apirest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacion.app.apirest.entity.Compra;

@Repository
public interface CompraDAO extends CrudRepository<Compra,Long>{
	@Query(value = "SELECT * FROM COMPRAS WHERE COD_CLIENTE = ?1", nativeQuery = true)
	  List<Compra> getComprasCliente(long codCliente);
}
