package com.bolsadeideas.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Auto;

public interface IAutoDao extends JpaRepository<Auto, Long> {

	@Query("select p from Auto p where p.nombre like %?1%")
	public List<Auto> findByNombre(String term);

	public List<Auto> findByNombreContainingIgnoreCase(String term);

	public List<Auto> findByNombreStartingWithIgnoreCase(String term);

}
