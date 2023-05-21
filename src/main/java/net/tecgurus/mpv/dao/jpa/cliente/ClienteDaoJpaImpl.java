package net.tecgurus.mpv.dao.jpa.cliente;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import net.tecgurus.mpv.dao.IClienteDao;
import net.tecgurus.mpv.model.entity.Cliente;

@Repository
@RequiredArgsConstructor
public class ClienteDaoJpaImpl implements IClienteDao{

	private final ClienteRepository clienteRepository;
	
	@Override
	public List<Cliente> listAll() {
		return this.clienteRepository.findAll();
	}

}
