package br.com.fabianoLuiz3103.apiVendas.dto;

import jakarta.validation.Valid;

public record CadastroVenda(


        @Valid
        DadosVenda venda,
        @Valid
        DadosVendedorVenda vendedor
) {
}
