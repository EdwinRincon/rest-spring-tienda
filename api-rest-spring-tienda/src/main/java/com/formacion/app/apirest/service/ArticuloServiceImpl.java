package com.formacion.app.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacion.app.apirest.dao.ArticuloDAO;
import com.formacion.app.apirest.entity.Articulo;

@Service
public class ArticuloServiceImpl implements ArticuloService {

	@Autowired
	ArticuloDAO articuloDAO;
	
	@Transactional(readOnly=true)
	@Override
	public List<Articulo> getArticulos() {
		return (List<Articulo>) this.articuloDAO.findAll();
	}
	
	@Transactional(readOnly=true)
	@Override
	public Articulo getArticulo(long id) {
		return this.articuloDAO.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public Articulo postArticulo(Articulo articulo) {
		return this.articuloDAO.save(articulo);
	}
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Transactional
	@Override
	public Articulo deleteArticulo(long id) {
		Articulo deletedArticulo = this.articuloDAO.findById(id).orElse(null);
		this.articuloDAO.deleteById(id);
		return deletedArticulo;
	}

}
