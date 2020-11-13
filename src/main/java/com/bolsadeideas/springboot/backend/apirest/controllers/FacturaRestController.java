package com.bolsadeideas.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/facturas/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Factura show(@PathVariable Long id) {
		return clienteService.findFacturaById(id);
	}

	@Secured({"ROLE_ADMIN"})
	@DeleteMapping("/facturas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clienteService.deleteFacturaById(id);
	}
	@Secured({ "ROLE_ADMIN" })
	@GetMapping("/facturas/filtrar-autos/{term}")
	@ResponseStatus(HttpStatus.OK)
	public List<Auto> filtrarProductos(@PathVariable String term) {
		return clienteService.findAutoByNombre(term);
	}

	@Secured({"ROLE_ADMIN"})
	@PostMapping("/facturas")
	@ResponseStatus(HttpStatus.CREATED)
	public Factura crear(@RequestBody Factura factura) {
		return clienteService.saveFactura(factura);
	}
	

}
