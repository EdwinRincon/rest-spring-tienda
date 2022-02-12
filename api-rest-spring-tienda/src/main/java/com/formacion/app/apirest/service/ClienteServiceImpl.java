package com.formacion.app.apirest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacion.app.apirest.dao.ClienteDAO;
import com.formacion.app.apirest.entity.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteDAO clienteDAO;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Transactional
	@Override
	public Cliente deleteCliente(long id) {
		Cliente deletedCliente = this.clienteDAO.findById(id).orElse(null);
		this.clienteDAO.deleteById(id);
		return deletedCliente;
	}
}
