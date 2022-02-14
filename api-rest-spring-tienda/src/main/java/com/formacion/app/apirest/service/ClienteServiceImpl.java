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
	public Cliente putCliente(Cliente cliente, long id) {
		Cliente toUpdateCliente = getCliente(id);

		if (toUpdateCliente == null)
			return null;

		toUpdateCliente.setNombre(cliente.getNombre());
		toUpdateCliente.setApellidos(cliente.getApellidos());
		toUpdateCliente.setEmpresa(cliente.getEmpresa());
		toUpdateCliente.setPuesto(cliente.getPuesto());
		toUpdateCliente.setCp(cliente.getCp());
		toUpdateCliente.setProvincia(cliente.getProvincia());
		toUpdateCliente.setTelefono(cliente.getTelefono());
		toUpdateCliente.setFechaNacimiento(cliente.getFechaNacimiento());
		return this.clienteDAO.save(toUpdateCliente);
	}
	
	@Transactional
	@Override
	public Cliente postCliente(Cliente cliente) {
		return this.clienteDAO.save(cliente);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Transactional
	@Override
	public Cliente deleteCliente(long id) {
		Cliente deletedCliente = this.clienteDAO.findById(id).orElse(null);
		this.clienteDAO.deleteById(id);
		return deletedCliente;
	}
}
