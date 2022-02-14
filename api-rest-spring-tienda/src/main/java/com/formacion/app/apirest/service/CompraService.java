package com.formacion.app.apirest.service;

import org.springframework.stereotype.Service;

import com.formacion.app.apirest.entity.Compra;

@Service
public interface CompraService {

	
	
	
	
	
	
	Compra postCompra(Compra compra);
	
	Compra putCompra(Compra compra, long id);	
		
	
	Compra deleteCompra(long id);
}
