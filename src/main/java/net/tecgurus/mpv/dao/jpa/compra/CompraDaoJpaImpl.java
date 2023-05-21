package net.tecgurus.mpv.dao.jpa.compra;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.tecgurus.mpv.dao.ICompraDao;
import net.tecgurus.mpv.model.entity.compra.Compra;

@Repository
@RequiredArgsConstructor
public class CompraDaoJpaImpl implements ICompraDao{
	
	private final CompraRepository compraRepository;
	
	@PersistenceContext
	public EntityManager em;

	@Override
	@Transactional
	public void create(Compra compra) {
		this.compraRepository.saveAndFlush(compra);
		this.em.refresh(this.em.merge(compra));
	}

	@Override
	public Compra getById(Long id) {
		return this.compraRepository.getReferenceById(id);
	}

	@Override
	public List<Compra> listAll() {
		return this.compraRepository.findAll();
	}

}
