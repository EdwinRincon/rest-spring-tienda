package com.formacion.app.apirest.dao;

import org.springframework.data.repository.CrudRepository;

import com.formacion.app.apirest.entity.Articulo;

public interface ArticuloDAO extends CrudRepository<Articulo,Long> {

}
