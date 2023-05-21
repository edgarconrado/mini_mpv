package net.tecgurus.mpv.model.mapper;

import javax.annotation.processing.Generated;
import net.tecgurus.mpv.model.dto.ClienteDto;
import net.tecgurus.mpv.model.entity.Cliente;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-20T13:47:43-0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public ClienteDto toDto(Cliente entity) {
        if ( entity == null ) {
            return null;
        }

        ClienteDto clienteDto = new ClienteDto();

        clienteDto.setIdCliente( entity.getIdCliente() );
        clienteDto.setNombre( entity.getNombre() );
        clienteDto.setAPaterno( entity.getAPaterno() );
        clienteDto.setAMaterno( entity.getAMaterno() );
        clienteDto.setRfc( entity.getRfc() );

        return clienteDto;
    }

    @Override
    public Cliente toEntity(ClienteDto dto) {
        if ( dto == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setIdCliente( dto.getIdCliente() );
        cliente.setNombre( dto.getNombre() );
        cliente.setAPaterno( dto.getAPaterno() );
        cliente.setAMaterno( dto.getAMaterno() );
        cliente.setRfc( dto.getRfc() );

        return cliente;
    }
}
