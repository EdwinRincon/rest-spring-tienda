package com.formacion.app.apirest.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.app.apirest.entity.Compra;
import com.formacion.app.apirest.service.CompraServiceImpl;

@RestController
@RequestMapping("/compras")
public class CompraController {
	
	@Autowired
	CompraServiceImpl compraServiceImpl;

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCompra(@PathVariable long id) {
		Compra deleteCompra = null;
		Map<String, Object> response = new HashMap<>();
		try {
			deleteCompra = compraServiceImpl.deleteCompra(id);
		} catch (DataAccessException e) {
			// TODO: handle exception
			if (deleteCompra == null) {
				response.put("error2", "No existe la compra: " + id);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CONFLICT);
			}
			response.put("mensaje", "Error al eliminar la compra");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("compra", deleteCompra);
		response.put("mensaje", "Se ha eliminado exitosamente!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}
}
