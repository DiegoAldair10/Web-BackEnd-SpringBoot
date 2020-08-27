package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.backend.apirest.models.dao.IClienteDao;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Alquiler;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Auto;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Cliente;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Distrito;

@Service
public class IClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {

		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> findAll(Pageable pageable) {
		return clienteDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente save(Cliente producto) {
		return clienteDao.save(producto);
	}

	@Override
	@Transactional
	public void delete(Long id) {

		clienteDao.deleteById(id);

	}

	
	@Override
	public List<Distrito> finAllDistritos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alquiler findAlquilerById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alquiler saveAlquiler(Alquiler alquiler) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void deleteAlquilerByid(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Auto> findAutoByNombre(String term) {
		// TODO Auto-generated method stub
		return null;
	}

}
