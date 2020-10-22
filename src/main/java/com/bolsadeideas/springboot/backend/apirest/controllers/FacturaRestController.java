package com.bolsadeideas.springboot.backend.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Auto;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Factura;
import com.bolsadeideas.springboot.backend.apirest.models.services.IClienteService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/sistema")
public class FacturaRestController {

	@Autowired
	private IClienteService clienteService;

	@GetMapping("/facturas")
	public List<Factura> index() {
		return clienteService.findAllFactura();
	}

	@GetMapping("/facturas/page/{page}")
	public Page<Factura> idnex(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 3);
		return clienteService.findAllFactura(pageable);
	}

	@GetMapping("/facturas/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Factura show(@PathVariable Long id) {
		return clienteService.findFacturaById(id);
	}

	@DeleteMapping("/facturas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clienteService.deleteFacturaById(id);
	}

	@GetMapping("/facturas/filtrar-autos/{term}")
	@ResponseStatus(HttpStatus.OK)
	public List<Auto> filtrarProductos(@PathVariable String term) {
		return clienteService.findAutoByNombre(term);
	}

	@PostMapping("/facturas")
	@ResponseStatus(HttpStatus.CREATED)
	public Factura crear(@RequestBody Factura factura) {
		return clienteService.saveFactura(factura);
	}
	
	
	@PutMapping("/facturas/{id}")
	public ResponseEntity <?> actualizar( @RequestBody Factura factura, BindingResult result, @PathVariable Long id) {
		
		Factura facturaActual = clienteService.findFacturaById(id);
		Factura facturaUpdate = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			List<String> erros = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("errors", erros);
			return new ResponseEntity <Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		if (facturaActual == null) {
			response.put("mensaje", "Error: no se pudo editar, la factura  ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			facturaActual.setDescripcion(factura.getDescripcion());
			facturaActual.setObservacion(factura.getObservacion());
			facturaActual.setFech_Alqui(factura.getFech_Alqui());
	
			facturaUpdate = clienteService.saveFactura(facturaActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la factura en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "La factura ha sido actualizado con éxito!");
		response.put("factura", facturaUpdate);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

}
