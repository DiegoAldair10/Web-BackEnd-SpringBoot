package com.bolsadeideas.springboot.backend.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Factura;

public interface IFacturaDao extends JpaRepository<Factura, Long> {

	
}

