package net.tecgurus.mpv.dao.jpa.categoria;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import net.tecgurus.mpv.dao.ICategoriaDao;
import net.tecgurus.mpv.model.entity.producto.Categoria;

@Repository
@RequiredArgsConstructor
public class CategoriaDaoJPAImpl implements ICategoriaDao{
	
	private final CategoriaRepository categoriaRepository;

	@Override
	public void create(Categoria categoria) {
		this.categoriaRepository.save(categoria);
	}

	@Override
	public List<Categoria> listAll() {
		return this.categoriaRepository.findAll();
	}

}
