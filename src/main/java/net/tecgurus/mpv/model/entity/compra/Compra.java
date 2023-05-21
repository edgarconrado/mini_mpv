package net.tecgurus.mpv.model.entity.compra;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import net.tecgurus.mpv.model.entity.Cliente;
import net.tecgurus.mpv.model.entity.Usuario;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "compra")
public class Compra {
    @Id
    @Column(name = "idcompra")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompra;

    @Column(name = "total")
    private Double total;

    @Column(name = "fecha")
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "idcliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "idcompra")
    private List<CompraProducto> productos;
}
