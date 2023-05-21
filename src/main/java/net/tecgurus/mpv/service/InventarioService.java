package net.tecgurus.mpv.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.tecgurus.mpv.dao.IInventarioDao;
import net.tecgurus.mpv.model.dto.InventarioDto;
import net.tecgurus.mpv.model.mapper.InventarioMapper;

@Service
@RequiredArgsConstructor
public class InventarioService {

	private final IInventarioDao inventarioDao;
	private final InventarioMapper inventarioMapper;
	
	public List<InventarioDto> generateInventory(){
		return this.inventarioDao.generateInventory().stream().
		map(this.inventarioMapper::toDto)
		.toList();
	}
	
}