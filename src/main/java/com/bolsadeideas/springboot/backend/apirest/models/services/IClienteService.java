package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Alquiler;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Auto;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Cliente;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Distrito;

public interface IClienteService {

	public List<Cliente> findAll();

	public Page<Cliente> findAll(Pageable pageable);

	public Cliente findById(Long id);

	public Cliente save(Cliente cliente);

	public void delete(Long id);

	// Distrito
	public List<Distrito> finAllDistritos();

	// Alquiler

	public Alquiler findAlquilerById(Long id);

	public Alquiler saveAlquiler(Alquiler alquiler);

	public Void deleteAlquilerByid(Long id);

	// Busqueda de Autos

	public List<Auto> findAutoByNombre(String term);
}
