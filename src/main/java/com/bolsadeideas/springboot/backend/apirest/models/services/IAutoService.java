package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Auto;

public interface IAutoService {
	
	public List<Auto> findAll();

	public Page<Auto> findAll(Pageable pageable);

	public Auto findById(Long id);

	public Auto save(Auto producto);

	public void delete(Long id);

}
