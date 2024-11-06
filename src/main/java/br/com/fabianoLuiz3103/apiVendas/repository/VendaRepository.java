package br.com.fabianoLuiz3103.apiVendas.repository;

import br.com.fabianoLuiz3103.apiVendas.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}
