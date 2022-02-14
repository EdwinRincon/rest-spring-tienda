package com.formacion.app.apirest.controller;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.app.apirest.entity.Articulo;
import com.formacion.app.apirest.service.ArticuloServiceImpl;

@RestController
@RequestMapping("/articulos")
public class ArticuloController {

	@Autowired
	ArticuloServiceImpl articuloServiceImpl;
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Articulo>> getAllArticulos() {
		return new ResponseEntity<>(articuloServiceImpl.getArticulos(), HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getArticulo(@PathVariable Long id) {
		Articulo articulo = null;
		Map<String, Object> response = new HashMap<>();
		try {
			articulo = articuloServiceImpl.getArticulo(id);
		} catch (DataAccessException e) {
			// TODO: handle exception
			response.put("mensaje", "Error al realizar consulta a la base de datos");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (articulo == null) {
			response.put("mensaje", "El articulo ID: " + id.toString() + " no existe en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Articulo>(articulo, HttpStatus.OK);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@PostMapping("")
	public ResponseEntity<?> postArticulo(@RequestBody Articulo articulo) {
		Articulo newArticulo = null;
		Map<String, Object> response = new HashMap<>();
		try {
			newArticulo = articuloServiceImpl.postArticulo(articulo);
		} catch (DataAccessException e) {
			// TODO: handle exception
			response.put("mensaje", "Error al guardar en la base de datos");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (newArticulo == null) {
			response.put("mensaje", "El articulo: " + articulo.getNombre() + " no se ha guardado en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CONFLICT);
		}
		response.put("articulo", newArticulo);
		response.put("mensaje", "Se ha guardado exitosamente!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteArticulo(@PathVariable long id) {
		Articulo deleteArticulo = null;
		Map<String, Object> response = new HashMap<>();
		try {
			deleteArticulo = articuloServiceImpl.deleteArticulo(id);
			deleteLocalImage(deleteArticulo);
		} catch (DataAccessException e) {
			// TODO: handle exception
			if (deleteArticulo == null) {
				response.put("error2", "No existe el articulo: " + id);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CONFLICT);
			}
			response.put("mensaje", "Error al eliminar al articulo");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("articulo", deleteArticulo);
		response.put("mensaje", "Se ha eliminado exitosamente!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}
	
	
	// Elimina las imagenes de la carpeta /uploads
	private void deleteLocalImage(Articulo articulo) {
		String oldImage = articulo.getImagen();
		
		if(oldImage != null && oldImage.length()>0) {
			Path pathOldImage = Paths.get("uploads").resolve(oldImage).toAbsolutePath();
			File fileOldImage = pathOldImage.toFile();
			
			if(fileOldImage.exists() && fileOldImage.canRead()) {
				fileOldImage.delete();
			}
		}
	}
	
	// Devuelve una imagen
	@GetMapping("download/img/{nombreImagen:.+}")
	public ResponseEntity<Resource> getImagen(@PathVariable String nombreImagen){
		Path rutaArchivo = Paths.get("uploads").resolve(nombreImagen).toAbsolutePath();
		Resource recurso = null;
			
		try {
			recurso = new UrlResource(rutaArchivo.toUri());
		} catch (MalformedURLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
			
		if(!recurso.exists() && !recurso.isReadable()) {
			throw new RuntimeException("Error no se puede cargar la imagen "+ nombreImagen);
		}
			
		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\""+recurso.getFilename());
			
			
		return new ResponseEntity<Resource>(recurso,cabecera,HttpStatus.OK);
		}
}
