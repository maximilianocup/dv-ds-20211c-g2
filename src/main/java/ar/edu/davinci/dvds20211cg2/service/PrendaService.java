package ar.edu.davinci.dvds20211cg2.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ar.edu.davinci.dvds20211cg2.domain.Prenda;
import ar.edu.davinci.dvds20211cg2.domain.TipoPrenda;
import ar.edu.davinci.dvds20211cg2.exception.BusinessException;

public interface PrendaService {
	
	Prenda save(Prenda prenda) throws BusinessException;
	Prenda update(Prenda prenda) throws BusinessException;
	void delete(Prenda prenda);
	void delete(Long id);
	

	Prenda findById(Long id) throws BusinessException;
	
	List<Prenda> list();
	Page<Prenda> list(Pageable pageable);
	long count();
	List<TipoPrenda> getTipoPrendas();

	
}
