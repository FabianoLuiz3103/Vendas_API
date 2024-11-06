package br.com.fabianoLuiz3103.apiVendas.model;

import br.com.fabianoLuiz3103.apiVendas.dto.DadosVendedor;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})

@Entity
@Table(name = "tb_vendedor")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "vendedor")
    private List<Venda> vendas = new ArrayList<>();

    public Vendedor(DadosVendedor dadosVendedor){
        if(dadosVendedor.nome() !=  null){
            this.nome = dadosVendedor.nome();
        }
        if(dadosVendedor.email() != null){
            this.email = dadosVendedor.email();
        }
    }
}
