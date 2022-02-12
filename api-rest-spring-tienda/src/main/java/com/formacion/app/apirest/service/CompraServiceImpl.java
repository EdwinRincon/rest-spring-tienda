package com.formacion.app.apirest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacion.app.apirest.dao.CompraDAO;
import com.formacion.app.apirest.entity.Compra;

@Service
public class CompraServiceImpl implements CompraService {
	
	@Autowired
	CompraDAO compraDAO;

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Transactional
	@Override
	public Compra deleteCompra(long id) {
		Compra deletedCompra = this.compraDAO.findById(id).orElse(null);
		this.compraDAO.deleteById(id);
		return deletedCompra;
	}
}
