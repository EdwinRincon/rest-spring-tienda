package com.formacion.app.apirest.service;

import org.springframework.stereotype.Service;

import com.formacion.app.apirest.entity.Cliente;

@Service
public interface ClienteService {

	
	
	
	
	
	
	
	Cliente postCliente(Cliente cliente);
	
	
	
	
	
	
	Cliente deleteCliente(long id);
}
