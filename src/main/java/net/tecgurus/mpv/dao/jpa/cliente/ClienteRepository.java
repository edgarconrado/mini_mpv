package net.tecgurus.mpv.dao.jpa.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import net.tecgurus.mpv.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
