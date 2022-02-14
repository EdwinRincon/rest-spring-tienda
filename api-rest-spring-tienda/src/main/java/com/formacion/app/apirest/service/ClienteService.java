package com.formacion.app.apirest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.formacion.app.apirest.entity.Cliente;

@Service
public interface ClienteService {

	List<Cliente> getClientes();

	Cliente getCliente(long id);

	Cliente postCliente(Cliente cliente);
	
	
	
	
	Cliente deleteCliente(long id);
}
