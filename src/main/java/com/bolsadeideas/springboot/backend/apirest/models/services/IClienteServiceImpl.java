package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.backend.apirest.models.dao.IAlquilerDao;
import com.bolsadeideas.springboot.backend.apirest.models.dao.IAutoDao;
import com.bolsadeideas.springboot.backend.apirest.models.dao.IClienteDao;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Alquiler;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Auto;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Cliente;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Distrito;

@Service
public class IClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;

	@Autowired
	private IAlquilerDao alquilerDao;

	@Autowired
	private IAutoDao autoDao;

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

	/* Dsitrito */

	@Override
	@Transactional
	public List<Distrito> finAllDistritos() {
		return clienteDao.findAllDistritos();
	}

	/* Alquiler */

	@Override
	@Transactional(readOnly = true)
	public Alquiler findAlquilerById(Long id) {
		return alquilerDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Alquiler saveAlquiler(Alquiler alquiler) {
		return alquilerDao.save(alquiler);
	}

	@Override
	@Transactional
	public void deleteAlquilerById(Long id) {
		alquilerDao.deleteById(id);
	}

	/* Autos */
	@Override
	@Transactional(readOnly = true)
	public List<Auto> findAutoByNombre(String term) {
		return autoDao.findByNombreStartingWithIgnoreCase(term);
	}

}
