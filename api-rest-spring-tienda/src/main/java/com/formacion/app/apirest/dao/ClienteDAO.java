package com.formacion.app.apirest.dao;

import org.springframework.data.repository.CrudRepository;

import com.formacion.app.apirest.entity.Cliente;

public interface ClienteDAO extends CrudRepository<Cliente,Long> {

}
