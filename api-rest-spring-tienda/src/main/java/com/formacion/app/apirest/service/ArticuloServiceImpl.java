package com.formacion.app.apirest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacion.app.apirest.dao.ArticuloDAO;
import com.formacion.app.apirest.entity.Articulo;

@Service
public class ArticuloServiceImpl implements ArticuloService {

	@Autowired
	ArticuloDAO articuloDAO;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Transactional
	@Override
	public Articulo deleteArticulo(long id) {
		Articulo deletedArticulo = this.articuloDAO.findById(id).orElse(null);
		this.articuloDAO.deleteById(id);
		return deletedArticulo;
	}

}
