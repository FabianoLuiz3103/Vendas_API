package br.com.fabianoLuiz3103.apiVendas.dto;

import br.com.fabianoLuiz3103.apiVendas.model.Venda;

import java.time.LocalDate;

public record LeituraVenda(

        Long id,
        String nome,
        String email,
        Double total,
        LocalDate date,
        Double comissao,
        String status
) {
    public LeituraVenda(Venda venda){
        this(
                venda.getId(),
                venda.getVendedor().getNome(),
                venda.getVendedor().getEmail(),
                venda.getTotal(),
                venda.getData(),
                venda.getComissao(),
                venda.getStatus()
        );
    }
}
