package br.com.fabianoLuiz3103.apiVendas.dto;

import br.com.fabianoLuiz3103.apiVendas.model.Vendedor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosVendedor(

        @NotBlank(message = "Nome é obrigatório! ")
        String nome,
        @Email(message = "Formato de e-mail inválido!")
        @NotBlank(message = "E-mail é obrigatório! ")
        String email
) {
        public DadosVendedor(Vendedor vendedor){
                this(
                        vendedor.getNome(),
                        vendedor.getEmail()
                );
        }
}
