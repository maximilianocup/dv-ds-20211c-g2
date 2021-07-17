package ar.edu.davinci.dvds20211cg2.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ar.edu.davinci.dvds20211cg2.domain.Prenda;
import ar.edu.davinci.dvds20211cg2.domain.TipoPrenda;
import ar.edu.davinci.dvds20211cg2.exception.BusinessException;
import ar.edu.davinci.dvds20211cg2.repository.PrendaRepository;

@Service
public class PrendaServiceImpl implements PrendaService {
	
	
	private final Logger LOGGER = LoggerFactory.getLogger(PrendaServiceImpl.class);	
	
	private final PrendaRepository repository;
	
	@Autowired
	public PrendaServiceImpl(final PrendaRepository repository) {
		this.repository = repository;
	}

	@Override
	public Prenda save(Prenda prenda) throws BusinessException {
		LOGGER.debug("Grabamos la prenda con el id: " + prenda.getId());
		
		if (prenda.getId() == null) {
			return repository.save(prenda);
		}
		throw new BusinessException("No se puede crear una prenda con un id específico");		
		
	}

	@Override
	public Prenda update(Prenda prenda) throws BusinessException {
		LOGGER.debug("Modificamos la prenda con el id: " + prenda.getId());
		
		if (prenda.getId() != null) {
			return repository.save(prenda);
		}
		throw new BusinessException("No se puede modificar una prenda no creada");		
	}

	@Override
	public void delete(Prenda prenda) {
		LOGGER.debug("Borrando la prenda con el id: " + prenda.getId());
		
		repository.delete(prenda);
	}		

	@Override
	public void delete(Long id) {
		LOGGER.debug("Borrando la prenda con el id: " + id);
		
		repository.deleteById(id);
	}		

	
	@Override
	public Prenda findById(Long id) throws BusinessException {
		LOGGER.debug("Busqueda de una prenda por ID");
		
		Optional<Prenda> prendaOptional = repository.findById(id);
		if (prendaOptional.isPresent()) {
			return prendaOptional.get();
		}
		
		throw new BusinessException("No se encotró la prenda por el id: " + id);
	}

	@Override
	public List<Prenda> list() {
		LOGGER.debug("Listado de todas las prendas");
		
		return repository.findAll();
	}

	@Override
	public Page<Prenda> list(Pageable pageable) {
		LOGGER.debug("Listado de todas las prendas paginadas");
		LOGGER.debug("Pageable, offset:" + pageable.getOffset() + ", pageSize: " + pageable.getPageSize()+ ", pageNumber: " + pageable.getPageNumber());
		
		return repository.findAll(pageable);
	}

	@Override
	public long count() {
		return repository.count();
	}

	@Override
	public List<TipoPrenda> getTipoPrendas() {
		return TipoPrenda.getTipoPrendas();
	}
	

}
