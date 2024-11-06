package br.com.fabianoLuiz3103.apiVendas.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record DadosVenda(

        @NotNull(message = "O valor total da venda é obrigatório! ")
        @Positive(message = "O valor total da venda deve ser positivo! ")
        Double total,
        @NotNull(message = "A data da venda é obrigatória! ")
        @PastOrPresent(message = "A data da venda não pode ser futura! ")
        LocalDate data
) {
}
