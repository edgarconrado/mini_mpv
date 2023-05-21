package net.tecgurus.mpv.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.tecgurus.mpv.dao.IClienteDao;
import net.tecgurus.mpv.model.dto.ClienteDto;
import net.tecgurus.mpv.model.mapper.ClienteMapper;

@Service
@RequiredArgsConstructor
public class ClienteService {
	private final IClienteDao clienteDao;
	private final ClienteMapper clienteMapper;
	
	public List<ClienteDto> listAll(){
		return this.clienteDao.listAll().stream()
				.map(this.clienteMapper::toDto)
				.toList();
	}
}
