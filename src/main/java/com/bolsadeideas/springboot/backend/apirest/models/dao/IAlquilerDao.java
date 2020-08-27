package com.bolsadeideas.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Alquiler;

public interface IAlquilerDao extends CrudRepository<Alquiler, Long>{

}
