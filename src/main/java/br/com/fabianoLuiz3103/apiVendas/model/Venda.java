package br.com.fabianoLuiz3103.apiVendas.model;

import br.com.fabianoLuiz3103.apiVendas.dto.DadosVenda;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})

@Entity
@Table(name="tb_venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double total;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private Double comissao;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_vendedor", nullable = false)
    private Vendedor vendedor;

    public Venda(DadosVenda dadosVenda){
        if(dadosVenda.total() != null){
            this.total = dadosVenda.total();
        }
        if(dadosVenda.data() != null){
            this.data = dadosVenda.data();
        }
    }
}
