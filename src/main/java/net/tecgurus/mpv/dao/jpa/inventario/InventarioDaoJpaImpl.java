package net.tecgurus.mpv.dao.jpa.inventario;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import net.tecgurus.mpv.dao.IInventarioDao;
import net.tecgurus.mpv.model.entity.Inventario;

@Repository
@RequiredArgsConstructor
public class InventarioDaoJpaImpl implements IInventarioDao {

	private final InventarioRepository inventarioRepository;
	
	@Override
	public List<Inventario> generateInventory() {
		return this.inventarioRepository.generarInventario();
	}

}