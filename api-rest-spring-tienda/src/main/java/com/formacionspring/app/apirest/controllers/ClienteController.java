package com.formacionspring.app.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.formacionspring.app.apirest.entity.Cliente;
import com.formacionspring.app.apirest.service.ClienteService;

public class ClienteController {
	
	@Autowired
	private ClienteService servicio;
	
	@GetMapping("/clientes")
	public List<Cliente> cliente(){
		return null;
	}
	
	@GetMapping("/clientes/{id}")
	public ResponseEntity<?> clienteShow(@PathVariable Long id){
		Cliente cliente = null;
		Map<String,Object> response = new HashMap<>();
		
		try{
			
			cliente = servicio.findById(id);
			
		} catch(DataAccessException e){
			response.put("mensaje", "Error al realizar consulta a la base de datos");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(cliente == null) {
			response.put("mensaje", "El cliente ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
	}
	
	@PostMapping("/clientes")
	public ResponseEntity<?> saveCliente( @RequestBody Cliente cliente){
		
		Cliente clienteNew = null;		
		Map<String,Object> response = new HashMap<>();
		
		try{
			
			clienteNew = servicio.save(cliente);
			
		} catch(DataAccessException e){
			response.put("mensaje", "Error al realizar insert a la base de datos");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El cliente ha sido creado con exito!");
		response.put("cliente", clienteNew);
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/clientes/{id}")
	public ResponseEntity<?> updateCliente(@RequestBody Cliente cliente,@PathVariable Long id) {
		
		Cliente clienteUpdate = servicio.findById(id);
			
		Map<String,Object> response = new HashMap<>();
		
		try{
			
			clienteUpdate.setNombre(cliente.getNombre());
			clienteUpdate.setApellido(cliente.getApellido());
			clienteUpdate.setEmail(cliente.getEmail());
			clienteUpdate.setTelefono(cliente.getTelefono());
			clienteUpdate.setRegion(cliente.getRegion());
			
			servicio.save(clienteUpdate);
			
		} catch(DataAccessException e){
			response.put("mensaje", "Error al realizar actualizar la base de datos");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El cliente ha sido actualizado con exito!");
		response.put("cliente", clienteUpdate);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	}

}
