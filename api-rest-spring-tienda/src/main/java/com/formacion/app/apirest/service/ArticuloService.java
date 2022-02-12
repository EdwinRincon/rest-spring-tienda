package com.formacion.app.apirest.service;

import org.springframework.stereotype.Service;

import com.formacion.app.apirest.entity.Articulo;

@Service
public interface ArticuloService {

	
	
	
	
	
	Articulo postArticulo(Articulo articulo);
	
	
	
	
	
	Articulo deleteArticulo(long id);
}
