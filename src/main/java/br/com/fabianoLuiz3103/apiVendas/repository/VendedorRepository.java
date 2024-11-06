package br.com.fabianoLuiz3103.apiVendas.repository;

import br.com.fabianoLuiz3103.apiVendas.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
}
