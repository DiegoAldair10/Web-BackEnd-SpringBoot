package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.backend.apirest.models.dao.IAutoDao;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Auto;

@Service
public class IAutoServiceImpl implements IAutoService {

	@Autowired
	private IAutoDao autoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Auto> findAll() {

		return (List<Auto>) autoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Auto> findAll(Pageable pageable) {
		return autoDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Auto findById(Long id) {
		return autoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Auto save(Auto auto) {
		return autoDao.save(auto);
	}

	@Override
	@Transactional
	public void delete(Long id) {

		autoDao.deleteById(id);

	}

}
