package br.com.fabianoLuiz3103.apiVendas.dto;

import java.time.LocalDate;

public record LeituraVenda(

        String nome,
        String email,
        Double total,
        LocalDate date,
        Double comissao,
        String status
) {
}
