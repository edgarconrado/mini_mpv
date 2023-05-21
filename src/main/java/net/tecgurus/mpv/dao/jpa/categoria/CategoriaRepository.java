package net.tecgurus.mpv.dao.jpa.categoria;

import org.springframework.data.jpa.repository.JpaRepository;

import net.tecgurus.mpv.model.entity.producto.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
