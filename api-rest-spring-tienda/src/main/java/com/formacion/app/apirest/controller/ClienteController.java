package com.formacion.app.apirest.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.app.apirest.entity.Cliente;
import com.formacion.app.apirest.service.ClienteServiceImpl;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	ClienteServiceImpl clienteServiceImpl;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@PostMapping("")
	public ResponseEntity<?> postCliente(@RequestBody Cliente cliente) {
		Cliente newCliente = null;
		Map<String, Object> response = new HashMap<>();
		try {
			newCliente = clienteServiceImpl.postCliente(cliente);
		} catch (DataAccessException e) {
			// TODO: handle exception
			response.put("mensaje", "Error al guardar en la base de datos");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (newCliente == null) {
			response.put("mensaje", "El cliente: " + cliente.getNombre()+" "+cliente.getApellidos() + " no se ha guardado en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CONFLICT);
		}
		response.put("cliente", newCliente);
		response.put("mensaje", "Se ha guardado exitosamente!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCliente(@PathVariable long id) {
		Cliente deleteCliente = null;
		Map<String, Object> response = new HashMap<>();
		try {
			deleteCliente = clienteServiceImpl.deleteCliente(id);
		} catch (DataAccessException e) {
			// TODO: handle exception
			if (deleteCliente == null) {
				response.put("error2", "No existe el usuario: " + id);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CONFLICT);
			}
			response.put("mensaje", "Error al eliminar al usuario");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("cliente", deleteCliente);
		response.put("mensaje", "Se ha eliminado exitosamente!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}
}